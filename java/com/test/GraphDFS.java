package com.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GraphDFS {

    private static Set<GNode> hasSeen = new HashSet<GNode>();

    private static class GNode{
        GNode parent = null;
        char value;
        List<GNode> adj = new LinkedList<GNode>();

        public GNode(char value){
            this.value = value;
        }
    }


    /*

Graphs is not strongly connected, that is not all the vertices can be reached for all other vertices

    a -> b    c
       >     /|
    | /  |  / |
    >/   > <  >
    d <- e    f

     */



    public static void main(String[] args) {
        GNode a = new GNode('a');
        GNode b = new GNode('b');
        GNode c = new GNode('c');
        GNode d = new GNode('d');
        GNode e = new GNode('e');
        GNode f = new GNode('f');

        a.adj.add(b);
        a.adj.add(d);
        d.adj.add(b);
        b.adj.add(e);
        e.adj.add(d);
        c.adj.add(e);
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


        //Time complexity: O(V+E) // all vertices are visited only ones

        for(GNode v: vertices){
            dfsVisit(v);
        }


    }

    //visits the vertices and sets the parent
    private static void dfsVisit(GNode v){

        //to eliminate duplicate traversal due to outer loop
        if(hasSeen.contains(v)){
            return;
        }else{
            hasSeen.add(v);
        }

        System.out.println("Seen: "+v.value);

        for(GNode ad: v.adj){
            if(! hasSeen.contains(ad)){
                    ad.parent = v;
                    hasSeen.add(v);
                    System.out.println(ad.value+"'s parent is: "+v.value);
                    dfsVisit(ad);
            }
        }

    }

}
