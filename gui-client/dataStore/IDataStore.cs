using System;
using System.Collections.Generic;
using System.Linq;

namespace dataStore
{

    public class DataStore<T>
    {
        private T? _data;

        /// <summary>
        /// The data stored in the data store, setting the data will execute all the callbacks if the data is not equal to the previous data
        /// </summary>
        public T? data {
            get {
                return _data;
            }
            set {
                this.Set(value);
            }
        }

        private List<Action<T?, Action>> callbackList = new List<Action<T?, Action>>();

        private void ExecuteCallbacks()
        {
            callbackList.ToList().ForEach(callback => callback(data, () => callbackList.Remove(callback)));
        }

        /// <summary>
        /// Set the data and execute the callbacks ignoring if the data is the same
        /// </summary>
        /// <param name="data"></param>
        public void Set(T? data)
        {
            if(data != null && data.Equals(_data))
            {
                return;
            }
            this._data = data;
            this.ExecuteCallbacks();
        }
        public Action OnSet(Action<T?, Action> callback)
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