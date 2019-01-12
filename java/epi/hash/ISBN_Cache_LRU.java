package epi.hash;

import java.util.*;

// LRU cache to maintain ISBN:Book Price in cache - O(1) time complexity for all operations
public class ISBN_Cache_LRU {
    // Inserting, Removing and updating least recently used items in  O(1)
    static final int CAPACITY = 5;//queue has a capacity of 5
    static Deque<KeyVal> dq = new LinkedList<KeyVal>();
    static Map<String, KeyVal> keyValMap = new HashMap<String, KeyVal>();

    static class KeyVal{//ISBN: Price mapping
        String isbn;
        int price;
        KeyVal(String isbn, int price){
            this.isbn = isbn;
            this.price = price;
        }
    }

    public static void main(String[] args){

        for(int i = 10; i <= 20; i++){
            add("ISBNXXXXXXX"+i, i*100);
        }

        System.out.println("Price of ISBNXXXXXXX17: "+get("ISBNXXXXXXX17").price);
        for(int i = 21; i <= 22; i++){
            add("ISBNXXXXXXX"+i, i*100);
        }
        remove("ISBNXXXXXXX21");

        System.out.println("Iterating through cache");
        Iterator<KeyVal> itr = dq.iterator();
        while(itr.hasNext())
        {
            KeyVal next = itr.next();
            if(next!=null)
                System.out.println(next.isbn+" "+next.price);
        }


        /*
        Output:
                Price of ISBNXXXXXXX17: 1700
                Iterating through cache
                ISBNXXXXXXX22 2200
                ISBNXXXXXXX20 2000
                ISBNXXXXXXX19 1900
                ISBNXXXXXXX18 1800
         */
    }


    static void add(String isbn, int price){
        if(keyValMap.containsKey(isbn)){//already cached, simply move it on the top
            KeyVal cur = keyValMap.get(isbn);
            dq.remove(cur);
            dq.addFirst(cur);
        }else if(dq.size() < CAPACITY){//data is not cached and we have capacity, simply add it
            addNew(isbn, price);
        }else {//data is not cached and we at capacity, delete the last and add new
            KeyVal del =  dq.removeLast();
            keyValMap.remove(del);
            addNew(isbn, price);
        }
    }

    static void addNew(String isbn, int price){
        KeyVal cur = new KeyVal(isbn, price);
        dq.addFirst(cur);
        keyValMap.put(isbn, cur);
    }
    static KeyVal get(String key){//get
        if(keyValMap.containsKey(key)){
            return keyValMap.get(key);
        }else{
            return null;
        }
    }

    static void remove(String key){//get
        if(keyValMap.containsKey(key)){
            KeyVal cur = keyValMap.get(key);
            keyValMap.remove(cur);
            dq.remove(cur);
        }
    }
}
