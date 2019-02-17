package epi.bst;

import java.util.LinkedList;
import java.util.Queue;

//Reconstruct a BST from preoder traversal. Time O(n), space O(h)
public class ReconstructBSTPreorder {
    static class BNode {
        BNode left, right;
        int value;

        BNode(int value, BNode left, BNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static int curIndex = 0;
    public static void main(String[] args){
        int[] preOrder = {43,23,37,29,31,41,47,53};
        BNode root = createBST(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        printLevelOrder(root);
        //Output: 43 23 47 37 53 29 41 31
    }

    static BNode createBST(int[] preOrder, int min, int max){
        if (curIndex >= preOrder.length){
            return null;
        }


        if(preOrder[curIndex] < min || preOrder[curIndex] > max){//not eligible to be the current root
            return null;
        }
        int curElement = preOrder[curIndex];
        curIndex++;

        //at this point cur element is good to be created as current root, creating left and right children recursively
        BNode left = createBST(preOrder, min, curElement);
        BNode right = createBST(preOrder, curElement, max);

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
