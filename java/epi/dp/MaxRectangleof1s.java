package epi.dp;

import java.util.Stack;

//find the max area of 1s in a matrix - Time O(row * col) , space O(col)
public class MaxRectangleof1s {

    public static void main(String[] args){
        int[][] mat = {
                {1,0,0,1},
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}
        };

        int maxArea = getMaxArea(mat);
        System.out.println("max area: "+maxArea);

        //max area: 8
    }

    static int getMaxArea(int[][] mat){
        int maxRectArea = -1;

        //visualize each row as a upside down histogram. The height of the histogram resets as soon as we find a 0

        int[] histogram = new int[mat[0].length];

        for (int row = 0 ; row < mat.length; row++){
            for (int col = 0; col < mat[0].length; col++){
                if (mat[row][col] == 1){//we can add it to the current height of the histogram
                    histogram[col]++;
                }else {//set the current height of histogram as 0
                    histogram[col] = 0;
                }
            }

            //compute the max area in the histogram after every row and check if we have a new maxArea
            maxRectArea = Integer.max(maxRectArea, getMaxAreaInHistogram(histogram));
        }
        return maxRectArea;
    }

    static int getMaxAreaInHistogram(int[] heights){
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
                if (stk.isEmpty()){//this is last element, area is simply it's height * the current value of i
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
