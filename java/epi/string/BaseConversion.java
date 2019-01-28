package epi.string;

import java.util.ArrayList;
import java.util.List;

//Convert a string representing a number in base b1 into a string in base b2
public class BaseConversion {
    public static void main(String[] args){

        System.out.println(convertBase("10AB", 16, 7));
        System.out.println(convertBase("1001", 10, 15));

        /*Output:
        15304
        46B
         */

    }

    static String convertBase(String numB1, int b1, int b2){

        /*
        10AB base 16 to decimal is: 4267

        B 	11 X 16^0 = 	11
        A 	10 X 16^1 = 	160
        0 	0 X 16^2 =   	0
        1 	1 X 16^3 =  	4096
                    Total:  4267
         */

        int decNum = 0;
        int baseMul = 1;
//convert numB1 base b1 to base 10
        for (int i = numB1.length()-1; i>= 0; i--){

            int d = 0;
            char c = numB1.charAt(i);
            if(c >= '0' && c <= '9'){
                d = (int) (c - '0');
            }else if(c >= 'A' && c <= 'F') {
                d = (int) (c - 'A' + 10);
            }

            decNum += (d * baseMul);
            baseMul *= b1;

        }

        //  System.out.println(decNum);

        //now convert decNum base 10 to base b2

        List<Character> numB2Rev = new ArrayList<>();
        while (decNum > 0){

            int rem = decNum % b2;
            decNum /= b2;

            if (rem >= 0 && rem <= 9) {
                numB2Rev.add((char) (rem + '0'));
            }
            else {
                numB2Rev.add((char) (rem - 10 + 'A'));
            }

        }

        String numB2 = "";
        //reverse numB2Rev

        for (int i = numB2Rev.size()-1; i >=0 ; i--){

            numB2 += numB2Rev.get(i);
        }

        return numB2;
    }
}
