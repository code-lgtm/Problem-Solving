package epi.sorting;

//Heap sort - Time O(n log n), space O(1)
//We will use maxHeap to sort the array in increasing order, the max element will be swapped with the last index
public class HeapSort {

    public static void main(String[] args){
        int[] ary = {7,8,4,2,6,858,5,54,25};
        heapSort(ary);
        for (int i: ary){
            System.out.print(i+" ");
        }
        //Output: 2 4 5 6 7 8 25 54 858
    }

    static void heapSort(int[] ary){


        //build the max heap
        for (int i = (ary.length-1)/2 ; i>= 0; i--){
            maxHeapifyDown(ary, i, ary.length-1);
        }

        //now take the max element, swap it with the right pointer and heapify down
        int right = ary.length-1;

        //we will keep fixing the right element
        while (right>0){
            int max = ary[0];
            ary[0] = ary[right];
            ary[right] = max;

            right--;
            maxHeapifyDown(ary, 0, right);//0th index no longer has the biggest value
        }

    }

     static void maxHeapifyDown(int[] ary, int ind, int limit){
        if(ind < 0){
            return;
        }

        int leftChildInd = 2*ind+1;
        int rightChildIndex = 2*ind+2;

        int maxIndex=ind;

        if(leftChildInd <= limit && ary[leftChildInd] > ary[maxIndex]){
            maxIndex = leftChildInd;
        }

        if(rightChildIndex <= limit && ary[rightChildIndex] > ary[maxIndex]){
            maxIndex = rightChildIndex;
        }

        if(ary[maxIndex] > ary[ind]){//one of the children is larger than the current index
           //swap the elements
            int temp = ary[maxIndex];
            ary[maxIndex] = ary[ind];
            ary[ind] = temp;

            maxHeapifyDown(ary, maxIndex, limit);//there can sub tree may not be balanced, balance it
        }


    }
}
