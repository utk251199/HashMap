package org.example;

public class ChainingStrategy<K,V> implements CollisionStrategy<K,V> {

    @Override
    public void put(HashMapLocal.Entry<K,V>[] table, K key, V value) {
        int index = key.hashCode() % table.length;
        HashMapLocal.Entry<K,V> node = table[index];
        HashMapLocal.Entry<K,V> newNode = new HashMapLocal.Entry<>(key,value);

        if (node == null) {
            table[index] = newNode;
        } else {
            while(node.getNext() != null) {
                if (node.getKey().equals(key)) { // update if same key
                    node.setValue(value);
                    return;
                }
                node = node.getNext();
            }
            node.setNext(newNode);
        }
    }

    public V get(HashMapLocal.Entry<K,V>[] table, K key) {
        int index = key.hashCode() % table.length;
        HashMapLocal.Entry<K,V> node = table[index];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }
}
