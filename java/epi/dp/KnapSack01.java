package epi.dp;

//Solve 01 KnapSack problem  - Time & space (items^2)
public class KnapSack01 {
    public static  void main(String[] args){

        int[] weight = {1,3,4,5};
        int[] val = {1,4,5,7};
        int sackCapacity = 7;

        System.out.println("Max value: "+getMaxValue(weight, val, sackCapacity));
/*
Output:
0 0 0 0 0 0 0 0
0 1 1 1 1 1 1 1
0 1 1 4 5 5 5 5
0 1 1 4 5 6 6 9
0 1 1 4 5 7 8 9
Max value: 9
 */
    }

    private static int getMaxValue(int[] weight, int[] val, int sackCapacity){

        int[][] aux = new int[weight.length + 1][sackCapacity + 1];

        for(int itm = 1; itm < aux.length; itm++){
            for(int wt = 1; wt < aux[0].length; wt++){

                if( wt < weight[itm -1]){//this weight can't be picked, copy the value from the top
                    aux[itm][wt] = aux[itm-1][wt];
                }else{

                    int notPickCurrent = aux[itm-1][wt];//value from the top
                    int pickCurrent = val[itm-1] +  aux[itm-1][wt - weight[itm-1]];//current value + the value of the remaining weight

                    int max = Math.max(notPickCurrent,pickCurrent);//the weight can be picked, check if picking or not picking this will offer the max value
                    aux[itm][wt] = max;
                }

            }
        }

        printMat(aux);
        return  aux[aux.length -1][aux[0].length-1];

    }


    private static void printMat(int[][] mat){
        for(int i=0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j] +" ");
            }
            System.out.println();
        }
    }
}
