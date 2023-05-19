package com.study.collection;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashTable {
    private final int TABLE_SIZE = 250;

    private LinkedList<Node>[] bucket;

    public MyHashTable()
    {
        bucket = new LinkedList[TABLE_SIZE];
    }

    public class Node{
        public String key;
        public String value;

        public Node(String key, String value)
        {
            this.key = key;
            this.value = value;
        }
    }

    public void put(String key, String value)
    {
        int index = getHashIndex(key);
        Node newNode = new Node(key, value);

        LinkedList<Node> foundChainingList = bucket[index];
        if(foundChainingList == null)
        {
            LinkedList<Node> newChainingList = new LinkedList<>();
            newChainingList.addLast(newNode);

            bucket[index] = newChainingList;
        }
        else
        {
            foundChainingList.addLast(newNode);
        }
    }

    public void delete(String key)
    {
        int index = getHashIndex(key);
        LinkedList<Node> foundChainingList = bucket[index];

        if(foundChainingList == null)
        {
            throw new ArrayStoreException("MyHashTable doesn't contain key :" + key);
        }
        else
        {
            Node foundNode = searchInChainList(key, foundChainingList);
            foundChainingList.remove(foundNode);
            if(foundChainingList.stream().count() == 0)
                bucket[index] = null;
        }
    }

    public String get(String key)
    {
        int index = getHashIndex(key);
        LinkedList<Node> foundChainingList = bucket[index];

        if(foundChainingList == null)
        {
            throw new ArrayStoreException("MyHashTable doesn't contain key :" + key);
        }
        else
        {
            Node foundNode = searchInChainList(key, foundChainingList);
            return foundNode.value;
        }
    }

    private int getHashIndex(String key)
    {
        int hashValue = key.hashCode();
        hashValue = hashValue & 0x7FFFFFFF;
        int index = hashValue % TABLE_SIZE;
        return index;
    }

    private Node searchInChainList(String key, LinkedList<Node> chainingList)
    {
        for(Node node : chainingList)
        {
            if(node.key.equals(key))
                return node;
        }
        return null;
    }
}
