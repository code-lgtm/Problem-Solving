package com.test;

public class LCA_BST {
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


        BNode four = root.left.left;
        BNode ten = root.left.right.left;

        System.out.println(getLCA(root, four, ten).value);//prints 8

    }

    static BNode getLCA(BNode cur, BNode one, BNode two){

        if(cur == null){
            return null;
        }

        if(cur.value < one.value && cur.value < two.value){//go right
            return getLCA(cur.right, one, two);
        }else if(cur.value > one.value && cur.value > two.value){
            return getLCA(cur.left, one, two);
        }else{
            return cur;// LCA will be the point where the left and the right nodes split
        }


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
}
