using System;
using System.Collections.Generic;
using Godot;
using repository;
using util.dataStore;
using XSD.Nworld_step.Ndata.Nlocation;
using XSD.Nworld_step.Ndata.Nlocation.Nlocation_graph;
using XSD.Nworld_step.Ndata.Npeople;

namespace util.repository
{
    public class Repository<T>
    {

        public static PersonRepository Person = new PersonRepository();
        public static NodeRepository Node = new NodeRepository();
        public static LocationGraphRepository LocationGraph = new LocationGraphRepository();

        private Dictionary<string, DataStore<T>> _data = new Dictionary<string, DataStore<T>>();

        private Func<T, string> _idGetter;
        public Repository(Func<T, string> idGetter)
        {
            this._idGetter = idGetter;
        }

        public Repository<T> Add(T data)
        {
            string id = _idGetter(data);
            if (_data.ContainsKey(id))
            {
                _data[id].Set(data);
            }
            else
            {
                _data.Add(id, new DataStore<T>(data));
            }
            return this;
        }

        public T? Get(string id)
        {
            if (_data.ContainsKey(id))
            {
                return _data[id].data;
            }
            return default(T);
        }

        public DataStore<T>? GetDataStore(string id)
        {
            if (_data.ContainsKey(id))
            {
                return _data[id];
            }
            return null;
        }

        public Repository<T> Remove(string id)
        {
            if (_data.ContainsKey(id))
            {
                _data.Remove(id);
            }
            return this;
        }

        public void Clear()
        {
            _data.Clear();
        }
    }
}