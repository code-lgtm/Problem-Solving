package epi.array;


import java.util.Arrays;

//Find the next lexographically sorted number in O(n) time and O(1) space. For example for the input (6,2,1,5,4,3,0} the next number will be (6,2,3,0,1,4,5}
public class LexographicPermutation {

    public static void main(String[] args) {

        int[] ip = {6,2,1,5,4,3,0}, ip2={5,4,3,2,1};

        int[] next = getNext(ip);
        if (next!= null) {
            Arrays.stream(next).forEach(i -> System.out.print(i));
        }else {
            System.out.println("No next value is possible");
        }
        System.out.println();
        next = getNext(ip2);
        if (next!= null) {
            Arrays.stream(next).forEach(i -> System.out.print(i));
        }else {
            System.out.println("No next value is possible");
        }

        /*
        output:

        6230145
        No next value is possible
         */

    }

    static int[] getNext(int[] ip){

        //find the first decreasing element from right, if none found then no next sequence is possible
        int firstMinInd = -1;
        for (int i  = ip.length-1; i >=1;i--){
            if(ip[i-1] < ip[i]){
                firstMinInd = i-1;
                break;
            }
            if(i-1 == 0){//the nummber is biggest and no next sequence is possible
                return null;
            }
        }

        //find the smallest number which is greater than ip[firstMinInd] from right
        int smallestBigIndex = -1;
        for (int i  = ip.length-1; i >firstMinInd;i--){
            if (ip[i] > ip[firstMinInd]){
                smallestBigIndex = i;
                break;
            }
        }

        //swap smallestBigIndex and firstMinInd, as smallestBigIndex is the smallest number which is greater than firstMinInd
        int temp = ip[smallestBigIndex];
        ip[smallestBigIndex] = ip[firstMinInd];
        ip[firstMinInd] = temp;

        int mid = firstMinInd+1 + ((ip.length-1 - firstMinInd - 1)/2);//for inline reversal
        //now we need to reverse the numbers from firstMinInd+1 to  ip.length-1
        for (int left = firstMinInd+1, right=ip.length-1; left <= mid;left++, right--){
            temp = ip[left];
            ip[left] = ip[right];
            ip[right] = temp;

        }


        return ip;
    }

}
