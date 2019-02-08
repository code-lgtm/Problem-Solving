package epi.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//Merge K sorted files with different lengths in O(n log K) time : n = total number of elements in the files & O(K) space
public class MergeSortedFiles {

    public static void main(String[] args){
        int[][] files = {
                {3,5,7},
                {0,6},
                {1,2,3,4,5,6,7,8},
                {10,20,30}
        };

        int[][] files2 = {
                {3,5,7},
                {0,6},
                {0,6,28}
        };

        int[][] files3 = { {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}};
        printMerged(files);//practically it would write the merged output to disk, to minimize the space complexity
        printMerged(files2);//practically it would write the merged output to disk, to minimize the space complexity
        printMerged(files3);//practically it would write the merged output to disk, to minimize the space complexity

        /*
        Output:
        0 1 2 3 3 4 5 5 6 6 7 7 8 10 20 30
        0 0 3 5 6 6 7 28
        0 1 2 3 4 5 6 7 8 9 10 11
         */
    }

    static class Element{
        int value;
        int index;
        int fileIndex;

        Element(int value, int index, int fileIndex){
            this.value = value;
            this.index = index;
            this.fileIndex = fileIndex;
        }
    }

    static void printMerged(int[][] files){
        int k = files.length;//number of files to be merged
        PriorityQueue<Element> minHeap = new PriorityQueue(k, new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2){
                return e1.value-e2.value;
            }
        });

        //Add the first elements of each file in the queue
        for(int i = 0; i < k; i++){
            minHeap.add(new Element(files[i][0], 0, i));
        }

        //Extract the min value and everytime ADD THE NEXT VALUE OF THE ARRAY FROM WHERE THE MIN VALUE WAS EXTERACTED FROM
        while (!minHeap.isEmpty()){
            Element min = minHeap.poll();
            System.out.print(min.value+" ");
           if(min.index+1 < files[min.fileIndex].length){//we can pick the next entry from this array
               int newIndex = min.index+1;
               int val =files[min.fileIndex][newIndex];
               minHeap.add(new Element(val, newIndex, min.fileIndex));
           }
        }
        System.out.println();
    }
}
