package epi.heap;

import java.util.*;

//Sort k increasing decreasing sequences in an array in O(n log K) time and O(n) space
public class MergeKIncreasingDecreasingArrays {

    public static void main(String[] args){
        int[] ary = {57,131,493,294,221,339,418,452,442,190};
        List<Integer> aryList = new ArrayList<>();
        for (int i: ary){
            aryList.add(i);
        }
        List<Integer> sortedAry = sortAry(aryList);

        for (Integer i: sortedAry){
            System.out.print(i+" ");
        }

        /*
        Output:
        57 131 221 294 339 418 442 190 452 493
         */
    }

    static List<Integer> sortAry(List<Integer> ary){

        //form the k sub arrays first
        List<List<Integer>> kSubArys = new ArrayList<>();
        int start = 0;

        boolean isIncreasing = true;
        if(ary.get(0) > ary.get(1)){//initial sequence is decreasing
            isIncreasing = false;
        }

        for (int i = 1; i < ary.size(); i++){

            if(isIncreasing && ary.get(i-1) > ary.get(i)){// was increasing but now its decreasing
                List<Integer> subList = ary.subList(start,i);
                kSubArys.add(subList);
                start = i;
                isIncreasing = !isIncreasing;
            }else if(!isIncreasing && ary.get(i-1) < ary.get(i)){//was decreasing, now started increasing
                List<Integer> subList = ary.subList(start,i);
                Collections.reverse(subList);//it was a decreasing sequence , sort it in increasing order
                kSubArys.add(subList);
                start = i;
                isIncreasing = !isIncreasing;
            }
        }

        List<Integer> subList = ary.subList(start,ary.size());
        kSubArys.add(subList);

// at this point we have k sorted sequences in increasing order, we need to merge these using heap


        return mergeKSortedLists(kSubArys);
    }

    static class Element{
        int val,index, subAryIndex;
        Element(int val, int index, int subAryIndex){
            this.val = val;
            this.index = index;
            this.subAryIndex = subAryIndex;
        }
    }

    static List<Integer> mergeKSortedLists(List<List<Integer>> kSubArys){
        List<Integer> sortedList = new ArrayList<>();
        int k = kSubArys.size();
        PriorityQueue<Element> minHeap = new PriorityQueue<>(k, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.val - o2.val;
            }
        });

        //insert the first element from all the lists in the heap
        for(int i = 0; i< kSubArys.size(); i++){
            minHeap.add(new Element(kSubArys.get(i).get(0), 0, i));
        }

        while (!minHeap.isEmpty()){
            Element cur = minHeap.poll();
            sortedList.add(cur.val);
            int subAryIndex = cur.subAryIndex;
            int ind = cur.index;
            if(kSubArys.get(subAryIndex).size() > ind+1){//there is a next element in the array which can inserted in the minHeap
                int nextVal = kSubArys.get(subAryIndex).get(ind+1);
                minHeap.add(new Element(nextVal, ind+1, subAryIndex));
            }
        }


        return sortedList;
    }
}
