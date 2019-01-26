package epi.array;

import java.util.HashSet;
import java.util.Set;

//check of a n*n sudoku is valid in (n^2) time and O(n) space
public class IsValidSudoku {
    public static void main(String[] args){
        int[][] board =  {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        int[][] board2 =  {
                { 5, 3, 0, 0, 7, 0, 1, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 1 },//duplicate in this region
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 0 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        System.out.println(isValid(board));
        System.out.println(isValid(board2));

        /*
        Output:
        true
        false
         */
    }

    /*Time complexity: O(n^2) [for row and column] +   (O(sqrt(n)) * O(sqrt(n)) * O(sqrt(n)) * O(sqrt(n))) [for region]
                      = O(n^2) + (n^2)
                      = (n^2)
      Space complexity: O(n)
                    */
    static boolean isValid(int[][] board){

        Set<Integer> seenRow = null, seenColumn=null, seenRegion;

        //check unquiness at row level
        for (int i = 0; i < board.length; i++){
            seenRow = new HashSet<>();
            seenColumn = new HashSet<>();
            for (int j = 0; j< board[0].length; j++){
                //check row
                if(board[i][j] != 0) {
                    if (seenRow.contains(board[i][j])) {
                        return false;
                    } else {
                        seenRow.add(board[i][j]);
                    }
                }
                //check column
                if(board[j][i] != 0) {
                    if (seenColumn.contains(board[j][i])) {
                        return false;
                    } else {
                        seenColumn.add(board[j][i]);
                    }
                }
            }
        }

        seenRow = null; seenColumn = null;
        //check region


        for (int i = 0; i < board.length; i+=3){
            for (int j = 0; j< board[0].length; j+=3){
                seenRegion = new HashSet<>();

                int regionLen = (int)Math.sqrt(board.length);
                int regionHeight = (int)Math.sqrt(board[0].length);
                for (int x = i; x < i+regionLen; x++){
                    for (int y = j; y < j+regionHeight; y++){
                        if(board[x][y] != 0) {
                            if (seenRegion.contains(board[x][y])) {
                                return false;
                            } else {
                                seenRegion.add(board[x][y]);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

}
