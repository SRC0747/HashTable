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

public class LinkedHashMap<k,v> {
    private final int numBucket;
    ArrayList<LinkedList<k>> myBucketArray;

    public LinkedHashMap() {
        this.numBucket = 10;
        this.myBucketArray = new ArrayList<>(numBucket);
        //Create Empty Linked List
        for (int i = 0; i< numBucket; i++)
            this.myBucketArray.add(null);
    }
    //This implements hash to find index for a key.
    private int getBucketIndex(k key)
    {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode%numBucket;
        return index;
    }
    public V get(K key)
    {
        int index = this.getBucketIndex(key);
        LinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList==null)
            return null;
        MyMapNode<K,V> myMapNode = (MyMapNode<K,V>) myLinkedList.search(key);
        return (myMapNode == null) ? null:myMapNode.getValue();
    }
    public void add(K key,V value){
        int index = this.getBucketIndex(key);
        LinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList == null){
            myLinkedList = new LinkedList<>();
            this.myBucketArray.set(index,myLinkedList);
        }
        MyMapNode<K,V> myMapNode = (MyMapNode<K,V>) myLinkedList.search(key);
        if (myMapNode == null){
            myMapNode = new MyMapNode<>(key,value);
            LinkedList.append(myMapNode);
        }
        else{
            myMapNode.setValue(value);
        }
    }

    @Override
    public String toString() {
        return "MyLinked HashMap List{" + myBucketArray + '}';
    }
}

