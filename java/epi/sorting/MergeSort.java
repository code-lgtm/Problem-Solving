package epi.sorting;

//Vanilla merge sort implementation. Time: O(n log n) space(O(n))
public class MergeSort {

    public static void main(String[] args){
        int[] ary = {5,1,6,7,3,8,7,20,40,30,15};

        mergeSort(ary, 0, ary.length-1);
        for (int i: ary){
            System.out.print(i+" ");
        }

        //Output: 1 3 5 6 7 7 8 15 20 30 40

    }
    static void mergeSort(int[] ary, int min, int max) {

        if(min>=max){
            return;
        }

        //Divide the array
        int mid = (min + max) / 2;
        mergeSort(ary, min, mid);
        mergeSort(ary, mid + 1, max);

        merge1(ary, min, mid, max);//there are two sorted sub arrays min->mid and mid+1->max, merge them

    }
    static void merge1(int[] ary, int min, int mid, int max){
        int l1 = mid-min+1;//length of the first subarray
        int l2 = max-mid;//length of second sub array

        //initializing temp aux arrays
        int[] aux1 = new int[l1];
        int[] aux2 = new int[l2];

        //populating aux arrays
        for (int i=0; i<l1; i++)
            aux1[i] = ary[min + i];
        for (int j=0; j<l2; j++)
            aux2[j] = ary[mid + 1+ j];

        //sort the sorted aux arrays.do it in on ary itself
        int i = 0, j=0, k = min;
        while (i < aux1.length && j < aux2.length)  {
            if (aux1[i] <= aux2[j]) {
                ary[k++] = aux1[i++];
            }
            else  {
                ary[k++] = aux2[j++];
            }
        }

        //copy the remaining values
        if(i< aux1.length){
            while (i< aux1.length){
                ary[k++] = aux1[i++];
            }
        }

        if(j < aux2.length){
            while (j < aux2.length){
                ary[k++] = aux2[j++];
            }
        }

    }

}
