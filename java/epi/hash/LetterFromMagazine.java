package epi.hash;

import java.util.HashMap;
import java.util.Map;

//is letter constructable from magazine - solve using single hashmap
public class LetterFromMagazine {

    public static void main(String[] args) {
        String letter = "hello";
        String magazine = "hello world";
        System.out.println(isLetterConstructable(letter, magazine));
        letter = "hello";
        magazine = "hell wrld";
        System.out.println(isLetterConstructable(letter, magazine));
        /*
        Output:
            true
            false
         */
    }

    //solve using single hashmap
    static boolean isLetterConstructable(String letter, String magazine){
        Map<Character, Integer> charCnt = new HashMap<>();
        for (char c: letter.toCharArray()){
            if (charCnt.containsKey(c)){
                charCnt.put(c, charCnt.get(c)+1);
            }else {
                charCnt.put(c, 1);
            }
        }

        for (char c: magazine.toCharArray()){
            if(charCnt.containsKey(c)){
                int cnt = charCnt.get(c);
                if(cnt == 1){
                    charCnt.remove(c);
                }else {
                    charCnt.put(c, cnt-1);
                }
            }
            if (charCnt.isEmpty()){
                return true;
            }
        }

        return false;

    }

}
