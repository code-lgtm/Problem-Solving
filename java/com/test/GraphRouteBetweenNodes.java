package com.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphRouteBetweenNodes {
    //check if a path exists between two vertices in a directed graph
    private static class GNode{
        char value;
        boolean visited;
        List<GNode> adj = new LinkedList<GNode>();

        public GNode(char value){
            this.value = value;
        }
    }
    public static void main(String[] args) {

    /*
Graph

    e -> f-> g
          \
           >
            h
     */

        GNode e = new GNode('e');
        GNode f = new GNode('f');
        GNode g = new GNode('g');
        GNode h = new GNode('h');
        e.adj.add(f);
        f.adj.add(g);
        f.adj.add(h);

        System.out.println("Path exists between e and h: "+pathExists(e, h));
        System.out.println("Path exists between h and g: "+pathExists(h, g));

        /*
        Output:
            Path exists between e and h: true
            Path exists between h and g: false
         */

    }

    private static boolean pathExists(GNode x, GNode y){
        //Simply do a BFS till the node is found, or we have traversed the complete graph
        //Time comlexity O(V + E)

        Queue<GNode> nodeList = new LinkedList<GNode>() ;
        nodeList.add(x);

        while(!nodeList.isEmpty()){
          GNode cur = nodeList.remove();
          cur.visited = true;
          if(cur.equals(y)){
              return true;//path found
          }else{
              for(GNode adj: cur.adj){
                  if(! adj.visited){
                      nodeList.add(adj);
                  }
              }
          }
        }

        return false;
    }
}
