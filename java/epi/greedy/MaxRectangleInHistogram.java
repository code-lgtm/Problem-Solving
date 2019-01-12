package epi.greedy;

import java.util.Stack;

public class MaxRectangleInHistogram {
    //Find the largest area of a rectangle in a histogram in O(n) time and space
    //https://www.geeksforgeeks.org/largest-rectangle-under-histogram/

    public static void main(String[] args){
        int[] heights = {2,1,2,3,1};
        System.out.println(getMaxArea(heights));
    }

    static int getMaxArea(int[] heights){
        int max = -1;
        Stack<Integer> stk = new Stack<Integer>();

        int i;
        for(i=0; i< heights.length;){
            if(stk.isEmpty() || heights[i] > heights[stk.peek()]){//simply add the index in the stack if stk is empty or the current height is more that the top of the stack
                stk.push(i);
                i++;
            }else{//keep poping until the stk is empty or we get an element smaller than ith element
                int curTop = stk.pop();
                int tempArea;
                if (stk.isEmpty()){//this is last element, area is simply it's height * length of the array
                    tempArea = heights[curTop]*i;
                }else{///this is the min element from i to curTop, that is the rectangle from curTop to i will have atleast curTop height, width will be i - curtop - 1
                    tempArea = heights[curTop] *(i - curTop -1);
                }
                if(tempArea > max){
                    max = tempArea;
                }
            }
        }

        //if the stack isn't yet empty

        while (! stk.isEmpty()){ //apply the same logic as above
            int curTop = stk.pop();
            int tempArea;
            if (stk.isEmpty()){
                tempArea = heights[curTop]*i;
            }else{
                tempArea = heights[curTop] *(i - curTop -1);
            }
            if(tempArea > max){
                max = tempArea;
            }
        }




        return max;
    }

}
