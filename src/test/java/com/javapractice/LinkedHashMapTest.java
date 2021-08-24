package com.javapractice;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class MyMapNode<K,V> implements INode<k> {
    K key;
    V value;
    MyMapNode<K,V> next;

    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey()
    {
        return key;
    }
    public void setKey(K key)
    {
        this.key = key;
    }
    public INode<K> getNext()
    {
        return next;
    }
    public void setNext(INode<k>next)
    {
        this.next = (MyMapNode<K,V>) next;
    }
    public V getValue()
    {
        return this.value;
    }
    public void setValue(V value)
    {
        this.value = value;
    }

    @Override
    public String toString() {
        //
    }
}

class LinkedHashMapTest {
    public class MyHashMap<k,v> {
        LinkedList<k> myLinkedList;
        public MyHashMap() {
            this.myLinkedList = new LinkedList<>();
        }
    }
}