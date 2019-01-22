package epi.array;


public class DutchFlag {
    //arrange the values < a given pivot on left, and > on the right - Time - O(n) space O(1)

    public static void main(String[] args){
      //  int[] ip = {1,2,3,1,2,3,1,2,3,1,2,3};
        int[] ip = {2,1,1,3,3,3,2,2,1,1,2};
        int pivot = 2;

        dutchFlagPartition( ip, pivot);
        for (int i: ip){
            System.out.print(i+" ");
        }

        //Output: 1 1 1 1 2 2 2 2 3 3 3 
    }

    public static void dutchFlagPartition(int[] ip, int pivot) {

        //two pass approach

        //pass1 - left -> right . move the values less than the pivot to the left

        int left = 0, right = ip.length-1;
        for (int i = 0 ; i < ip.length; i++){
            if(ip[i]<pivot){
                int temp = ip[i];
                ip[i] = ip[left];
                ip[left] = temp;
                left++;
            }
        }

        //pass1 - right -> left . move the values more than the pivot to the right
       for (int i = ip.length-1 ; i >=0; i--){
            if(ip[i] > pivot){
                int temp = ip[i];
                ip[i] = ip[right];
                ip[right] = temp;
                right--;
            }
        }

    }



}
