package com.test;
import java.util.Queue;
import java.util.LinkedList;

//https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/

public class BSTSuccesor_WithParentPtr {

    static class BNode{
        BNode left, right, parent;
        int value;
        BNode(int value){
            this.value = value;
        }
    }

    public static void main(String[] args){

        /*
                             20
                            /  \
                           8    22
                          / \
                         4   12
                            /  \
                           10  14

         */

        BNode root = insert(null, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);

        printLevelOrder(root);// for validating the tree

        BNode eight = root.left;
        BNode ten = eight.right.left;
        BNode fourteen = ten.parent.right;

        System.out.println(getSucessor(eight));
        System.out.println(getSucessor(ten));
        System.out.println(getSucessor(fourteen));

    }

    static int getSucessor(BNode cur){

        //If the right subchild of cur is not null then we want to find the min value in the right subchild
        //else we want the first node which has a lift child using parent pointer

        if(cur == null){
            return -1;
        }

        if(cur.right != null){//get the min from right subtree
            return getMin(cur.right);
        }else{
            return getSucInUpperTree(cur);
        }
    }

static int getSucInUpperTree(BNode cur){
        BNode parent = cur.parent;

        if(parent.left == cur){
            return parent.value;
        }else{
            return getSucInUpperTree(parent);
        }
}

    static int getMin(BNode sub){
        if(sub.left == null ){
            return sub.value;
        }

        return getMin(sub.left);

    }

    static BNode insert(BNode root, int value){

        if(root == null){
            return new BNode(value);
        }


        if(value < root.value){//go left
            BNode templ = insert(root.left, value);
            root.left = templ;
            templ.parent = root;
        }else{//go right
            BNode tempr = insert(root.right, value);
            root.right = tempr;
            tempr.parent = root;
        }

        return root;

    }

    static void printLevelOrder(BNode root)
    {
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
