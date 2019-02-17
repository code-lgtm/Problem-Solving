package epi.bst;

import java.util.LinkedList;
import java.util.Queue;

//Reconstruct a BST from postorder traversal. Time O(n), space O(h)
public class ReconstructBSTPostorder {

    static class BNode {
        BNode left, right;
        int value;

        BNode(int value, BNode left, BNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static int curIndex ;
    public static void main(String[] args){
        int[] postOrder = {41,29,41,37,23,53,47,43};
        curIndex = postOrder.length-1;//the right most node would be the tree
        BNode root = createBST(postOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        printLevelOrder(root);
        //Output: 43 23 47 37 53 29 41
    }

    static BNode createBST(int[] postOrder, int min, int max){
        if (curIndex < 0){
            return null;
        }


        if(postOrder[curIndex] < min || postOrder[curIndex] > max){//not eligible to be the current root
            return null;
        }
        int curElement = postOrder[curIndex];
        curIndex--;

        //at this point cur element is good to be created as current root, creating left and right children recursively
        //CRITICAL: for post order right call has to be before left call, because the right call was completed before the data was printed in the post order
        BNode right = createBST(postOrder, curElement, max);
        BNode left = createBST(postOrder, min, curElement);


        return new BNode(curElement, left, right);
    }


    /*** for printing the BST ***/

    static void printLevelOrder(BNode root)  {
        Queue<BNode> queue = new LinkedList<BNode>();
        queue.add(root);
        while (!queue.isEmpty())  {
            BNode tempNode = queue.poll();
            System.out.print(tempNode.value + " ");
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }
}
