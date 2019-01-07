package epi.graph;

import java.util.*;

public class MinimumSpanningTree_Kruskal {

//Explaination: https://www.youtube.com/watch?v=fAuF0EuZVCk
    public static void main(String[] args) {
            /*
Weighted Graph:
      2
    a ----d
    | \ 3 |
  5 |   \ | 1
    b --  c
       1
    *///Initializing the graph
        Graph weightedGraph = new Graph();
        GNode a = new GNode('a');
        GNode b = new GNode('b');
        GNode c = new GNode('c');
        GNode d = new GNode('d');
        weightedGraph.vertex.add(a);
        weightedGraph.vertex.add(b);
        weightedGraph.vertex.add(c);
        weightedGraph.vertex.add(d);
        weightedGraph.edges.add(new Edge(a, d, 2));
        weightedGraph.edges.add(new Edge(a, c, 3));
        weightedGraph.edges.add(new Edge(b, c, 1));
        weightedGraph.edges.add(new Edge(c, d, 1));
        weightedGraph.edges.add(new Edge(a, b, 5));

        List<Edge> mst = getMST(weightedGraph);
        for(Edge edg: mst){
            System.out.print("("+edg.from.value+","+edg.to.value+") ");
        }

        /*
        Output:
        (b,c) (c,d) (a,d)
         */
    }

//Time complexity: O(E log(e)) + O(E) - Sorting E edges plus E operations on Disjoint set
// Space Complexity O(V + E)
    static List<Edge> getMST(Graph weightedGraph){

        List<Edge> mst = new ArrayList<>();

        //sort the edges in increasing order
        Collections.sort(weightedGraph.edges, new Comparator(){
            public int compare(Object o1, Object o2) {
                return ((Edge)o1).weight - ((Edge)o2).weight;
            }
        });

        //make the disjoin sets for all the vertices
        DisjointSet ds = new DisjointSet();
        for(GNode g:weightedGraph.vertex){
            ds.makeSet(g.value);
        }

        //iterate the sorted list of edges and add all the edges not causing cycle in the MST
        for(Edge edg: weightedGraph.edges){
            DisjointSet.TNode par1 = ds.find(edg.from.value);
            DisjointSet.TNode par2 = ds.find(edg.to.value);

            if(par1.data == par2.data){ //don't pick this edge else it will cause cycle in MST
                continue;
            }else{
                mst.add(edg);
                ds.union(edg.from.value, edg.to.value);
            }
        }

        return mst;

    }

    /******* Graph definition starts**********/
    static class Graph{
        List<GNode> vertex = new LinkedList<>();
        List<Edge> edges = new LinkedList<>();
    }
    static class Edge{
        GNode from, to;
        int weight;
        Edge(GNode from, GNode to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    static class GNode{
        char value;
        public GNode(char value){
            this.value = value;
        }
    }

    /******* Graph definition ends**********/

    /******* DisjointSet definition starts**********/
    static class DisjointSet {
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
    /******* DisjointSet definition ends**********/
}
