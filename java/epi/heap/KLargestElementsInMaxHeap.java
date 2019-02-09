package epi.heap;

import java.util.*;

//Return k largest elements in a heap having b elements without modifying it, in O(k log k time) and O(k) aux space
public class KLargestElementsInMaxHeap {
    private static int[] maxHeap = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    private static int elementCount = 0;
    private static int capacity = 20;


    public static void main(String[] args){
        int[] elements = {5,7,1,2,6,87,96,5,9,54,6,21,58};
        for (int element: elements){
            addElement(element);
        }

        List<Integer> maxHeapList = new ArrayList<>();

        for (int i  = 0; i < elementCount; i++){
            maxHeapList.add(maxHeap[i]);
        }


        List<Integer> kLargest = getKLargestElements(maxHeapList, 5);

        for (Integer i: kLargest){
            System.out.print(i+" ");
        }

        //Output: 96 87 58 54 21
    }

    static class Element{
        int val;
        int index;
        Element(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    //We will use a max heap here to get the max elements - this is a bit of an anti pattern where we use a min heap for k max values in a stream and vice versa. The reason
    // is because we are always picking the max child from the input max heap, so it's about finding max of the max
    static List<Integer> getKLargestElements(List<Integer> maxHeap, int k){
        List<Integer> kLargest = new ArrayList<>();

        PriorityQueue<Element> mHeap = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o2.val-o1.val;
            }
        });

        mHeap.add(new Element(maxHeap.get(0), 0));

        while (kLargest.size() < k && !mHeap.isEmpty()){
            Element cur = mHeap.poll();

            kLargest.add(cur.val);//add the max element

            int leftChildIndex = 2*cur.index +1;
            int rightChildIndex = 2*cur.index +2;

            // the next max will be one of the eight children of the current max due to heap property, so add both children in mHeap
            if(leftChildIndex<maxHeap.size()){
                mHeap.add(new Element(maxHeap.get(leftChildIndex), leftChildIndex));
            }

            if(rightChildIndex < maxHeap.size()){
                mHeap.add(new Element(maxHeap.get(rightChildIndex), rightChildIndex));
            }

        }


        return kLargest;
    }

////////////////////////////////////////// MAX HEAP IMPLEMENTATION BELOW//////////////////////////////////////////////////////////////////////////////

    /*
IMPLEMENTING HOUSE KEEPING METHODS
*/

    private static int getParentIndex(int childIndex){
        return (childIndex-1) / 2;
    }
    private static boolean hasParent(int index){
        return getParentIndex(index) >= 0;
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
