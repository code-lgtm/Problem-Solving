package epi.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FillEnclosedRegion {

    /*

    start from the given point, if it's has value 1 then fill all the neighbouring 1s except the 1s which are on the boundary.
    Expected output:
            {0,0,0,0},
            {1,0,0,0},
            {0,0,0,0},
            {0,0,0,0}

     */
    public static void main(String[] args){
        int[][] maze = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        int[] start = {2,1};
        int[][] filledMaze = fillMaze(maze, start);
        print(filledMaze);

        /*
        Output:
        0 0 0 0
        1 0 0 0
        0 0 0 0
        0 0 0 0

         */
    }

    static int[][] fillMaze(int[][] maze, int[] start){

        boolean[][] visitedMat = new boolean[maze.length][maze[0].length];
        int[][] moves = {{-1,0}, {0,-1}, {1,0}, {0,1}};

        Queue<int[]> bfs = new LinkedList<int[]>();
        bfs.add(start);

        while (! bfs.isEmpty()){
            int[] cur = bfs.remove();
            if(maze[cur[0]][cur[1]] != 1){
                break;
            }

            maze[cur[0]][cur[1]] = 0;//paint the maze
            visitedMat[cur[0]][cur[1]] = true;

            for(int i = 0; i < moves.length; i++){
                int nextX = cur[0] + moves[i][0];
                int nextY = cur[1] + moves[i][1];
                if(isValid(maze,visitedMat, nextX, nextY)){//next co-ordinates falls within the boundar and have value 1
                    int[] next = {nextX, nextY};
                    bfs.add(next);
                }
            }
        }

        return maze;
    }

    static boolean isValid(int[][] maze,boolean[][] visitedMat, int nextX, int nextY){//next co-ordinates falls within the boundar and have value 1 and isnt previously visited
        return nextX > 0 && nextX < maze.length -1 && nextX > 0 &&
                nextY < maze[0].length -1 && maze[nextX][nextY] == 1
                && !visitedMat[nextX][nextY];
    }

    static boolean print(int[][] sol){
        for(int i = 0; i < sol.length; i++){
            for(int j =0; j <sol[0].length; j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
        return true;
    }
}
