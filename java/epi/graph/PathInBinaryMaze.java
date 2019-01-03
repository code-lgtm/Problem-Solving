package epi.graph;

import java.util.ArrayList;
import java.util.List;

public class PathInBinaryMaze {

    /*Find path from point a to b - PLEASE NOT ITS NOT THE SHORTEST PATH AS WE USE DFS AND BACKTRACKING
    https://www.cs.bu.edu/teaching/alg/maze/

Algo:

    if (x,y outside maze) return false
    if (x,y is goal) return true
    if (x,y not open) return false
    mark x,y as part of solution path
    if (FIND-PATH(North of x,y) == true) return true
    if (FIND-PATH(East of x,y) == true) return true
    if (FIND-PATH(South of x,y) == true) return true
    if (FIND-PATH(West of x,y) == true) return true
    unmark x,y as part of solution path
    return false


*/
    static class Ret{
        boolean foundPath = false;
        List<int[]> path;

        public Ret(boolean foundPath){
            this.foundPath = foundPath;
        }

    }
    //right, down, left, up
    static int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};
    static int[][] maze = {
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
    };

    static boolean[][] visit = new boolean[maze.length][maze[0].length];

    public static void main(String[] args){

        int[] source = {0,0};
        int[] dest = {5,2};

        List<int[]> path = getPath(maze, source, dest, new ArrayList<int[]>(), 0);
        System.out.println(path == null?"No path found":"path found");
        if(path!= null){
            for(int[] point: path){
                System.out.print(point[0]+","+point[1]+" -> ");
            }
        }

        /*
        Output:
        path found
        0,0 -> 1,0 -> 2,0 -> 2,1 -> 2,2 -> 3,2 -> 4,2 -> 5,2 ->
         */

    }

    static List<int[]> getPath(int[][] maze, int[] cur, int[] dest, List<int[]> path, int ind){

        path.add(ind, cur);
        if(cur[0] == dest[0] && cur[1] == dest[1]){//reached destination - base case
            return path;
        }

        // go in all four directions
        //right= x y+1 , left = x, y-1 , up = x-1 , y, down = x+1, y
        for(int i = 0 ; i < moves.length; i++){
            int[] next = {cur[0] + moves[i][0], cur[1]+ moves[i][1]};
            if(isValidIndex(maze, next[0], next[1])){//index is valid and unvisited and is not 0
                List<int[]> tempPath;
                if((tempPath = getPath(maze, next, dest, path, ind+1))!= null){
                    return tempPath;
                }
            }
        }
        path.remove(ind);//back track

        return null;//dest unreachable
    }

    static boolean isValidIndex(int[][] maze, int x, int y){//index is valid and unvisited and is not 0
        return (x >= 0 && x <= maze.length-1) && (y >= 0 && y <= maze[0].length-1) &&
                !visit[x][y] && maze[x][y]!= 0;
    }


}
