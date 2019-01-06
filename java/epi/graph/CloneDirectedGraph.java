package epi.graph;



import java.util.*;

//Clone a connected directed cyclic graph

public class CloneDirectedGraph {
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
    b -> c -> e

         */

        GNode a = new GNode('a');
        GNode b = new GNode('b');
        GNode c = new GNode('c');
        GNode d = new GNode('d');
        GNode e = new GNode('e');

        a.adj.add(b);
        a.adj.add(c);
        b.adj.add(c);
        c.adj.add(d);
        d.adj.add(a);
        c.adj.add(e);

        printBFS(a);
        GNode clone = cloneGraph(a);
        printBFS(clone);

        /*
Output:
a @ 1627674070  b @ 1360875712  c @ 1625635731  d @ 1580066828  e @ 491044090
a @ 644117698  b @ 1872034366  c @ 1581781576  d @ 1725154839  e @ 1670675563
         */
    }
    static GNode cloneGraph(GNode src){

        Queue<GNode> bfs = new LinkedList<>();
        Map<GNode, GNode> gToClone = new HashMap<>();
        GNode clnSrc = new GNode (src.value);
        bfs.add(src);
        gToClone.put(src, clnSrc);

        while (! bfs.isEmpty()){
            GNode cur = bfs.remove();
            if(visited.contains(cur)){
                continue;
            }
            visited.add(cur);

            for(GNode adj: cur.adj){
                GNode clonedCur = gToClone.get(cur);

                GNode cloneAdj = null;
                if(gToClone.containsKey(adj)){
                    cloneAdj = gToClone.get(adj);
                }else{
                    cloneAdj = new GNode(adj.value);
                    gToClone.put(adj, cloneAdj);
                }


                clonedCur.adj.add(cloneAdj);//added a cloned adj to the cloned graph

                bfs.add(adj);
            }
        }

        return clnSrc;
    }

    static void printBFS(GNode node){

        Set<GNode> visited = new HashSet<GNode>();
        Queue<GNode> bfs = new LinkedList<>();
        bfs.add(node);
        visited.add(node);

        while (!bfs.isEmpty()){
            GNode cur = bfs.remove();
            System.out.print(cur.value +" @ "+cur.hashCode()+"  ");
            for(GNode adj: cur.adj){
                if(! visited.contains(adj)){
                    bfs.add(adj);
                    visited.add(adj);
                }
            }

        }
        System.out.println();
    }
}
