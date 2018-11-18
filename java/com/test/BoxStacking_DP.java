package com.test;

import java.util.Arrays;

public class BoxStacking_DP {
/*
Question: https://www.geeksforgeeks.org/box-stacking-problem-dp-22/
Output:
Box: Length: 1, Width: 2, Height: 3
Box: Length: 2, Width: 3, Height: 1
Box: Length: 4, Width: 5, Height: 6
Box: Length: 5, Width: 6, Height: 4
Box: Length: 6, Width: 7, Height: 4
Box: Length: 10, Width: 12, Height: 32
Box: Length: 12, Width: 32, Height: 10
Max height: 60

Time complexity O(numberOFBoxes^2)
Space O(numberOFBoxes)
 */
    static class Box implements Comparable<Box>{
        int length, width, height;
        Box(int length, int width,int height){
            this.length = length;
            this.width = width;
            this.height = height;
        }

        public int compareTo(Box b){
            return (b.length*b.width) - (this.length*this.width) ;
        }
    }


    public static void main(String[] args) {
        int[][] boxDimentions = { {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32} };
        int maxHeight = getMaxHeight(boxDimentions);
        System.out.println("Max height: "+maxHeight);

    }

    static int getMaxHeight(int[][] boxDimentions){
        int totalBoxes = boxDimentions.length * 3;
        Box[] boxes = new Box[totalBoxes];
        int boxCnt = 0;

        //create different boxes by rotating them
        for(int[] dim: boxDimentions){
            for(int i = 0; i < 3 ; i++){
                int lInd = 0 + i;
                int wInd = (1 + i) > 2 ?0: (1 + i);
                int hInd = (2 + i) > 2 ? (2+i)-3:(2+i);
                boxes[boxCnt++] = new Box(dim[lInd], dim[wInd], dim[hInd]);
                //   System.out.println(l +" "+w+" "+" "+h);
            }
        }

        // sorted by decreasing base area
        Arrays.sort(boxes);

      /*  for(Box b: boxes){
            System.out.println(b.length*b.width);
        }*/



        return getMaxHeight(boxes);
    }

    static int getMaxHeight(Box[] boxes){
        //Use DP to find the order of boxes yielding in max height - Similar to longest increasing subsequence
        int maxHeight = 0, topBoxIndex = -1;
        int[] boxOrder = new int[boxes.length];

        int[] boxHeight = new int[boxes.length];
        for(int i = 0; i < boxes.length; i++){
            boxHeight[i] = boxes[i].height;// atleast the height at any place is the height of the box itself
            boxOrder[i] = -1;//nothing is placed on top of the given index
        }

        for(int i = 0; i < boxes.length; i++){
            for(int j = 0; j<i; j++){
                if(canPlace(boxes[j], boxes[i]) && //can place jth box over ith box
                        ((boxHeight[j] + boxes[i].height) > boxHeight[i])){  // And picking jth box results in better height
                    boxHeight[i] = boxHeight[j] + boxes[i].height;
                    boxOrder[i] = j;// i is on top of j

                    if(boxHeight[i] > maxHeight){
                        maxHeight = boxHeight[i];
                        topBoxIndex = i;
                    }
                }
            }
        }


        //printing box order
        for(int top = topBoxIndex; top >= 0;){
            System.out.println("Box: Length: "+boxes[top].length+", Width: "+boxes[top].width+", Height: "+boxes[top].height);
            top = boxOrder[top];
        }

        return maxHeight;

    }

    static boolean canPlace(Box jBox, Box iBox){// can place jth box over ith box
        return jBox.length > iBox.length && jBox.width > iBox.width;
    }

}
