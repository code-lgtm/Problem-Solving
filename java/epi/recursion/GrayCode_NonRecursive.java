package epi.recursion;

import java.util.ArrayList;

//Generate Gray code - non recursivce method
public class GrayCode_NonRecursive {

    public static void main(String[] args){
      ArrayList<String> grayCode =  getNBitGrayCode(4);
        for (String s: grayCode){
           System.out.println(s);
        }

        /*
        Output:
        0000
        0001
        0011
        0010
        0110
        0111
        0101
        0100
        1100
        1101
        1111
        1110
        1010
        1011
        1001
        1000
         */
    }

   static ArrayList<String> getNBitGrayCode(int n){

        ArrayList<String> grayCode = new ArrayList<>();

       if(n <= 0){
           return grayCode;
       }

       //seed data for 1 bit gray code
       grayCode.add("0");
       grayCode.add("1");

       for (int k = 1; k < n; k++) {
           ArrayList<String> tempGrayCode = new ArrayList<>();

           for (String s: grayCode){
               tempGrayCode.add("0"+s);
           }

           for (int i = grayCode.size() - 1; i >= 0; i--) {
               tempGrayCode.add("1"+grayCode.get(i));
           }

           grayCode = tempGrayCode;

       }


        return grayCode;
    }

}
