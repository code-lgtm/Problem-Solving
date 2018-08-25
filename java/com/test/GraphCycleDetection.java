package com.test;

import java.util.*;

public class GraphCycleDetection {
    //private static Set<GNode> hasSeen = new HashSet<GNode>();// avoids duplicate sub graoh traversal
    private static List<GNode> callStack = null; // maintains tha call stack, if we get an element which is already in the stack then a cycle has been found

    private static class GNode{
        GNode parent = null;
        char value;
        List<GNode> adj = new LinkedList<GNode>();

        public GNode(char value){
            this.value = value;
        }
    }


    /*
Graph 1:
    a   <-d
    | \   >
    >   > |
    b -> c

Graph 2:
    e -> f-> g
          \
           >
            h
     */



    public static void main(String[] args) {

        //Graph 1 initialization with Cycle
        GNode a = new GNode('a');
        GNode b = new GNode('b');
        GNode c = new GNode('c');
        GNode d = new GNode('d');

        a.adj.add(b);
        a.adj.add(c);
        b.adj.add(c);
        c.adj.add(d);
        d.adj.add(a);

        //initializing vertices to iterate over the list of vertices as outer loop
        GNode[] vertices = new GNode[4];
        vertices[0] = a;
        vertices[1] = b;
        vertices[2] = c;
        vertices[3] = d;


        //Time complexity: O(V+E)2 // algo performs a dfs for every vertex, as graph may not be strongly connected

        for(GNode v: vertices){
            callStack = new LinkedList<>();//initializing with an empty call stack
            System.out.println("Cycle detected from: "+v.value+" : "+dfsCycleVisit(v));
        }


        //working with Graph 2 now, which is acyclic
        GNode e = new GNode('e');
        GNode f = new GNode('f');
        GNode g = new GNode('g');
        GNode h = new GNode('h');

        e.adj.add(f);
        f.adj.add(g);
        f.adj.add(h);

        vertices[0] = e;
        vertices[1] = f;
        vertices[2] = g;
        vertices[3] = h;

        for(GNode v: vertices){
            callStack = new LinkedList<>();//initializing with an empty call stack
            System.out.println("Cycle detected from: "+v.value+" : "+dfsCycleVisit(v));
        }

    }

    //visits the vertices recursively and checks for the cycle using call stack
    private static boolean dfsCycleVisit(GNode v){

        if(callStack.contains(v)){
            return true;
        }else{
            callStack.add(v);
        }

        for(GNode ad: v.adj){
            return dfsCycleVisit(ad);
        }

        return false;

    }
}
