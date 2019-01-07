package epi.graph;

import java.util.*;

public class StringTransformation {
    //Given word S & T and a Dictionary D, find if S can be transformed into T, if we can change just one char at a time and all the word in the transformation sequence should belong to D
    //for example If D = {cat, cot , bot, dag, dot } then S=cat can be transformed into T=dog in the sequence {cat, cot, dot, dog} ; basically we need to do bfs from cat to dog

    private static class GNode{
        String value;
        List<GNode> adj = new LinkedList<>();
        public GNode(String value){
            this.value = value;
        }
    }

    static class GNode_Level{
        int dist;
        GNode node;
        GNode_Level(GNode node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args){

        /*


        cat  bot--dot--dog
           \ |   /
            cot/


         */

        GNode cat = new GNode("cat");
        GNode cot = new GNode("cot");
        GNode bot = new GNode("bot");
        GNode dot = new GNode("dot");
        GNode dog = new GNode("dog");

        cat.adj.add(cot);
        cot.adj.add(cat);

        cot.adj.add(bot);
        bot.adj.add(cot);

        cot.adj.add(dot);
        dot.adj.add(cot);

        bot.adj.add(dot);
        dot.adj.add(bot);

        dot.adj.add(dog);
        dog.adj.add(dot);



        //assuming that the graph is strongly connected and reference of first word is given (else first word's reference can be found using bfs/dfs)

        int transformationSteps = findSteps(cat, "dog");
        System.out.println("Found destination after transformations: "+ transformationSteps);
        transformationSteps = findSteps(cat, "xyz");
        System.out.println("Found destination after transformations: "+ transformationSteps);

        /*
        Output:

        Found destination after transformations: 3
        Found destination after transformations: -1


         */

    }

    //Does bfs to find the minimum required transformations between two states
    //Time complexity O(V+E)
    //Space complexity O(V)
    static int findSteps(GNode start, String dest){

        Queue<GNode_Level> bfs = new LinkedList<>();
        Set<GNode> visited = new HashSet<>();
        bfs.add(new GNode_Level(start, 0));

        while (! bfs.isEmpty()){
            GNode_Level cur = bfs.remove();
            if(visited.contains(cur.node)){
                continue;
            }else{
                visited.add(cur.node);
            }

            if(cur.node.value.equals(dest)){
                return cur.dist;//found the transformation start after n transformation
            }

            for (GNode adj: cur.node.adj){
                if(!visited.contains(adj)){
                    bfs.add(new GNode_Level(adj, cur.dist +1));
                }
            }



        }

        return -1;
    }

}
