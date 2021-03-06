package com.javapractice;

import static org.junit.jupiter.api.Assertions.*;

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
    }

