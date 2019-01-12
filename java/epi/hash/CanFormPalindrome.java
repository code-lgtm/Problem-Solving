package epi.hash;


import java.util.HashMap;
import java.util.Map;

//can a permutation of a string can be palindromic, for example edified - > deified
public class CanFormPalindrome {

    public static void main(String[] args){
        System.out.println("Is Permutation Palindromic: "+ isPalindromic("edified".toCharArray()));
        System.out.println("Is Permutation Palindromic: "+ isPalindromic("ediieg".toCharArray()));

        /*
        Output:
        Is Permutation Palindromic: true
        Is Permutation Palindromic: false
         */
    }

    static boolean isPalindromic(char[] ip){
        Map<Character, Integer> repMap = new HashMap<>();
        for(Character c: ip){
            if (repMap.containsKey(c)){
                repMap.put(c, repMap.get(c)+1);
            }else {
                repMap.put(c, 1);
            }
        }
        int niCnt = 0;//
        for (Character c: repMap.keySet()){
            if(repMap.get(c) % 2 != 0){
                niCnt++;
                if (niCnt > 1){
                    return false;
                }
            }
        }

        return true;
    }
}
