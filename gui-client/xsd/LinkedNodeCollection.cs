using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using XSD.Nworld_step.Nactions;

namespace XSD
{
    public interface ILinkedNodeCollection
    {
        public void AddILinkedNode(dynamic? linkedNode);
        public void OnILinkedNodeAdd(Action<ILinkedNode> action);
    }
    
    public class LinkedNodeCollection<T> : ICollection<T>, ILinkedNodeCollection where T : ILinkedNode
    {
        private readonly Dictionary<int, T> _map = new();
        private readonly Dictionary<T, int> _reverseMap = new();
        private int _maxKey = -1;
        public Action<T> OnAdd = T => { };
        private List<Action<ILinkedNode>> _onAdd = new();

        void ICollection<T>.Add(T item)
        {
            Add(item);
        }

        public void Clear()
        {
            _map.Clear();
            _reverseMap.Clear();
            _maxKey = -1;
        }

        public bool Contains(T item)
        {
            return _reverseMap.ContainsKey(item);
        }
        
        
        public void CopyTo(T[] array, int arrayIndex)
        {
            if (array == null)
            {
                throw new ArgumentNullException(nameof(array));
            }

            if (arrayIndex < 0 || arrayIndex + _map.Count > array.Length)
            {
                throw new ArgumentOutOfRangeException(nameof(arrayIndex));
            }

            foreach (var item in _map.Values)
            {
                array[arrayIndex++] = item;
            }
        }

        
        public bool Remove(T item)
        {
            if (_reverseMap.TryGetValue(item, out int key))
            {
                _map.Remove(key);
                _reverseMap.Remove(item);
                return true;
            }
            return false;
        }

        public void CopyTo(Array array, int index)
        {
            throw new NotImplementedException();
        }

        public int Count => _map.Count;
        public bool IsSynchronized { get; }
        public object SyncRoot { get; }
        public bool IsReadOnly { get; }

        public LinkedNodeCollection() { }
        
        
        public LinkedNodeCollection(List<T> list)
        {
            for (int i = 0; i < list.Count; i++)
            {
                _map[i] = list[i];
                _reverseMap[list[i]] = i;
            }
            _maxKey = _map.Keys.Any() ? _map.Keys.Max() : -1;
            
        }

        public IEnumerator<T> GetEnumerator()
        {
            return _map.Values.GetEnumerator();
        }

        public T this[int index]
        {
            get
            {
                var type = typeof(T);
                if (_map.TryGetValue(index, out var item))
                {
                    return item;
                }
                var value = (T)Activator.CreateInstance(type, new object[] { })!;
                _map[index] = value;
                _reverseMap[value] = index;
                OnAdd(value);
                _onAdd.ForEach(action => action(value));
                if (index > _maxKey)
                {
                    _maxKey = index;
                }
                return value;
            }
            set
            {
                _map[index] = value;
                _reverseMap[value] = index;
                if (index > _maxKey)
                {
                    _maxKey = index;
                }
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }

        public void ForEach(Action<T> action)
        {
            foreach (var key in _map.Keys.OrderBy(k => k))
            {
                action(_map[key]);
            }
        }

        public bool ContainsKey(int key)
        {
            return _map.ContainsKey(key);
        }

        public LinkedNodeCollection<T> Add(T value)
        {
            int newKey = _maxKey + 1;
            _map[newKey] = value;
            _reverseMap[value] = newKey;
            _maxKey = newKey;
            OnAdd(value);
            _onAdd.ForEach(action => action(value));
            return this;
        }
        
        public int IndexOf(T value)
        {
            foreach (var kvp in _map)
            {
                if (EqualityComparer<T>.Default.Equals(kvp.Value, value))
                {
                    return kvp.Key;
                }
            }
            return -1;
        }

        public int? KeyOf(T linkedNode)
        {
            return _reverseMap[linkedNode];
        }

        public void AddILinkedNode(dynamic? linkedNode)
        {
            this.Add(linkedNode);
        }

        public void OnILinkedNodeAdd(Action<ILinkedNode> action)
        {
            _onAdd.Add(action);
        }
    }
}