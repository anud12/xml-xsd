package ro.anud.xml_xsd.implementation.service;

public interface Repository<T> {
    void index();

    void loadData();

    T getOrDefault(T t);
}
