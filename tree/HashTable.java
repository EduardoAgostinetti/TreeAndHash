package com.mycompany.tree;

import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private List<Node>[] table;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new ArrayList<>();
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void insert(int key, Object value) {
        int index = hash(key);
        Node newNode = new Node();
        newNode.setKey(key);
        newNode.setValue(value);
        table[index].add(newNode);
    }

    public Object get(int key) {
        int index = hash(key);
        List<Node> nodes = table[index];
        for (Node node : nodes) {
            if (node.getKey() == key) {
                return node.getValue();
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        List<Node> nodes = table[index];
        for (Node node : nodes) {
            if (node.getKey() == key) {
                nodes.remove(node);
                break;
            }
        }
    }

    public void print() {
        for (int i = 0; i < capacity; i++) {
            List<Node> nodes = table[i];
            for (Node node : nodes) {
                System.out.println(node.getKey() + ": " + node.getValue());
            }
        }
    }
    
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        hashTable.insert(30, "370");
        hashTable.insert(10, "530");
        hashTable.insert(20, "5340");
        hashTable.insert(60, "250");
        hashTable.insert(550, "350");
        hashTable.insert(530, "505");
        hashTable.insert(500, "320");

        System.out.println("Print Keys 30 e 500");
        System.out.println(hashTable.get(30) + ", " + hashTable.get(500));
        System.out.println("Remove Key 500");
        hashTable.remove(500);
        System.out.println("Print Keys 30 e 500");
        System.out.println(hashTable.get(30) + ", " + hashTable.get(500));
        
        System.out.println("Print hashTable");
        hashTable.print();
    }
}
