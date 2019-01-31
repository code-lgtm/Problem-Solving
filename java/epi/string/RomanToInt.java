package epi.string;

import java.util.HashMap;
import java.util.Map;

//convert a roman number to decimal - time O(n) space O(1)
public class RomanToInt {
    static final Map<Character, Integer> romanMap = new HashMap() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }

    };

    public static void main(String[] args){

        char[] roman1 = "MCMIV".toCharArray(), roman2= "IX".toCharArray(), roman3= "M".toCharArray();

        System.out.println(romanToInt(roman1));
        System.out.println(romanToInt(roman2));
        System.out.println(romanToInt(roman3));

        /*
        Output:

        1904
        9
        1000

         */

    }

    static int romanToInt(char[] roman){
        int decimal = romanMap.get(roman[roman.length-1]);//last char's value

        //we have atleast two char roman
        //start from right, if left char if < right char then subatract it, else add it
        for(int i = roman.length-2; i >=0; i--){
            if(roman[i] < roman[i+1]){//substract
                decimal -= romanMap.get(roman[i]);
            }else{
                decimal += romanMap.get(roman[i]);
            }
        }

            return decimal;
    }


}
