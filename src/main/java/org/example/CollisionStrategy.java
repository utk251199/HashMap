package org.example;

public interface CollisionStrategy<K,V> {
    void put(HashMapLocal.Entry<K,V>[] table, K key, V value);
    V get(HashMapLocal.Entry<K,V>[] table, K key);
}
