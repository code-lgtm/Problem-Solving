package epi.dp;

//Find the minimum number of edits required to convert a given string to another by performing insertion, remove and replace operations - Time and space (n*m)
//https://www.youtube.com/watch?v=We3YDTzNXEk
public class MinEditDistance {
    public static void main(String[] a){
        String source = "abcdef", dest="azced";
        int editDistance =  getMinEditDistance(source.toCharArray(), dest.toCharArray());
        System.out.println("Min edit distance: "+editDistance);

        /*
        0 1 2 3 4 5 6
        1 0 1 2 3 4 5
        2 1 1 2 3 4 5
        3 2 2 1 2 3 4
        4 3 3 2 2 2 3
        5 4 4 3 2 3 3
        Min edit distance: 3
         */
    }

    //O(m*n) time and space
    private static int getMinEditDistance(char[] source, char[] dest){

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
                    //then no additonal case is incurred, copy top diagonal
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
        printMat(aux);
        return aux[aux.length - 1][aux[0].length -1];

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
