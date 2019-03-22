package epi.dp;

//Find the total number of ways to reach the right most element of the matrix from 0,0 when the only allowed moves are right and down - Time and Space O(rows*cols)
public class TotalWaysMatrix {
    public static void main(String[] args){
        int rows = 5;
        int cols = 5;
        int numWays = getNumWays(rows, cols);
        System.out.println("Number of ways: "+numWays);
        /*
        Output:
        1 1 1 1 1
        1 2 3 4 5
        1 3 6 10 15
        1 4 10 20 35
        1 5 15 35 70
        Number of ways: 70
         */
    }

    static int getNumWays(int rows, int cols){
        int[][] auxMat = new int[rows][cols];

        //Setting the first row and col as 1
        for (int i=0; i < rows; i++){
            auxMat[i][0] = 1;
        }

        for (int i=0; i < cols; i++){
            auxMat[0][i] = 1;
        }

        //the way you can reach i,j is sum of i-1, j and i, j-1
        for (int row = 1; row< rows; row++){
            for (int col = 1; col<cols; col++){
                auxMat[row][col] = auxMat[row-1][col] + auxMat[row][col-1];
            }
        }

        printMat(auxMat);
        return auxMat[rows-1][cols-1];
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
