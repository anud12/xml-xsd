using System;
using System.Collections.Generic;
using System.Xml;

namespace XSD {
    public interface ILinkedNode
    {
        public ILinkedNode? ParentNode { get; set; }
        
        public string NodeName { get;}
        public int? BuildIndexForChild(ILinkedNode linkedNode);
        
        void NotifyChange(List<ILinkedNode> linkedNodes);

        public RawNode SerializeIntoRawNode();
        
        public bool IsValidChildType(ILinkedNode candidateChild);

        public void Serialize(XmlElement element);
        
        public void SetAttribute(string name, string? value);
        
        public void SetChild(dynamic linkedNode);
        public void ClearChild(dynamic linkedNode);

        public void DeserializeAtPath(string xpath, RawNode rawNode);

        public Action OnChange(Action<List<ILinkedNode>> callback);
        public Action OnSelfChangeNode(Action<ILinkedNode> callback);

        public string BuildPath()
        {
            var index = ParentNode?.BuildIndexForChild(this) ?? 0;
            var path = "." + NodeName + "[" + index + "]";
            if (ParentNode == null)
            {
                return path;
            }
            return ParentNode.BuildPath() + path;
        }

    }
}