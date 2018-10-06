package com.test;

import java.util.*;

/*
https://www.youtube.com/watch?v=ddTC4Zovtbc

Find the build order of dependent components. Implemented using Topological sort
Time complexity: O(v + e), space comlexity: O(v)

Output:
Build order:
d a b e c f

 */

public class TopologicalSort_BuildOrder {
   private static Set<GNode> visited = new HashSet<GNode>();
   private static Stack<GNode> revDependencies = new Stack<GNode>();

    private static class GNode{
        GNode parent = null;
        char value;
        List<GNode> adj = new LinkedList<GNode>();

        public GNode(char value){
            this.value = value;
        }
    }




    public static void main(String[] args){
    /*

Graphs is not strongly connected, that is not all the vertices can be reached for all other vertices

    a -> b    c
    >        >|
    |    |  / |
    |   >  /  >
    d   e    f

     */

        //populate the graph
        GNode a = new GNode('a');
        GNode b = new GNode('b');
        GNode c = new GNode('c');
        GNode d = new GNode('d');
        GNode e = new GNode('e');
        GNode f = new GNode('f');

        a.adj.add(b);
        d.adj.add(a);
        b.adj.add(e);
      //  e.adj.add(d);
        e.adj.add(c);
        c.adj.add(f);
        f.adj.add(f);//self loop at f

        //initializing vertices to iterate over the list of vertices as outer loop
        GNode[] vertices = new GNode[6];
        vertices[0] = a;
        vertices[1] = b;
        vertices[2] = c;
        vertices[3] = d;
        vertices[4] = e;
        vertices[5] = f;


        for(GNode g: vertices){
            findBuildOrder(g);
        }

        //revDependencies will have topological sort in the reverse order
        System.out.println("Build order: ");
        while (! revDependencies.isEmpty()){
            System.out.print(revDependencies.pop().value+" ");
        }

    }


    //this method performs DFS and adds the nodes with no dependencies or already resolved dependencies in a stack, reverse of the stack is topological sorted order (build order)
    private static void findBuildOrder(GNode node){

        if(visited.contains(node)){
            return;
        }else {
            visited.add(node);
        }


        for (GNode temp: node.adj){
            findBuildOrder(temp);
        }

        revDependencies.push(node);

    }

}
