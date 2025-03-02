using System.Collections.Generic;

namespace XSD {
    public interface ILinkedNode
    {
        public ILinkedNode? ParentNode { get; set; }
        
        public string NodeName { get;}
        public int? BuildIndexForChild(ILinkedNode linkedNode);
        
        void ChildChanged(List<ILinkedNode> linkedNodes);

        public RawNode SerializeIntoRawNode();

        public void SetXPath(string xpath, RawNode rawNode);

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