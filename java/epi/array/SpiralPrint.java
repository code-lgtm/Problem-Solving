package epi.array;

//Print nxn matrix in spiral order in O(nxn) time and O(1) space
public class SpiralPrint {

    public static void main(String[] args) {

        int[][] mat = {
                { 1 ,   2 ,  3  , 4},
                { 5  ,  6 ,  7  , 8},
                { 9  , 10  ,11  ,12},
                { 13 , 14 , 15 , 16}
        };

        printSpiral(mat);

        //Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

    }

    static void printSpiral(int[][] mat){
        int margin = 0;
        int row= 0, col = 0;
        while (margin <= mat.length /2){

//row forward
            for (int i = margin; i < mat[0].length - margin; i++){
                System.out.print(mat[row][i ] +" ");
                col = i;
            }
//col down
            for (int i = row+1; i < mat.length - margin ; i++){
                System.out.print(mat[i][col ] +" ");
                row = i;
            }
//row back
            for (int i = col-1; i >= margin; i--){
                System.out.print(mat[row][i ] +" ");
                col = i;
            }
//col up
            for (int i = row-1; i >= 1+margin; i--){
                System.out.print(mat[i][col] +" ");
                row = i;
            }

            margin++;
        }
    }
}
