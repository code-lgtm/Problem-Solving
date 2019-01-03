package epi.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathLengthInBinaryMaze {

    //https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/

    public static void main(String[] args){
        int[][] maze = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };

        int[] source = {0,0};
        int[] dest = {3,4};
        int[] dest2 = {4,6};
        int[] dest3 = {7,5};


        System.out.println(getPath(maze, source, dest));
        System.out.println(getPath(maze, source, dest2));
        System.out.println(getPath(maze, source, dest3));

        /*
        Output:

        11
        14
        -1
         */
    }

    static int getPath(int[][] maze, int[] source, int[] dest){

        boolean[][] visitMat = new boolean[maze.length][maze[0].length]; // for keeping track of visited nodes

        Queue<int[]> bfs = new LinkedList<int[]>();
        bfs.add(source);
        bfs.add(null);
        int moves = 0;
        while(!bfs.isEmpty()){

            int[] cur = bfs.remove();
            if(cur==null){//for counting the elements, breat first will give the shortest path, this technique counts the number of levels travelled
                moves++;
                if(!bfs.isEmpty()) {
                    bfs.add(null);
                }
                continue;
            }

            if(cur[0] == dest[0] && cur[1] == dest[1]){//reached destination
                visitMat[dest[0]][dest[1]] = true;
              //  print(visitMat);
                return moves;
            }

            // go in all four directions
            //right= x y+1 , left = x, y-1 , up = x-1 , y, down = x+1, y

            //try right
            int[] next = {cur[0], cur[1]+1};//right
            if(isValidIndex(maze, visitMat, next[0], next[1] )){
                visitMat[next[0]][next[1]] = true;
                bfs.add(next);
            }

            //try left
            int[] next2 = {cur[0], cur[1]-1};//right
            if(isValidIndex(maze, visitMat, next2[0], next2[1] )){
                visitMat[next2[0]][next2[1]] = true;
                bfs.add(next2);
            }

            //try up
            int[] next3 = {cur[0]-1, cur[1]};//right
            if(isValidIndex(maze, visitMat, next3[0], next3[1] )){
                visitMat[next3[0]][next3[1]] = true;
                bfs.add(next3);
            }

            //down
            int[] next4 = {cur[0]+1, cur[1]};//right
            if(isValidIndex(maze, visitMat, next4[0], next4[1] )){
                visitMat[next4[0]][next4[1]] = true;
                bfs.add(next4);
            }




        }

        return -1;//dest un reachable
    }

    static boolean isValidIndex(int[][] maze, boolean[][] visitMat, int x, int y){//index is valid and unvisited and is not 0
        return (x >= 0 && x <= maze.length-1) && (y >= 0 && y <= maze[0].length-1) &&
                !visitMat[x][y] && maze[x][y]!= 0;
    }

    static boolean print(boolean[][] sol){
        for(int i = 0; i < sol.length; i++){
            for(int j =0; j <sol[0].length; j++){
                System.out.print(sol[i][j]?"T ":"F ");
            }
            System.out.println();
        }
        return true;
    }

}
