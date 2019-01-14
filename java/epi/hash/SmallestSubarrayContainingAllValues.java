package epi.hash;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubarrayContainingAllValues {

    //Find the smallest window containing a given pattern in linear time
    //full question: https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
    public static void main(String[] args){
        char[] sentence = "A this zzzzzzzz t is a test string".toCharArray();
        char[] pattern = "tist".toCharArray();

        System.out.println(getSubArray(sentence, pattern));

        //Output: t stri

    }
    //Time complexity - O(n) - as we iterate the array twice (using left and right pointers)
    //Space complexity - O(m) - where m is the number of unique chars in the pattern
    static String getSubArray(char[] sentence, char[] patters){
        Map<Character, Integer> patCnt = new HashMap<>();
        Map<Character, Integer> matCnt = new HashMap<>();
        Map<Character, Integer> lastSeen = new HashMap<>();

        int matches = 0;
        String sub = null;
        int subLeft = 0, subRight = sentence.length;//bounds of the smallest subarray

        //populate the patCnt map
        for (int i = 0; i < patters.length; i++){
            patCnt.put(patters[i], patCnt.containsKey(patters[i])?patCnt.get(patters[i]) +1 :1);
        }

        for (int left=0, right = 0; left< sentence.length && right< sentence.length;right++){

            //See of the char matches, if yes increment it's count
            if(patCnt.containsKey(sentence[right])){
                matCnt.put(sentence[right], matCnt.containsKey(sentence[right])?matCnt.get(sentence[right])+1:1);
                matches++;
            }


            //if the char @ sentence[right] has exceeded the number of its occurences in the pattern, then increment the left pointer to one char after the last occurrence of sentence[right] like the char i of the given input
            //now, since we are sliding the window from left ->lastRight, we must ignore the matches between this window
            if(matCnt.containsKey(sentence[right])&& patCnt.containsKey(sentence[right]) //){
                    && matCnt.get(sentence[right]) > patCnt.get(sentence[right])  ){

                int lastRight = lastSeen.get(sentence[right]);

                for(int i = left; i <= lastRight; i++){
                    if(matCnt.containsKey(sentence[i]) && matCnt.get(sentence[i]) >= 1){
                        matches--;
                        matCnt.put(sentence[i], matCnt.get(sentence[i])-1);
                    }
                }

                //advance the window by moving left
                left = lastRight+1;

                //we have the right number of matches , check for the smallest possible window by advancing the left pointer, so that it doesnt contain any char from pattern
            }else if(matches == patters.length){//all the chars have matched, advance left to see of a smaller window is possible

                while (left < right){//increment left
                    if(matCnt.containsKey(sentence[left])){
                        break;
                    }else{
                        left++;
                    }
                }

                if((right - left) <= (subRight - subLeft)){//see if we have got a smaller window
                    subLeft = left;
                    subRight = right;
                    sub = new String (sentence).substring(left, right+1);
                }

                //at this point we have one char from the pattern at index left,
                // let's increase the left pointer to see if a smaller window is possible
                matCnt.put(sentence[left], matCnt.get(sentence[left])-1);
                left++;
                matches--;

            }

            //update the last seen
            lastSeen.put(sentence[right], right);

        }

        return sub;

    }

}
