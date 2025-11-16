package ro.anud.xml_xsd.implementation.util;

public interface ChangeCallback<T extends LinkedNode> {
    void onChange(LinkedNode origin, T t);
}
