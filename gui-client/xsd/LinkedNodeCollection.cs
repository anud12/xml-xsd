using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using XSD.Nworld_step.Nactions;

namespace XSD
{
    public class LinkedNodeCollection<T> : IEnumerable<T> where T : ILinkedNode
    {
        private readonly Dictionary<int, T> _map = new();
        private readonly Dictionary<T, int> _reverseMap = new();
        private int _maxKey = -1;
        public Action<T> OnAdd = _ => { };
        
        public int Count => _map.Count;

        public LinkedNodeCollection() { }

        public LinkedNodeCollection(List<T> list)
        {
            for (int i = 0; i < list.Count; i++)
            {
                _map[i] = list[i];
                _reverseMap[list[i]] = i;
            }
            _maxKey = list.Count - 1;
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
    }
}