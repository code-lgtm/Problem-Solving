package com.test;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
public class PreOrderToBTree {
    static class BNode{
        BNode left, right;
        int value;
        BNode(int value){
            this.value= value;
        }
    }

    public static void main(String[] args){
        int[] preOrder = {10,5,1,7,40,50};
        BNode root = createTree(preOrder, 0, preOrder.length-1);
        System.out.println("Created using method1, printing levelOrder");
        printLevelOrder(root);

        root = createTree_2(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        System.out.println("Created using method2, printing levelOrder");
        printLevelOrder(root);

        //method 3 using stack
    }

    //O(n^2)
    static BNode createTree(int[] preOrder, int low, int high){

        if(low > high){
            return null;//base case
        }

        BNode root = new BNode(preOrder[low]);

        if(low == high){
            return root;
        }

        int r = low;
        for(;r< preOrder.length-1; r++){
            if(preOrder[r] > preOrder[low]){
                break;
            }
        }

        root.left = createTree(preOrder, low+1, r-1);
        root.right = createTree(preOrder, r, high);

        return root;
    }


    //O(n) // Has some bug - WIP
   static BNode createTree_2(int[] preOrder, int min, int max, int pos){

        if(pos == preOrder.length){
            return null;
        }


        BNode root = null;

        if(preOrder[pos] > min && preOrder[pos] < max){
            root = new BNode(preOrder[pos]);
            root.left = createTree_2(preOrder, min, preOrder[pos], pos+1);
            root.right = createTree_2(preOrder, preOrder[pos], max, pos+1);
        }

        return root;
    }



    static void printLevelOrder(BNode root) {
        Queue<BNode> queue = new LinkedList<BNode>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty())
        {

            BNode tempNode = queue.poll();
            if(tempNode == null){
                System.out.println();
                if(queue.size() > 0){
                    queue.add(null);
                }
            }else{
                System.out.print(tempNode.value + " ");

                /*Enqueue left child */
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                /*Enqueue right child */
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }

        }
    }
}
