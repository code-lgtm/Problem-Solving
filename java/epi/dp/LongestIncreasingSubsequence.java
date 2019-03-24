package epi.dp;

//Find the length of longest increasing subsequence - Time O(n^2) , space O(n)
public class LongestIncreasingSubsequence {
    public static void main(String[] arg) {
        int[] ip = {3, 4, -1, 0, 6, 2, 3};

        System.out.println("Longest SubSequence: "+getLongestIncSubLen(ip));

        /*
        1 2 1 2 3 3 4
        Longest SubSequence: 4
         */

    }

    private static int getLongestIncSubLen(int[] ip){
        int[] aux = new int[ip.length];
        int maxLen = -1;
        for (int i = 0; i < ip.length; i++) {
            aux[i] = 1;//as in the worstcase the length of the sub sequence at every place is atleast 1
        }


        for (int i = 1; i < ip.length; i++) {
            for (int j = 0; j < i; j++) {
                if (ip[i] > ip[j] && aux[j] + 1 > aux[i]) {//if current value is less than the value at j and it makes a longer subsequence, then update aux[i]
                    aux[i] = aux[j] + 1;
                    if (aux[i] > maxLen) {
                        maxLen = aux[i];
                    }
                }
            }
        }
        printMat(aux);
        return maxLen;
    }

    private static void printMat(int[] ary){
        for(int i=0; i < ary.length; i++){
            System.out.print(ary[i] +" ");
        }
        System.out.println();
    }
}
