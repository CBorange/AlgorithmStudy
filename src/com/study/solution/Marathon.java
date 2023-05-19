package com.study.solution;

import com.study.collection.MyHashTable;

import java.util.*;

public class Marathon {

    public class MarathonTable {
        private final int TABLE_SIZE;

        public ArrayList<Node> bucket;

        public MarathonTable(int capacity)
        {
            TABLE_SIZE = capacity;
            bucket = new ArrayList<Node>(capacity);
            bucket.ensureCapacity(capacity);
        }

        public class Node{
            public String key;
            public int count;

            public Node(String key)
            {
                this.key = key;
                count = 1;
            }
        }

        public void put(String key)
        {
            int index = getHashIndex(key);
            try
            {
                Node foundNode = bucket.get(index);
            }catch (IndexOutOfBoundsException e)
            {
                bucket.add(index, new Node(key));
            }
        }

        public void delete(String key)
        {
            int index = getHashIndex(key);
            Node foundNode = bucket.get(index);
            foundNode.count--;
            if(foundNode.count == 0)
                bucket.remove(index);
        }

        public String getResult()
        {
            Node first = bucket.stream().findFirst().get();
            return first.key;
        }

        private int getHashIndex(String key)
        {
            int hashValue = key.hashCode();
            hashValue = hashValue & 0x7FFFFFFF;
            int index = hashValue % TABLE_SIZE;
            return index;
        }
    }

    public class MarathonNode
    {
        public MarathonNode(int cnt)
        {
            count = cnt;
        }
        public int count;
    }

    public String solution(String[] participant, String[] completion) {
        HashMap<String, MarathonNode> map = new HashMap<String, MarathonNode>();
        for(String tryMan : participant) {
            if(map.containsKey(tryMan)) {
                MarathonNode node = map.get(tryMan);
                node.count++;
            } else{
                map.put(tryMan, new MarathonNode(1));
            }
        }
        for (String completeMan : completion){
            if(map.containsKey(completeMan))
            {
                MarathonNode node = map.get(completeMan);
                node.count--;
                if(node.count == 0)
                    map.remove(completeMan);
            }
        }
        String answer = map.keySet().stream().findFirst().get();
        return answer;
    }
}
