package org.example;

public class HashMapLocal <K,V> implements MapLocal <K,V>{

    private final Entry<K,V>[] hashTable;
    private final CollisionStrategy<K,V> collisionStrategy;

    private static final int DEFAULT_CAPACITY = 1<<4;
    private static final int MAX_CAPACITY = 1<<30;

    public HashMapLocal(CollisionStrategy<K,V> collisionStrategy){
        this(DEFAULT_CAPACITY,collisionStrategy);
    }

    @SuppressWarnings("unchecked")
    public HashMapLocal(int capacity,CollisionStrategy<K,V> collisionStrategy){
        hashTable = new Entry[nextPowerOfTwo(capacity)];
        this.collisionStrategy = collisionStrategy;
    }

    static class Entry<K,V>{

        private final K key;
        private V value;
        private Entry<K,V> next;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }

    public void put(K key,V value){
        collisionStrategy.put(hashTable,key,value);
    }

    public V get(K key){
        return collisionStrategy.get(hashTable,key);
    }

    private static int nextPowerOfTwo(int n) {
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n >= MAX_CAPACITY ? MAX_CAPACITY : n + 1;
    }

}