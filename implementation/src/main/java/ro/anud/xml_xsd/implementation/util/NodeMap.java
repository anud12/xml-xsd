package ro.anud.xml_xsd.implementation.util;

import java.util.*;
import java.util.stream.Stream;

public class NodeMap<Value> implements Map<Integer, Value> {

    private HashMap<Integer, Value> map = new HashMap<>();
    private HashMap<Value, Integer> reversedMap = new HashMap<>();
    private int highestInt = Integer.MIN_VALUE;

    public void add(Value value) {

        put(highestInt + 1, value);
    }

    public void add(Integer key, Value value) {
        if (key > highestInt) {
            highestInt = key;
        }
        put(key, value);
    }

    public int getHighestInt() {
        return highestInt;
    }

    public Stream<Value> stream() {
        return map.values().stream();
    }

    public List<Value> asList() {
        return map.values().stream().toList();
    }

    public Integer keyOf(Value value) {
        return reversedMap.get(value);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return reversedMap.containsKey(value);
    }

    @Override
    public Value get(Object key) {
        return map.get(key);
    }

    @Override
    public Value put(Integer key, Value value) {
        if (map.containsKey(key)) {
            reversedMap.remove(map.get(key));
        }
        if (reversedMap.containsKey(value)) {
            map.remove(reversedMap.get(value));
        }
        reversedMap.put(value, key);
        return map.put(key, value);
    }

    @Override
    public Value remove(Object key) {
        Value value = map.remove(key);
        if (value != null) {
            reversedMap.remove(value);
        }
        return value;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Value> m) {
        for (Entry<? extends Integer, ? extends Value> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        map.clear();
        reversedMap.clear();
        highestInt = Integer.MIN_VALUE;
    }

    @Override
    public Set<Integer> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<Value> values() {
        return map.values();
    }

    @Override
    public Set<Entry<Integer, Value>> entrySet() {
        return map.entrySet();
    }
}