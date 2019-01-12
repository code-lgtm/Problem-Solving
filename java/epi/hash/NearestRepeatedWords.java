package epi.hash;

import java.util.HashMap;
import java.util.Map;

//get the distance between the closest two repeating words -Time complexity O(n) n = length of ip, and space complexity O(m) where m = length of unique words
public class NearestRepeatedWords {
    public static void main(String[] args){
        String[] sentence = {"All", "work", "and", "no" , "play", "makes", "for", "no", "work", "and", "no", "play"};
        System.out.println(getNearestRepeated(sentence));

        //Output: 3
    }

    static int getNearestRepeated(String[] sentence){
        int minRepeated = Integer.MAX_VALUE;
        Map<String , Integer> lastSeen = new HashMap<>();
        for(int i = 0; i <sentence.length; i++){
         if(lastSeen.containsKey(sentence[i])){
             int last = lastSeen.get(sentence[i]);
             minRepeated = (i-last) < minRepeated? (i-last): minRepeated;
         }
         lastSeen.put(sentence[i], i);//update the last seen
        }
        return minRepeated;
    }
}
