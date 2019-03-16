package epi.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Compute gray code using backtracking - Time & space : O(2^n)
//This approach is much better than the brute force solution which will take O(2^(n*2^n)) time
public class GrayCode {
    public static void main(String[] args){
        int numBits = 4;
        Set<Integer> history = new HashSet<>();
        List<Integer> codes = new ArrayList<>();
        codes.add(0);//seed data
        history.add(0);
        computeGrayCode(numBits, history, codes);

        for (int n: codes){
            System.out.println(n+" "+intToBinRepresentation(n, numBits));
        }

        /*
        Output:
        0 0000
        1 0001
        3 0011
        2 0010
        6 0110
        7 0111
        5 0101
        4 0100
        12 1100
        13 1101
        15 1111
        14 1110
        10 1010
        11 1011
        9 1001
        8 1000
         */

    }

    static boolean computeGrayCode(int n, Set<Integer> history, List<Integer> codes){
        if (codes.size() == 1 << n){//1<<n == 2^n
            return true;
        }

        for (int i = 0; i < n; i++){

            Integer last = codes.get(codes.size()-1);
            int candidate = last ^ 1 <<i; //flip a bit

            if(!history.contains(candidate)){//this can potentially lead to a solution

                history.add(candidate);
                codes.add(candidate);

                if (computeGrayCode(n, history, codes)){// see if we can solve the code sequence with the current candidate
                    return true;
                }

                //sequence cant be solved with the candidate, remove it
                history.remove(candidate);
                codes.remove(codes.size()-1);
            }

        }


        return false;
    }

    static String intToBinRepresentation(int num, int numBits){
        String bin = "";
        for (int i= 0 ; i < numBits; i++){//check if the ith bit is set
            if((num &(1 << i)) == 0){//ith bit isn't set
                bin = "0"+bin;
            }else {
                bin = "1"+bin;
            }
        }
        return bin;
    }


}
