using System;
using System.Collections.Generic;
using System.Linq;
using Xunit;


namespace util
{
    public class ListSizeMonitor<T>
    {
        private List<T> _currentCollection = new();
        private Dictionary<int, int> _indexHashMap = new();


        /// <summary>
        /// Raised when an item is added to the monitored collection.
        /// </summary>
        /// <param name="item">The added item.</param>
        /// <param name="index">The index at which the item was added.</param>
        public event Action<T, int>? OnIncrease;
        
        /// <summary>
        /// Raised when the list shrinks and items are removed from the end.
        /// </summary>
        /// <param name="item">The removed item.</param>
        /// <param name="index">The index from which the item was removed.</param>
        public event Action<T, int>? OnDecrease;

        /// <summary>
        /// Raised when an item is removed from the monitored collection.
        /// </summary>
        /// <param name="item">The removed item.</param>
        /// <param name="index">The index from which the item was removed.</param>
        public event Action<T, int>? OnRemove;

        /// <summary>
        /// Raised when an item in the collection is updated.
        /// </summary>
        /// <param name="item">The updated item.</param>
        /// <param name="index">The index of the updated item.</param>
        public event Action<T, int>? OnUpdate;

        /// <summary>
        /// Raised when an item is set, either by being added or updated.
        /// </summary>
        /// <param name="item">The set item.</param>
        /// <param name="index">The index at which the item was set.</param>
        public event Action<T, int>? OnSet;

        /// <summary>
        /// Raised when an item is replaced by a different item at the same index.
        /// </summary>
        /// <param name="oldItem">The old item.</param>
        /// <param name="newItem">The new item.</param>
        /// <param name="index">The index at which the replacement occurred.</param>
        public event Action<T, T, int>? OnUpdateWithOld;

        public void Update(ICollection<T>? newCollection)
        {
            var oldList = _currentCollection;
            var oldHashMap = new Dictionary<int, int>(_indexHashMap);

            if (newCollection == null)
            {
                for (int i = 0; i < oldList.Count; i++)
                    OnRemove?.Invoke(oldList[i], i);

                _currentCollection.Clear();
                _indexHashMap.Clear();
                return;
            }

            var newList = newCollection.ToList();

            // Updates
            int minCount = Math.Min(oldList.Count, newList.Count);
            for (int i = 0; i < minCount; i++)
            {
                int newHash = newList[i]?.GetHashCode() ?? 0;
                if (!oldHashMap.TryGetValue(i, out int oldHash) || oldHash != newHash)
                {
                    OnSet?.Invoke(newList[i], i);
                    OnUpdate?.Invoke(newList[i], i);
                    OnUpdateWithOld?.Invoke(oldList[i], newList[i], i);
                }
            }

            // Increases
            for (int i = oldList.Count; i < newList.Count; i++)
            {
                OnIncrease?.Invoke(newList[i], i);
                OnSet?.Invoke(newList[i], i);
            }

            // OnRemove for items that are either removed or replaced at their index
            for (int i = 0; i < oldList.Count; i++)
            {
                if (i >= newList.Count || !EqualityComparer<T>.Default.Equals(oldList[i], newList[i]))
                    OnRemove?.Invoke(oldList[i], i);
            }
            
            // Decreases (list shrunk)
            if (oldList.Count > newList.Count)
            {
                for (int i = newList.Count; i < oldList.Count; i++)
                    OnDecrease?.Invoke(oldList[i], i);
            }

            // Update state
            _currentCollection = newList;
            _indexHashMap.Clear();
            for (int i = 0; i < newList.Count; i++)
                _indexHashMap[i] = newList[i]?.GetHashCode() ?? 0;
        }
    }
}


namespace util
{
    public class ListSizeMonitorTests
    {
        [Fact]
        public void Update_CallsOnIncrease_ForAddedItems()
        {
            var increased = new List<(int value, int index)>();
            var monitor = new ListSizeMonitor<int>();
            monitor.OnIncrease += (x, idx) => increased.Add((x, idx));

            monitor.Update(new List<int> { 1, 2 });
            Assert.Contains((1, 0), increased);
            Assert.Contains((2, 1), increased);
        }

        [Fact]
        public void Update_CallsOnDecrease_ForRemovedItems()
        {
            var decreased = new List<(int value, int index)>();
            var monitor = new ListSizeMonitor<int>();
            monitor.OnRemove += (x, idx) => decreased.Add((x, idx));

            monitor.Update(new List<int> { 1, 2 });
            monitor.Update(new List<int> { 2 });
            Assert.Contains((1, 0), decreased);
        }

        [Fact]
        public void Update_CallsOnUpdate_ForChangedItems()
        {
            var updated = new List<(string value, int index)>();
            var monitor = new ListSizeMonitor<string>();
            monitor.OnUpdate += (x, idx) => updated.Add((x, idx));

            monitor.Update(new List<string> { "a", "b" });
            monitor.Update(new List<string> { "a", "B" });

            Assert.Contains(("B", 1), updated);
        }

        [Fact]
        public void Update_NullList_CallsOnDecreaseForAllAndClears()
        {
            var decreased = new List<(int value, int index)>();
            var monitor = new ListSizeMonitor<int>();
            monitor.OnRemove += (x, idx) => decreased.Add((x, idx));

            monitor.Update(new List<int> { 1, 2 });
            monitor.Update(null);
            Assert.Contains((1, 0), decreased);
            Assert.Contains((2, 1), decreased);
        }

        [Fact]
        public void Update_CallsOnSet_ForAddedAndUpdatedItems()
        {
            var setEvents = new List<(string value, int index)>();
            var monitor = new ListSizeMonitor<string>();
            monitor.OnSet += (x, idx) => setEvents.Add((x, idx));

            monitor.Update(new List<string> { "a", "b" }); // Should trigger for both
            monitor.Update(new List<string> { "A", "b", "c" }); // Should trigger for index 0 (update) and 2 (add)

            Assert.Contains(("a", 0), setEvents);
            Assert.Contains(("b", 1), setEvents);
            Assert.Contains(("A", 0), setEvents);
            Assert.Contains(("c", 2), setEvents);
        }

        [Fact]
        public void Update_CallsOnItemReplaced_ForChangedItems()
        {
            var replaced = new List<(string oldValue, string newValue, int index)>();
            var monitor = new ListSizeMonitor<string>();
            monitor.OnUpdateWithOld += (oldVal, newVal, idx) => replaced.Add((oldVal, newVal, idx));

            monitor.Update(new List<string> { "a", "b", "c" });
            monitor.Update(new List<string> { "a", "B", "c" }); // Only index 1 changes

            Assert.Single(replaced);
            Assert.Equal(("b", "B", 1), replaced[0]);
        }
    }
}