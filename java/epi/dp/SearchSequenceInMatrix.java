package epi.dp;

import java.util.HashSet;
import java.util.Set;

/*
Match a pattern p in a n*m matrix. You can go up, down, left and right from every point - Time O(n*m*s). Space O(s) for the recursion tree

Example:
{6,10,14,15} matches the given input
{6,7,10,11} doesn't matche the given input

1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16


 */
public class SearchSequenceInMatrix {
    static class Point{
        int curX, cutY, offset;
        Point(int curX, int cutY, int offset){
            this.curX = curX;
            this.cutY = cutY;
            this.offset = offset;
        }

        @Override
        public boolean equals(Object o) {
            Point p = (Point)o;
            return this.curX == p.curX &&
                    this.cutY==p.cutY &&
                    this.offset == p.offset;
        }

        @Override
        public int hashCode() {
            return this.curX + this.cutY + this.offset;
        }
    }

    public static void main(String[] args){
        int x = 4;
        int y = 4;
        int[][] mat = new int[x][y];
        int cnt = 0;
        int[] pattern1 = {6,10,14,15};
        int[] pattern2 = {6,7,10,11};
        for (int i = 0 ; i < mat.length; i++){
            for (int j = 0; j< mat[0].length; j++){
                mat[i][j] = ++cnt;
            }
        }
        printMat(mat);

        System.out.println(findMatchDriver(mat,pattern1));
        System.out.println(findMatchDriver(mat,pattern2));

        /*
        Output:
        1  2  3  4
        5  6  7  8
        9  10 11 12
        13 14 15 16
        true
        false
         */

    }

    static boolean findMatchDriver(int[][] mat, int[] pattern){
        Set<Point> noMatches = new HashSet<>();

        //start the matching when the first character matches
        for (int i = 0; i < mat.length; i++){
            for (int j=0; j< mat[0].length; j++){
                if (mat[i][j] == pattern[0]
                        && containsPattern(mat, pattern, i, j, 0, noMatches)){
                    return true;
                }
            }
        }


        return false;
    }

    static boolean containsPattern(int[][] mat, int[] pattern, int curX, int cutY, int offset, Set<Point> noMatches){

        if (pattern.length == offset){
            return true;//pattern matched
        }

        if (noMatches.contains(new Point(curX, cutY, offset))){//this subproblem has already been solved and no match was found
            return false;
        }

        if (curX < 0 || curX>= mat.length || cutY<0 || cutY>= mat[0].length){//points should be in bounds
            return false;
        }

        if (mat[curX][cutY] == pattern[offset]){

            //now move in all the four directions and see if we can match the pattern
            if (containsPattern(mat, pattern, curX+1, cutY, offset+1, noMatches) ||
                    containsPattern(mat, pattern, curX, cutY+1, offset+1, noMatches) ||
                    containsPattern(mat, pattern, curX-1, cutY, offset+1, noMatches) ||
                    containsPattern(mat, pattern, curX, cutY-1, offset+1, noMatches)){
                return true;
            }else {
                //even though mat[curX][cutY] == pattern[offset], still the pattern didn't march going forward
                noMatches.add(new Point(curX, cutY, offset));
            }
        }

        return false;
    }



    static void printMat(int[][] mat){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j]+ (mat[i][j]<10?"  ":" "));
            }
            System.out.println();
        }
    }
}
