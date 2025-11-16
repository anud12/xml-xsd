package ro.anud.xml_xsd.implementation.util;

public interface RemoveCallback<T extends LinkedNode> {
    void onRemove(LinkedNode origin, T t);
}
