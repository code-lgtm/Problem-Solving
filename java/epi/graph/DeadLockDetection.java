package epi.graph;

import java.util.*;

public class DeadLockDetection {
    //Resources can be represented as Graph, where resourses are vertices and and Edge from A -> B implies A depends on B to complete
    // In case if deadlock we would find a cycle while doing BFS

    //This approach is similar to the WHITE, GREY AND BLACK SET APPROACH DESCRIBED HERE: https://www.youtube.com/watch?v=rKQaZuoUR4M

    private static class GNode{
        char value;
        List<GNode> adj = new LinkedList<GNode>();
        public GNode(char value){
            this.value = value;
        }
    }

    static Set<GNode> visited = new HashSet<GNode>();
    public static void main(String[] args){
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

//TIME AND SPACE COMPLEXITY IS O(V+E)
        for(GNode v: vertices){//as the graph may not be strongly connected - VERTICES IS LOGICAL WHITE SET
            if(!visited.contains(v)) {
                System.out.println("Cycle detected from: " + v.value + " : " + hasDeadLockDFS(v, new HashSet<GNode>()));
            }
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

        for(GNode v: vertices){////as the graph may not be strongly connected - VERTICES IS LOGICAL WHITE SET
            if(!visited.contains(v)) {
                System.out.println("Cycle detected from: " + v.value + " : " + hasDeadLockDFS(v, new HashSet<GNode>()));
            }
        }

/*
Output:
Cycle detected from: a : true
Cycle detected from: e : false

 */

    }


    static boolean hasDeadLockDFS(GNode node, Set<GNode> callStack){

        if(node.adj  == null){// no cycle in this DFS path, return false
            return false;
        }

        for(GNode adj: node.adj){//go DFS
            if (callStack.contains(adj)){//if the element is in the current recursion stack
                return true;
            }

            //LOGICAL GREY SET
            callStack.add(adj);// add in the current recursion stack, using a SET INSTEAD to improve the time complexity - LOGICAL GREY SET
            boolean hasDeadLock = hasDeadLockDFS(adj, callStack);
            callStack.remove(adj);//level from adj has returned, remove from the stack
            visited.add(adj);//visited - LOGICAL BLACK SET
            if(hasDeadLock){
                return true;
            }
        }
        return false;// NO LOOPS
    }

}
