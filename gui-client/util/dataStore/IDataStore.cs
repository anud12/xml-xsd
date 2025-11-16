using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;
using Godot;

namespace util.dataStore
{

    public class DataStore<T>
    {
        private T? _data;
        private List<Func<T?, T?>> _queueMutation =  new();
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
                ExecutionContext.Run(callback.Item2, (object? state) =>
                {
                    var newData = data;
                    foreach (var func in _queueMutation)
                    {
                        newData = func(newData);
                    }
                    _queueMutation.Clear();
                    callback.Item1(newData, () => {
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

        public void QueueSet(Func<T?, T?> data)
        {
            this._queueMutation.Add(data);
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

        public Action OnSetOld(Action<T?, Action> callback)
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

        public Action OnSet(Node node, Action<T?, Action> callback)
        {
            var context = ExecutionContext.Capture();
            var unsubscribe = () => {
                callbackList.Remove((callback, context));
            };
            callbackList.Add(((arg1, action) =>
            {
                if (GodotObject.IsInstanceValid(node) == false)
                {
                    unsubscribe();
                    return;
                }
                callback(arg1, action);
            }, context));
            if(data != null && GodotObject.IsInstanceValid(node) == true)
            {
                callback(data, unsubscribe);
            }
            return () => callbackList.Remove((callback, context));
        }
    }
}