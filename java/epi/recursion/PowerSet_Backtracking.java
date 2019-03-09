package epi.recursion;

//Compute powerset using backtracking - Time complexity: O(n*2^n) [2^n powersets costing n for every deepcopy.
//Space complexity: O(n*2^n) as there are 2^n subsets with n/2 as average size. We can reduce the space complexity to O(n) by simply printing it
import java.util.ArrayList;

public class PowerSet_Backtracking {

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        int[] set = {1,2,3};

        computePowerSet(set, 0, powerSet, new ArrayList<Integer>());

        for (ArrayList<Integer> subSet: powerSet){
            for (Integer i: subSet){
                System.out.print(i);
            }
            System.out.println();
        }

        /*
        Output:
           123
            12
            13
            1
            23
            2
            3

         */
    }

    static void computePowerSet(int[] set, int cur, ArrayList<ArrayList<Integer>> powerSet, ArrayList<Integer> currentSelection){

        if(cur == set.length){
            powerSet.add(new ArrayList<>(currentSelection));//deep copy
            return;
        }

        currentSelection.add(set[cur]);//select the current item
        computePowerSet(set, cur+1, powerSet, currentSelection);
        currentSelection.remove(currentSelection.size()-1);//unselect the last item
        computePowerSet(set, cur+1, powerSet, currentSelection); // compute the powerset after unselection of last item

    }

}
