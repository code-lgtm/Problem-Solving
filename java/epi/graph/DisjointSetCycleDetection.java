package epi.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DisjointSetCycleDetection {
    //cycle detection using Disjoint sets in an undirected graph

    private static class GNode{
        char value;
        List<GNode> adj = new LinkedList<>();
        public GNode(char value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
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

        GNode[][] edges = {{a,b}, {b,c}, {a,c}, {c,d}};

        boolean hasCycle = hasCycle(vertices, edges);
        System.out.println("Found Cycle: "+hasCycle);
        GNode[][] edges2 = {{a,b}, {b,c}, {c,d}};//removed edge a -- c
        hasCycle = hasCycle(vertices, edges2);
        System.out.println("Found Cycle: "+hasCycle);

        /*

        Output
        Found Cycle: true
        Found Cycle: false
         */
    }

    static boolean hasCycle(GNode[] vertices, GNode[][] edges){

        UnionByRankDisjointSet ds = new UnionByRankDisjointSet();
        for (GNode vertex: vertices){
            ds.makeSet(vertex.value);
        }

        for(GNode[] edge: edges){
            UnionByRankDisjointSet.TNode parent1 = ds.find(edge[0].value);
            UnionByRankDisjointSet.TNode parent2 = ds.find(edge[1].value);
            if(parent1.data == parent2.data){//both belong to same set, hence this edge has introduced a cycle in the graph
                return true;
            }else{
                ds.union(edge[0].value, edge[1].value);//put them in the sam set
            }
        }

        return false;
    }


    static class UnionByRankDisjointSet {
        //Union By Rank and Path Compression https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
        static class TNode {
            int data;
            int rank;
            TNode parent;

            TNode(int data, int rank) {
                this.data = data;
                this.rank = rank;
            }

        }

        static Map<Integer, TNode> sets = new HashMap<>();

        static void makeSet(int data) {
            TNode n = new TNode(data, 0);
            n.parent = n;
            sets.put(data, n);
        }

        static TNode find(int data) {
            return find(sets.get(data));
        }

        static TNode find(TNode cur) {
            if (cur.parent == cur) {
                return cur;
            }
            //else traverse towards parent and apply path compression so that the height if the tree is minimal
            TNode topParent = find(cur.parent);
            cur.parent = topParent;//all the children will start pointing to the top most node. It's path compression

            return topParent;
        }

        static boolean union(int n1, int n2) {
            TNode par1 = find(n1);
            TNode par2 = find(n2);

            if (par1.data == par2.data) {
                return false;
            }

            // merge the two trees, higher rank tree will be the parent
            if (par1.rank == par2.rank) {//anyone can be the new parent
                par1.rank++;
                par2.parent = par1;
            } else if (par1.rank > par2.rank) {
                par2.parent = par1;
            } else {
                par1.parent = par2;
            }
            return true;
        }
    }
}
