package com.test;

public class MaxHeapOperations {
    private static int[] maxHeap = {16,14,10,8,7,9,3,2,4,1, -1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    private static int elementCount = 10;
    private static int capacity = 20;


    public static void main(String[] arg){


        addElement(15);
        addElement(100);
        //Heap sort O(n log n)
        while(elementCount > 0) {
            System.out.print(poll()+" ");
        }
        //outputs 100 16 15 14 10 9 8 7 4 3 2 1
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

    private static int poll(){//return the max element, which is at index 0
    int element = -1;
    if (elementCount > 0){
        element = maxHeap[0];
        maxHeap[0] = maxHeap[elementCount -1];
        maxHeap[elementCount -1] = -1;
        elementCount--;

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

    }

    return element;
    }

    private static void addElement(int element){

        //add the element to the last and then heapify up
            if (elementCount > capacity){//edge case
                return;
            }

        maxHeap[elementCount] = element;
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

    }
}
