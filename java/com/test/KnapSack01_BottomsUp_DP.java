package com.test;

public class KnapSack01_BottomsUp_DP {

    public static  void main(String[] args){

        int[] weight = {1,3,4,5};
        int[] val = {1,4,5,7};
        int sackCapacity = 7;

        printMaxValue(weight, val, sackCapacity);

    }

    private static void  printMaxValue(int[] weight, int[] val, int sackCapacity){

        int[][] aux = new int[weight.length + 1][sackCapacity + 1];

        for(int i = 1; i < aux.length; i++){
            for(int j = 1; j < aux[0].length; j++){

                if( j < weight[i -1]){//this weight can't be picked, copy the value from the top
                    aux[i][j] = aux[i-1][j];
                }else{
                    int max = Math.max(val[i-1] + aux[i-1][j - weight[i-1]], aux[i-1][j]);//the weight can be picked, check if picking or not picking this will offer the max value
                    aux[i][j] = max;
                }

            }
        }
        System.out.println(aux[aux.length -1][aux[0].length-1]);
       // printMat(aux);

    }


    //for debugging/visualizing the computation
    private static void printMat(int[][] mat){
        for(int i=0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j]);
            }
            System.out.println("");
        }
    }

}
