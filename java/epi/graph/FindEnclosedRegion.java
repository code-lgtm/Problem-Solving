package epi.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEnclosedRegion {
    //Find the region which is completely enclosed (doesn't touch boundary)

    static int[][] maze = {
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
            {0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };

    static boolean[][] visited = new boolean[maze.length][maze[0].length];
    static int[][] moves = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    public static void main(String[] args){
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                if(! visited[i][j] && maze[i][j] != 0){
                    List<int[]> enclosed = getEnclosed(maze, i, j);
                    if(enclosed!= null) {
                        System.out.println("enclosed points: "+enclosed.size());
                        for(int[] point:enclosed){
                            System.out.print("("+point[0]+","+point[1]+") ");
                        }
                    }
                }
            }
        }
    }


    static List<int[]> getEnclosed(int[][] maze, int x, int y){
        Queue<int[]> bfs = new LinkedList<int[]>();
        int[] temp = {x, y};
        bfs.add(temp);
        List<int[]> enclosedRegion = new ArrayList<int[]>();

        while(!bfs.isEmpty()){
            int[] cur = bfs.remove();

            for (int i = 0; i < moves.length; i++){// move in all the 4 directions
                int nextX = cur[0] + moves[i][0];
                int nextY = cur[1] + moves[i][1];

                if (isValid(maze, nextX, nextY)){//co-ordinate is within range
                    if( (nextX== 0 && maze[nextX][nextY] == 1) ||
                            (nextX== maze.length-1 && maze[nextX][nextY] == 1) ||
                            (nextY== 0 && maze[nextX][nextY] == 1) ||
                            (nextY== maze[0].length-1 && maze[nextX][nextY] == 1) ){//we are at boundary and the value is 1, that means the region cannot be enclosed
                        return null;
                    }else if(!visited[nextX][nextY] && maze[nextX][nextY] == 1 ){//next point isn't already visited and has value 1 then add it in the queue
                        visited[nextX][nextY] = true;
                        int[] next = {nextX, nextY};
                        enclosedRegion.add(next);
                        bfs.add(next);
                    }
                }
            }
        }

        return enclosedRegion;
    }

    static boolean isValid(int[][] maze, int nextX, int nextY){
        return nextX >=0 && nextX <= maze.length-1 && nextY >= 0 && nextY <= maze[0].length-1;
    }
}
