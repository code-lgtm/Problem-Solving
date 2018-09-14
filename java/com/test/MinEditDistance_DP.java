package com.test;

public class MinEditDistance_DP {
    public static void main(String[] a){
        String source = "abcdef", dest="azced";
        printMinEditDistance(source.toCharArray(), dest.toCharArray());

    }

    //O(m*n) time and space
    private static void printMinEditDistance(char[] source, char[] dest){

        int[][] aux = new int[dest.length + 1][source.length + 1];

        //the idea is to compare each char with null and write the edit distance in the first row and column. The edit dis will be equal to the length of the string till that point
        for(int i = 0; i < aux[0].length; i++){
            aux[0][i] = i; // initializing the first row
        }
        for(int i = 0; i < aux.length; i++){
            aux[i][0] = i;// initializing the first column
        }


        for(int i = 0; i < aux.length-1; i++){
            for(int j = 0; j < aux[0].length-1; j++){

                if(dest[i] == source[j]){
                    //then no additonal cose is incurred, copy top diagonal
                    aux[i+1][j+1] =  aux[i][j];
                }else{//get min (left, top diagonal and diagonal )
                    int left = aux[i+1][j];
                    int diag = aux[i][j];
                    int top = aux[i][j+1];
                    int min = left <= top ? (left <= diag? left:diag) : (top <= diag? top:diag);
                    aux[i+1][j+1] = min +1;
                }

            }
        }

        System.out.println("Min Dis: "+ aux[aux.length - 1][aux[0].length -1]);

    }

}
