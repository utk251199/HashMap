package org.example;

public class Main {
    public static void main(String[] args) {
            MapLocal<Integer,Integer> hashMapLocal = new HashMapLocal<>(45324546, new ChainingStrategy<>());
            hashMapLocal.put(1,15);
            hashMapLocal.put(17,150);
            System.out.println(hashMapLocal.get(17));

        }
    }