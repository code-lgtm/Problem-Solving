package epi.recursion;

import java.util.ArrayList;
import java.util.List;

//Generate distinct trees using n nodes
public class GenerateBinaryTrees {

    static class BNode {
        BNode left, right;

        BNode( BNode left, BNode right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        List<BNode> bTrees = generateBTrees(3);
        System.out.println("Total structurally unique trees: "+bTrees.size());
        //Output: Total structurally unique trees: 5
    }

    static List<BNode> generateBTrees(int numNodes){

        List<BNode> result = new ArrayList<>();

        if (numNodes == 0){
            result.add(null);
        }

        for (int leftNum = 0; leftNum < numNodes; leftNum++){

            List<BNode> leftChildren = generateBTrees(leftNum);
            List<BNode> rightChildren = generateBTrees(numNodes - 1 - leftNum);

            for (BNode left: leftChildren){
                for (BNode right: rightChildren){
                    result.add(new BNode(left, right));
                }
            }

        }

        return result;
    }
}
