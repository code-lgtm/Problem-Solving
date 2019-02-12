package epi.sorting;

import java.util.Arrays;

//Check if players of two teams can be arranged such that we can take a team pic without hiding the back row - Time O(n log n) space O(1)
public class TeamPhoto {
    public static void main(String[] args){
        int[] frontRowHeight = {2,2,1,5,4,3};
        int[] backRowheight = {3,3,2,4,6,5};

        System.out.print(isPicPossible(backRowheight,frontRowHeight));

        //Output: true
    }

    static boolean isPicPossible(int[] backRowHeight, int[] frontRowHeight){

        Arrays.sort(backRowHeight);
        Arrays.sort(frontRowHeight);

        //start from the last index and see of the tallest player at the back row is taller than the tallest player of the front row, and so on

        for(int i = frontRowHeight.length-1; i>=0 ; i--){
            if(! (backRowHeight[i] > frontRowHeight[i])){
                return false;
            }
        }

        return true;
    }

}
