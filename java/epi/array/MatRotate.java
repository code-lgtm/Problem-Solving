package epi.array;
//Rotate a matrix clockwise in constant space
public class MatRotate {

    public static void main(String[] args) {

        int[][] mat = {
                { 1 ,   2 ,  3  , 4},
                { 5  ,  6 ,  7  , 8},
                { 9  , 10  ,11  ,12},
                { 13 , 14 , 15 , 16}
        };

        rotate(mat);
        print(mat);

        /*
        Output:

        13 9 5 1
        14 10 6 2
        15 11 7 3
        16 12 8 4

         */

    }

    static int[][] rotate(int[][] mat){

        int k = mat.length-1;

        //number of squares will be floor(mar.length/2)
        for (int i = 0; i < mat.length/2; i++){
            //inner loop will be under the bounds of the nested squares
            for (int j = i; j < k-i; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[k-j][i];
                mat[k-j][i] = mat[k-i][k-j];
                mat[k-i][k-j] = mat[j][k-i];
                mat[j][k-i] = temp;
            }
        }

        return mat;
    }

    static void print(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] +" ");
            }
            System.out.println();
        }
    }
}
