package epi.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath_KStepJumps {
    /*
    https://www.techiedelight.com/find-shortest-path-source-destination-matrix-satisfies-given-constraints/
    Given a N x N matrix of positive integers, find shortest path from the first cell of the matrix to its last cell that satisfies given constraints:

    We can move exactly k steps from any cell in the matrix where k is the value of that cell. i.e. from any cell x = M[i][j] in the matrix M, we can move to location
    M[i + x][j] or M[i – x][j] or M[i][j + x] or M[i][j – x] THAT IS DOWN, UP, RIGHT AND LEFT
    Note that we are not allowed to make any diagonal moves
     */

    public static void main(String[] args){
        int[][] maze = {
                {7,1,3,5,3,6,1,1,7,5},
                {2,3,6,1,1,6,6,6,1,2},
                {6,1,7,2,1,4,7,6,6,2},
                {6,6,7,1,3,3,5,1,3,4},
                {5,5,6,1,5,4,6,1,7,4},
                {3,5,5,2,7,5,3,4,3,6},
                {4,1,4,3,6,4,5,3,2,6},
                {4,4,1,7,4,3,3,1,4,2},
                {4,4,5,1,5,2,3,5,3,5},
                {3,6,3,5,2,2,6,4,2,1}
        };

        //get path from 0,0 to the last point in the mat
        int[] start = {0,0};
        List<int[]> path = getShortestPath(maze, start);
        System.out.println(path==null?"No Path found":path.size());

        if(path!= null){
            for(int[] point: path){
                System.out.print(point[0]+","+point[1] + " -> ");
            }
        }

    }

    static List<int[]> getShortestPath(int[][] maze, int[] start){

        Queue<Node> bfs = new LinkedList<Node>();
        boolean[][] visitMat = new boolean[maze.length][maze[0].length];
        int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};

        List<int[]> path = new LinkedList<int[]>();
        path.add(start);
        bfs.add(new Node(0, start, path));

        while (! bfs.isEmpty()){
            Node cur = bfs.remove();
            visitMat[cur.coOrdinate[0]][cur.coOrdinate[1]] = true;
            if(cur.coOrdinate[0] == maze.length-1 && cur.coOrdinate[1] == maze[0].length-1){//reached end
              //  System.out.println(cur.level);
                return cur.path;
            }

            for(int i=0; i<moves.length; i++){
                int nextX =  cur.coOrdinate[0] + (maze[cur.coOrdinate[0]][cur.coOrdinate[1]] * moves[i][0]);
                int nextY =  cur.coOrdinate[1] + (maze[cur.coOrdinate[0]][cur.coOrdinate[1]] * moves[i][1]);

                if(isValidMove(maze, visitMat, nextX, nextY)){
                    int[] next = {nextX, nextY};
                    List<int[]> newPath = new ArrayList<int[]>(cur.path);
                    newPath.add(next);
                    bfs.add(new Node(cur.level+1, next, newPath));
                }

            }

        }

        return null;
    }

static boolean isValidMove(int[][] maze, boolean[][] visitMat, int x, int y){//within bounds and unvisited
        return (x >= 0 && x <= maze.length-1) && (y>= 0 && y <= maze[0].length-1) && !visitMat[x][y];
}

    static class Node{
        int level;
        int[] coOrdinate;
        List<int[]> path;
        Node(int level, int[] coOrdinate, List<int[]> path){
            this.level = level;
            this.coOrdinate = coOrdinate;
            this.path = path;
        }
    }
}
