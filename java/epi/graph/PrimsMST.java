package epi.graph;

import epi.util.WeightedUnDirectionGraph;

import java.nio.charset.CharacterCodingException;
import java.util.*;

public class PrimsMST {

    public static void main(String[] args){


                    /*
Weighted Graph:
      2
    a ----d
    | \ 3 |
  5 |   \ | 1
    b --  c
       1

       */

        WeightedUnDirectionGraph wg = new WeightedUnDirectionGraph();
        wg.addEdge('a', 'b', 5);
        wg.addEdge('b', 'c', 1);
        wg.addEdge('c', 'd', 1);
        wg.addEdge('d', 'a', 2);
        wg.addEdge('a', 'c', 3);



        primsMst(wg);

    }
/*
1) Create a Min Heap of size V where V is the number of vertices in the given graph. Every node of min heap contains vertex number and key value of the vertex.
2) Initialize Min Heap with first vertex as root (the key value assigned to first vertex is 0). The key value assigned to all other vertices is INF (infinite).
3) While Min Heap is not empty, do following
…..a) Extract the min value node from Min Heap. Let the extracted vertex be u.
…..b) For every adjacent vertex v of u, check if v is in Min Heap (not yet included in MST). If v is in Min Heap and its key value is more than weight of u-v, then update the key value of v as weight of u-v.
 */

    static class Node {
        char vertex;
        int key;
        Node(char vertex, int key){
            this.vertex = vertex;
            this.key = key;
        }
    }

    static class NodeComp implements Comparator<Node> {

        @Override
        public int compare(Node node0, Node node1)
        {
            return node0.key - node1.key;
        }
    }

    static void primsMst(WeightedUnDirectionGraph gr){
        //WeightedUnDirectionGraph.GNode start = gr.nodesMap.get('a'); // getting the first Edge
        Set<Character> mstSet = new HashSet<>();
        int vertexCnt = gr.vertices.size();
        PriorityQueue<Node> queue = new PriorityQueue<>(vertexCnt, new NodeComp());// initialize min heap
        List<Character> path = new ArrayList<Character>();


        Map<Character, Node> nodeMap = new HashMap<Character, Node>();

        for(Character c: gr.vertices){
            nodeMap.put(c, new Node(c, Integer.MAX_VALUE));
        }

        nodeMap.get('a').key= 0;// so that it is picked by the MinHeap, setting a starting point


        for(Character vertex: nodeMap.keySet()){
            queue.add(nodeMap.get(vertex));//added all the nodes to min heap
        }

        while(! queue.isEmpty()){
            Node cur = queue.poll();
            path.add(cur.vertex);
            mstSet.add(cur.vertex);

            //explore adjacent
            WeightedUnDirectionGraph.GNode curGNode=  gr.nodesMap.get(cur.vertex);
            for(WeightedUnDirectionGraph.WGNode adj: curGNode.adj){
                Character c = adj.g.value;
                Node curNode = nodeMap.get(c);
                if(curNode.key > adj.weight){//update the Heap
                    queue.remove(curNode);
                    curNode.key = adj.weight;
                    queue.add(curNode);

                }

            }

        }

for(Character c: path){
            System.out.println(c);
}


    }

}
