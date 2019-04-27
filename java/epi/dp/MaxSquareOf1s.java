package epi.dp;

public class MaxSquareOf1s {
//Find the max are of squares of 1s - Time and space O(row * col)
    public static void main(String[] args){
        int[][] mat = {
                {1,0,0,1},
                {0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}
        };

        int maxArea = getMaxArea(mat);
        System.out.println("max area: "+maxArea);

        //max area: 2

        /*
        Output:

0 0 0 0 0
0 1 0 0 1
0 0 1 1 0
0 1 1 2 1
0 1 1 2 2
0 1 1 0 0
max area: 2

         */
    }

    static int getMaxArea(int[][] mat){
        int maxArea = -1;

        int[][] aux = new int[mat.length + 1][mat[0].length+1];//keeping one additional row and column

        for(int row = 0; row < mat.length; row++){
            for (int col = 0; col< mat[0].length; col++){

                if (mat[row][col] == 0){
                    aux[row+1][col+1] = 0;
                }else {//mat has a 1
                    //check if the diagonal in aux > 0 and the left and up values are in mat 1, then set aux = aux's diagonal + 1
                    if (aux[row][col] > 0 && check1(mat, row, col)){
                        //check the min of left, up and diagonal . And then add one
                        aux[row+1][col+1] = Integer.min(aux[row][col], Integer.min(aux[row][col+1], aux[row+1][col])) + 1;
                    }else{
                        aux[row+1][col+1] = 1;
                    }
                }


                maxArea = Integer.max(aux[row+1][col+1], maxArea);//see if we have a new max
            }
        }

        printMat(aux);

        return maxArea;
    }
/****************************************/
    //check if left and up values are set as 1
    static boolean check1(int[][] mat, int row, int col){

        if(row-1 >=0 && col-1 > 0){
            return mat[row][col-1] == 1 && mat[row-1][col] == 1;
        }
        return false;
    }

    static void printMat(int[][] mat){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
