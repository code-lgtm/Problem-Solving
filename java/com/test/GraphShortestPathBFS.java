package com.test;

import sun.jvm.hotspot.opto.HaltNode;

import java.util.*;
/*
Graph BFS with Level
 */


public class GraphShortestPathBFS {

    private static class GNode{
        GNode parent = null;
        char value;
        int level;
        List<GNode> adj = new LinkedList<GNode>();

        public GNode(char value){
            this.value = value;
        }
    }


    public static void main(String[] args){
        /*
        creating this undirected graph with 4 vertices and 4 edges
        a
       / \
      b - d - e - f
     /
    c
         */

        GNode a = new GNode('a');
        GNode b =  new GNode('b');
        GNode c = new GNode('c');
        GNode d = new GNode('d');
        GNode e = new GNode('e');
        GNode f = new GNode('f');

        a.adj.add(b);
        b.adj.add(a);

        b.adj.add(d);
        d.adj.add(b);

        a.adj.add(d);
        d.adj.add(a);

        b.adj.add(c);
        c.adj.add(b);

        d.adj.add(e);
        e.adj.add(d);

        e.adj.add(f);
        f.adj.add(e);


        printShortestPathBFS(a, f);




    }

    private static Set<GNode> haveSeen = new HashSet<GNode>();
    private static int level = 0;

    private static void printShortestPathBFS(GNode start, GNode end) {

        Queue<GNode> frontier = new LinkedList<GNode>();
        frontier.add(start);
        frontier.add(null);

        while(! frontier.isEmpty()){
            GNode cur = frontier.remove();

           if(cur == null){//increment the level
                level++;
                if(!frontier.isEmpty()){//to avoid infinite loop
                    frontier.add(null);
                }
                continue;
            }


            if(! haveSeen.contains(cur)){
                haveSeen.add(cur);
                cur.level = level;
                System.out.println("Found New Node: "+cur.value+", Level: "+cur.level);
                for(GNode child: cur.adj){
                    //current is parent of child
                    if(child.parent == null && !child.equals(start)){//child has not been yet visited
                        child.parent = cur;
                    }

                    frontier.add(child);

                    if(child.equals(end)){//We have found the element we were searching for, and have established the child pointers
                        System.out.println("Found "+child.value);
                        break;
                    }
                }

            }



        }


        //Simply traverse from end to start to print the shortest path
        System.out.println("Printing the shortest path");

        GNode cur = end;
        while (cur != null){
            System.out.print(cur.value + " -> ");
            cur = cur.parent;
        }


    }

}
