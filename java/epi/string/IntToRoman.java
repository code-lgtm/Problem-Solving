package epi.string;

import java.util.HashMap;
import java.util.Map;

//convert a int into Roman - Time O(m) space O(m) where m is the length of the roman number
public class IntToRoman {

    static  Map<Integer, String> romanMap = new HashMap() {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }

    };

    static  int[] keys = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

    public static void main(String[] args){

        System.out.println(intToRoman(2999));
        System.out.println(intToRoman(99));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(21));
        System.out.println(intToRoman(211));

   /*
   Output:

    MMCMXCIX
    XCIX
    IX
    IV
    XXI
    CCXI
    */

    }

    static String intToRoman(int num){
        StringBuilder roman = new StringBuilder();
        int key = 0;
        while (num != 0){
            while (keys[key] > num){//if a given key is more than the number, then try a smaller one
                key++;
            }

            num -= keys[key];
            roman.append(romanMap.get(keys[key]));

        }

        return roman.toString();
    }
}
