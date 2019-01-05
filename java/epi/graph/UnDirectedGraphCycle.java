package epi.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UnDirectedGraphCycle {
    private static class GNode{
        char value;
        List<GNode> adj = new LinkedList<>();
        public GNode(char value){
            this.value = value;
        }
    }

    static Set<GNode> visited = new HashSet<GNode>();

    public static void main(String[] args){
            /*
Graph:
    a     d
    | \   |
    |   \ |
    b -- c
    */

        GNode a = new GNode('a');
        GNode b = new GNode('b');
        GNode c = new GNode('c');
        GNode d = new GNode('d');

        a.adj.add(b);
        b.adj.add(a);
        a.adj.add(c);
        c.adj.add(a);
        c.adj.add(b);
        b.adj.add(c);
        c.adj.add(d);
        d.adj.add(c);

        //initializing vertices to iterate over the list of vertices as outer loop
        GNode[] vertices = new GNode[4];
        vertices[0] = d;
        vertices[1] = c;
        vertices[2] = b;
        vertices[3] = a;

        //TIME AND SPACE COMPLEXITY IS O(V+E)
        for(GNode v: vertices){//as the graph may not be strongly connected - VERTICES IS LOGICAL WHITE SET
            if(!visited.contains(v)) {
                System.out.println("Cycle detected from: " + v.value + " : " + hasCycleDFS(v, null,  new HashSet<GNode>()));
            }
        }

                    /*
Graph:
    a     d
    |     |
    |     |
    b -- c
    */

         a = new GNode('a');
         b = new GNode('b');
         c = new GNode('c');
         d = new GNode('d');

        a.adj.add(b);
        b.adj.add(a);
        c.adj.add(b);
        b.adj.add(c);
        c.adj.add(d);
        d.adj.add(c);

        //initializing vertices to iterate over the list of vertices as outer loop
        vertices = new GNode[4];
        vertices[0] = d;
        vertices[1] = c;
        vertices[2] = b;
        vertices[3] = a;
        //TIME AND SPACE COMPLEXITY IS O(V+E)
        for(GNode v: vertices){//as the graph may not be strongly connected - VERTICES IS LOGICAL WHITE SET
            if(!visited.contains(v)) {
                System.out.println("Cycle detected from: " + v.value + " : " + hasCycleDFS(v, null,  new HashSet<GNode>()));
            }
        }
    }

    static boolean hasCycleDFS(GNode g, GNode prev,  Set<GNode> callStack){

        if(g.adj == null){
            return false;
        }
        visited.add(g);

        if(callStack.contains(g)){// found a node which is already in the call stack, there must be a cycle
            return true;
        }
        callStack.add(g);
        for(GNode adj: g.adj){
            if( prev != adj && hasCycleDFS(adj, g, callStack)){//prev is used for avoiding back edges
                return true;
            }
        }

        callStack.remove(g);
        return false;
    }
}
