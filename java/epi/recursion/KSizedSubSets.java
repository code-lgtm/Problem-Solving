package epi.recursion;

import java.util.ArrayList;

//Given a number n, compute k size subsets
public class KSizedSubSets {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        printKSizedSubsets(5,3,1,result, new ArrayList<>());

        for (ArrayList<Integer> subSet: result){
            for (Integer i: subSet){
                System.out.print(i);
            }
            System.out.println();
        }

        /*
        Output:
        123
        124
        125
        134
        135
        145
        234
        235
        245
        345
         */
    }

    static void printKSizedSubsets(int n, int k, int cur, ArrayList<ArrayList<Integer>> result, ArrayList partial){

        if (partial.size() == k){
            result.add(new ArrayList<>(partial));
            return;
        }

        int remaining = k - partial.size();
        if (remaining < 1){
            return;
        }


        for(int i = cur; i<= n; i++){
            partial.add(i);

            printKSizedSubsets(n, k, i+1, result, partial);
            partial.remove(partial.size()-1);

        }

    }
}
