package epi.util;


import java.util.*;

public class WeightedUnDirectionGraph {

    public Set<Character> vertices = new HashSet<Character>();
    public Map<Character, GNode> nodesMap = new HashMap<Character, GNode>();


    public class GNode{
        public char value;
        public List<WGNode> adj = new LinkedList<WGNode>();
        public GNode(char value){
            this.value = value;
        }

    }

    public class WGNode{//Wrapper of Gnode and it's weight
        public GNode g;
        public int weight ;
        public WGNode(GNode g, int weight){
            this.g = g;
            this.weight = weight;
        }
    }


    public void addEdge(Character from, Character to, int weight){

        //create vertex is not already created
        if(!vertices.contains(from)){
            vertices.add(from);
        }
        if(!vertices.contains(to)){
            vertices.add(to);
        }

        //Get or create the two nodes
        GNode frmNode;
        if(nodesMap.containsKey(from)){
            frmNode = nodesMap.get(from);
        }else{
            frmNode = new GNode(from);
            nodesMap.put(from, frmNode);
        }

        GNode toNode;
        if(nodesMap.containsKey(to)){
            toNode = nodesMap.get(to);
        }else{
            toNode = new GNode(to);
            nodesMap.put(to, toNode);
        }

        //It's undirected graph so add both nodes to both node's adjacency lists
        frmNode.adj.add(new WGNode(toNode, weight));
        toNode.adj.add(new WGNode(frmNode, weight));

    }



}
