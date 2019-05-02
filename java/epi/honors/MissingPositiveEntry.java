package epi.honors;

//Find the minimum positive missing value in an array of size n, which can have positive values till n. Can have 0 and -ve numbers. Time O(n) space O(1)
public class MissingPositiveEntry {

    public static void main(String[] args) {
        int[] ar = {3,5,4,-1,5,1,-1};
        int[] ar2 = {-1,-2,-3,-4};
        int[] ar3 = {-1,-2,-3,-4, 5, 4};
        int[] ar4 = {-1,6,-3,-4, 5, 4};
        int[] ar5 = {-1,1,-3,-4, 5, 2};

        System.out.println("Missing value: "+findMinMissing(ar));
        System.out.println("Missing value: "+findMinMissing(ar2));
        System.out.println("Missing value: "+findMinMissing(ar3));
        System.out.println("Missing value: "+findMinMissing(ar4));
        System.out.println("Missing value: "+findMinMissing(ar5));

        /*
        Output:
        1 -1 3 4 5 -1 -1
        Missing value: 2
        -1 -2 -3 -4
        Missing value: 1
        -1 -2 -3 4 5 -1
        Missing value: 1
        -1 -1 -3 4 5 6
        Missing value: 1
        1 2 -3 -4 5 -1
        Missing value: 3
         */

    }

    //The idea is move say the value 3 to the 3rd position (index 2). So eventually the complete array will become like a hash table
    //the indexes from where the values are moved to new positions cab be marked ar -1. This will help while finding the missing element
    static int findMinMissing(int[] ip) {
        int minMissing = 1;

        for (int i = 0; i < ip.length; i++) {
            //we will pick the numbers >=1 which are not at i-1
            if (ip[i] >= 1 && ip[i] - 1 != i) {

                int destInd = ip[i] - 1; //ip[i] should be moved to ip[i]-1
                ip[i] = -1;//value @ index i will be moved to ip[i] - 1, hence mark ip[i] as -1

                while (true) {//this will place the values at their respective places, starting at i
                    int destVal = ip[destInd];
                    ip[destInd] = destInd + 1;

                    destInd = destVal - 1;

                    if (destInd < 0 || destInd + 1 == ip[destInd]) {
                        break;
                    }
                }

            }
        }
        printAry(ip);//for visualizing the execution

        //Now we have to find the first value > value's index +1 . the min missing +ve number will be lastValue+1
        for (int i = 0; i < ip.length; i++) {
            if (ip[i] < 0) {
                return i+1;
            }
        }


        return minMissing;
    }

    /****************/
    static void printAry(int[] ary){
        for (int j = 0; j < ary.length; j++){
            System.out.print(ary[j]+" ");
        }
        System.out.println();
    }
}
