namespace XSD {
    abstract class LinkedNode {
        protected abstract string nodeName();
        protected abstract LinkedNode? parentNode();

        public abstract int? BuildIndexForChild(LinkedNode linkedNode);
        
        public string BuildPath()
        {
            var index = parentNode()?.BuildIndexForChild(this) ?? 0;
            var path = "/" + nodeName() + "[" + index + "]";
            if (parentNode() != null)
            {
                return parentNode()?.BuildPath() + path;
            }
            return path;
        }
    }
}