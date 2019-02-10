package epi.sorting;

import java.util.ArrayList;
import java.util.List;

//Given to sorted arrays , merge them in O(m+n) time and O(1) space. Assume there is sufficient space at the end of the first array.
public class MergeSortedArrays {

    public static void main(String[] args){
        int[] a1 = {5,13,17,-1,-1,-1,-1,-1,-1};//-1 represents empty spaces at the right
        int[] a2 = {1,2,3,5,11,19};

        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        int l1Size = 0;
        for (int i:a1){
            if(i!= -1){
                l1Size++;
            }
            l1.add(i);
        }
        for (int i:a2){
            l2.add(i);
        }

        List<Integer> merged = mergeSortedArys(l1Size,l1, l2);
        for(int i: merged){
            System.out.print(i+" ");
        }

    }

    //l1Size is the size of l1Ary without empty spaces
    static List<Integer> mergeSortedArys(int l1Size, List<Integer> l1, List<Integer> l2){

        int tailIndx = l1Size + l2.size() -1;
        int l1Cur = l1Size-1;
        int l2Cur = l2.size() -1;

        while (tailIndx >=0){//any one array has values

            if(l1Cur < 0 || l2Cur < 0){//one of the cursors is at 0, keep copying the other array to the right
                if(l1Cur < 0){//l2 has values
                    l1.set(tailIndx, l2.get(l2Cur));
                    l2Cur--;
                    tailIndx--;
                }else{
                    l1.set(tailIndx, l1.get(l1Cur));
                    l1Cur--;
                    tailIndx--;
                }

            }else {//none of the cursors are at zero, keep writing the bigger value on the right
                if(l1.get(l1Cur) > l2.get(l2Cur)){
                    l1.set(tailIndx, l1.get(l1Cur));
                    tailIndx--;
                    l1Cur--;
                }else{
                    l1.set(tailIndx, l2.get(l2Cur));
                    tailIndx--;
                    l2Cur--;
                }
            }
        }

        return l1;
    }
}
