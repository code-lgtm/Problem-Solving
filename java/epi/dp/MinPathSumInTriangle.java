package epi.dp;

//Find the min weight path sum in a triangle - Time & space (n^2) . Space can be further optimised to O(n) as all we are interested is one lower row auxMat: https://www.geeksforgeeks.org/minimum-sum-path-triangle/
public class MinPathSumInTriangle {
    public static void main(String[] a){
        int[][] triangle = {
                {2},
                {4,4},
                {8,5,6},
                {4,2,6,2},
                {1,5,2,3,4}
        };

        int minSum = getMinPathSum(triangle);
        System.out.println("Min Sum: "+minSum);

        /*
        Output:
15 0  0  0  0
13 13 0  0  0
12 9  11 0  0
5  4  8  5  0
1  5  2  3  4
Min Sum: 15
         */
    }

    static int getMinPathSum(int[][] triangle){

        int baseLen = triangle[triangle.length-1].length;//number of elements in the last row
        int[][] auxMat = new int[baseLen][baseLen];

        //start from the bottom's up, copy the last rows weights in the last rows if auxMat
        for (int i = 0; i < baseLen; i++){
            auxMat[auxMat.length-1][i] = triangle[triangle.length-1][i];
        }

        for (int i = triangle.length-2; i >=0; i--){//start from the secondlast row
            for (int j=0; j<triangle[i].length; j++){
                int leftW = triangle[i][j] + auxMat[i+1][j];//weight which we will be getting be selecting the value which is left of triangle[i][j]. triangle[i][j] is the current weight
                int rightW = triangle[i][j] + auxMat[i+1][j+1];//weight which we will be getting be selecting the value which is right of triangle[i][j]. triangle[i][j] is the current weight
                auxMat[i][j] = Math.min(leftW, rightW);//assigned the min weight
            }

        }
        printMat(auxMat);
        return auxMat[0][0];// index 0,0 will have the min wight
    }

    private static void printMat(int[][] mat){
        for(int i=0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j] + (mat[i][j]>9?" ":"  "));
            }
            System.out.println();
        }
    }
}
