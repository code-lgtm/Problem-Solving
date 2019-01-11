package com.test;

import java.util.*;

public class LRU_Cache {
    // Inserting, Removing and updating least recently used items in  O(1)
    static final int CAPACITY = 5;//queue has a capacity of 5
    static int elementCnt = 0;
    static Deque<KeyVal> dq = new LinkedList<KeyVal>();
    static Map<Integer, KeyVal> keyValMap = new HashMap<Integer, KeyVal>();

    static class KeyVal{
        int key, val;
        KeyVal(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args){

        for(int i = 1; i <= 10; i++){
            add(i, i*100);
        }

        System.out.println(get(9).val);// 9 will come to the top of the queue

        for(int i = 11; i <= 12; i++){
            add(i, i*100);
        }

        remove(11);

        Iterator<KeyVal> itr = dq.iterator();
        while(itr.hasNext())
        {
            System.out.print(itr.next().val+" ");
        }


        /*
        Output:
        900
        1200 1000 900 800
         */
    }


    static void add(int key, int data){
        if(keyValMap.containsKey(key)){//already cached, simply move it on the top
            KeyVal cur = keyValMap.get(key);
            dq.remove(cur);
            dq.addFirst(cur);
        }else if(dq.size() < CAPACITY){//data is not cached and we have capacity, simply add it
            addNew(key, data);
        }else {//data is not cached and we at capacity, delete the last and add new
            KeyVal del =  dq.removeLast();
            keyValMap.remove(del);
            addNew(key, data);
        }
    }

    static void addNew(int key, int data){
        KeyVal cur = new KeyVal(key, data);
        dq.addFirst(cur);
        keyValMap.put(key, cur);
    }
    static KeyVal get(int key){//get
        if(keyValMap.containsKey(key)){
            return keyValMap.get(key);
        }else{
            return null;
        }
    }

    static void remove(int key){//get
        if(keyValMap.containsKey(key)){
            KeyVal cur = keyValMap.get(key);
            keyValMap.remove(cur);
            dq.remove(cur);
        }
    }

}
