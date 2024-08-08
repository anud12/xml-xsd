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

        private List<Action<T?, Action>> callbackList = new List<Action<T?, Action>>();

        private void ExecuteCallbacks()
        {
            callbackList.ToList().ForEach(callback => callback(data, () => callbackList.Remove(callback)));
        }
        public Action OnSave(Action<T?, Action> callback)
        {
            var unsubscribe = () => {
                callbackList.Remove(callback);
            };
            callbackList.Add(callback);
            if(data != null)
            {
                callback(data, unsubscribe);
            }
            return () => callbackList.Remove(callback);
        }
    }
}