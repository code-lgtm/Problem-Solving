package com.test;

public class KthSmallestNumber {

    //find the kth smallest number in a stream of numbers https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
    static int k = 5;
    static int[] input = {8,1,5,6,2,88,4,65,4, 7 , 9 , 7 , 55 , 7};
    static  int[] maxHeap = new int[k];
    static int elementCount = 0;

    public static void main(String[] args){

//n log n for the stream of n numbers
        for(int i: input){//input stream
            System.out.println(k+"th smallest: "+getKthSmallest(i));
        }

        /*
        Output:
5th smallest: -1
5th smallest: -1
5th smallest: -1
5th smallest: -1
5th smallest: -1
5th smallest: 8
5th smallest: 6
5th smallest: 6
5th smallest: 5
5th smallest: 5
5th smallest: 5
5th smallest: 5
5th smallest: 5
5th smallest: 5
         */
    }


    private static int getKthSmallest(int i){

        if(elementCount < k){//keep on populating heap
            maxHeap[elementCount] = i;
            elementCount++;

            //MAX HEAPIFY UP

            int ind = elementCount -1;

            while(hasParent(ind)){
                int parentIndex = getParentIndex(ind);
                if(maxHeap[parentIndex] >= maxHeap[ind]){
                    break;
                }else{//swap
                    int temp = maxHeap[parentIndex];
                    maxHeap[parentIndex] = maxHeap[ind];
                    maxHeap[ind] = temp;
                    ind = parentIndex;
                }

            }

            return  -1;//haven't processed k elements yet
        }else{//we have k elements , if the i is less than peek, then replace i with peek and heapify down
            int peek = maxHeap[0];
            if(i < peek){
                maxHeap[0] = i;


                //max heapify down

                int ind = 0;
                while (hasLeftChild(ind)){
                    //get left and righ children and swap with the max
                    int biggerChildIndex = getLeftChildIndex(ind);
                    if(hasRightChild(ind) && getRightChild(ind) > getLeftChild(ind)){//if exists a bigger right child, then biggerChildIndex is the right child's index
                        biggerChildIndex = getRightChildIndex(ind);
                    }

                    //check if ind is bigger than value at biggerChildIndex, if not then swap

                    if(maxHeap[ind] >= maxHeap[biggerChildIndex]){
                        break;// we are good, break the loop
                    }else{//swap, we are still out of order
                        int temp = maxHeap[ind];
                        maxHeap[ind] = maxHeap[biggerChildIndex];
                        maxHeap[biggerChildIndex] = temp;
                        ind = biggerChildIndex;
                    }

                }

                peek = maxHeap[0];
            }

            return peek;

        }

    }


    /*
IMPLEMENTING HOUSE KEEPING METHODS
*/

    private static int getLeftChildIndex(int index){
        return 2*index + 1;
    }

    private static int getRightChildIndex(int index){
        return 2*index + 2;
    }

    private static int getParentIndex(int childIndex){
        return (childIndex-1) / 2;
    }

    private static int getLeftChild(int index){
        return maxHeap[getLeftChildIndex(index)];
    }

    private static int getRightChild(int index){
        return maxHeap[getRightChildIndex(index)];
    }

    private static int getParent(int index){
        return maxHeap[getParentIndex(index)];
    }

    private static boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < elementCount;
    }

    private static boolean hasRightChild(int index){
        return getRightChildIndex(index) < elementCount;
    }

    private static boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }
}
