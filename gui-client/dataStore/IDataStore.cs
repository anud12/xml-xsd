using System;
using System.Collections.Generic;
using System.Linq;

namespace dataStore
{

    public class DataStore<T>
    {
        private T? _data;

        public T? data {
            get {
                return _data;
            }
            set {
                _data = value;
                this.ExecuteCallbacks();
            }
        }

        private List<Action<T?>> callbackList = new List<Action<T?>>();

        private void ExecuteCallbacks()
        {
            callbackList.ToList().ForEach(callback => callback(data));
        }
        public Action OnSave(Action<T?> callback)
        {
            callbackList.Add(callback);
            if(data != null)
            {
                callback(data);
            }
            return () => callbackList.Remove(callback);
        }
    }
}