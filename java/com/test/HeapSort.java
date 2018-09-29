package com.test;

public class HeapSort {
    private static  int[] ip = {4,3,1,55,3,6,8,2,9,11,44,3,6,22,35};
    private static int elementCount = ip.length;

    public static void main(String[] args){

        heapSort();

        System.out.println("Sorted");
        while(elementCount > 0) {
            System.out.print(poll()+" ");
        }
    }

    private static void heapSort(){

        for(int i = (elementCount/2)-1 ; i > 0; i--){//starting with the first level of parents
            heapifyUp(i);
        }


    }

    private static void heapifyUp(int i){

        int ind = i;

        while(hasParent(ind)){

            int maxIndex = getLeftChildIndex(ind);
            if(hasRightChild(ind)){
                int right = getRightChildIndex(ind);
                if(ip[maxIndex] < ip[right]){
                    maxIndex = right;
                }
            }

            if(ip[maxIndex] > ip[ind]){//swap
                int temp = ip[maxIndex];
                ip[maxIndex] = ip[ind];
                ip[ind] = temp;
            }else{
                break;
            }

            ind = getParentIndex(ind);

        }

    }

    private static int poll(){//return the max element, which is at index 0
        int element = -1;
        if (elementCount > 0){
            element = ip[0];
            ip[0] = ip[elementCount -1];
            ip[elementCount -1] = -1;
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

                if(ip[ind] >= ip[biggerChildIndex]){
                    break;// we are good, break the loop
                }else{//swap, we are still out of order
                    int temp = ip[ind];
                    ip[ind] = ip[biggerChildIndex];
                    ip[biggerChildIndex] = temp;
                    ind = biggerChildIndex;
                }

            }

        }

        return element;
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

    private static boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < elementCount;
    }

    private static boolean hasRightChild(int index){
        return getRightChildIndex(index) < elementCount;
    }

    private static boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }
    private static int getRightChild(int index){
        return ip[getRightChildIndex(index)];
    }
    private static int getLeftChild(int index){
        return ip[getLeftChildIndex(index)];
    }
}
