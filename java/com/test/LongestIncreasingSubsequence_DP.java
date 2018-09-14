package com.test;

public class LongestIncreasingSubsequence_DP {
    public static void main(String[] arg){
        int[] ip = {3, 4, -1, 0, 6, 2, 3};
        printLSS(ip);

        /*
        Output:
        Longest subsequence length: 4
        Longest subsequence: -1 0 2 3
         */
    }

    //O(n^2)
    private static void printLSS(int[] ip){
        int[] aux = new int[ip.length];
        int seqLen = -1, seqInd = -1;
        for(int i = 0; i < ip.length; i++){
            aux[i] = 1;//as in the worstcase the length of the sub sequence at every place is atleast 1
        }


        for(int i =1; i < ip.length; i++){
            for(int j = 0; j< i; j++){
                if(ip[i] > ip[j] && aux[j] + 1 > aux[i]){//if 00
                    aux[i] = aux[j] + 1;
                    if(aux[i] > seqLen){
                        seqLen = aux[i];
                        seqInd = i;
                    }
                }
            }
        }

        System.out.println("Longest subsequence length: "+seqLen);

        //for printing the sequence we need to traverse the aux ary starting at index seqInd
        int curMin = Integer.MAX_VALUE;
        int[] subSeqRev = new int[seqLen]; int cnt = 0;//for storing the subsequence in rev
        for(int i = seqInd ; i>= 0; i--){
            if(aux[i] < curMin){//the first value is the part of the sub sequence
                 curMin = aux[i];
                 subSeqRev[cnt++] = ip[i];
            }
        }


        System.out.print("Longest subsequence: ");
        for(int i = subSeqRev.length -1; i>=0; i--){
            System.out.print(subSeqRev[i]+" ");
        }

    }

}
