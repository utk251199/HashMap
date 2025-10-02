package org.example;

public interface MapLocal<K,V> {

    void put(K key,V value);

    V get(K key);

}
