using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;

namespace util.dataStore
{

    public class DataStore<T>
    {
        private T? _data;
        public bool isSend { get; set; } = false;

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

        private List<(Action<T?, Action>, ExecutionContext?)> callbackList = new List<(Action<T?, Action>, ExecutionContext?)>();

        public DataStore()
        {
        }
        public DataStore(T? data)
        {
            this._data = data;
        }

        private void ExecuteCallbacks()
        {
            callbackList.ToList().ForEach(callback => {
                // callback.Item1(_data, () => {
                //     callbackList.Remove(callback);
                // });
                ExecutionContext.Run(callback.Item2, (object? state) => {
                    callback.Item1(_data, () => {
                        callbackList.Remove(callback);
                    });
                }, null);
            });
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

        public void QueueSet(T? data)
        {
            if(data != null && data.Equals(_data))
            {
                return;
            }
            this._data = data;
            isSend = false;
        }

        public void Dispatch()
        {
            if(isSend)
            {
                return;
            }
            isSend = true;
            this.ExecuteCallbacks();
        }

        public Action OnSet(Action<T?, Action> callback)
        {
            var context = ExecutionContext.Capture();
            var unsubscribe = () => {
                callbackList.Remove((callback, context));
            };
            callbackList.Add((callback, context));
            if(data != null)
            {
                callback(data, unsubscribe);
            }
            return () => callbackList.Remove((callback, context));
        }
    }
}