package com.test;

public class ArrayToBst_IsValidBST {
    static class BNode{
        BNode left, right;
        int value;
        BNode(int value){
            this.value= value;
        }
    }
    public static void main(String[] args){
        int[] ar = {-1 , 2 , 3, 7, 8, 9, 50, 100};

        BNode root = getTree(ar, 0, ar.length-1);
        //max height of a tree with min height
        int maxHeight = getMaxHeight(root);

        System.out.println("Tree created with Height: "+maxHeight);

       // root.left.value = root.right.right.value; //-ve test case
        System.out.println("isValid: "+ isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }

    static boolean isValid(BNode cur, int min, int max){

        if(cur == null){
            return true;
        }

        if(cur.value > min && cur.value < max){
           return isValid(cur.left, min, cur.value) && isValid(cur.right, cur.value, max);
        }

        return false;


    }

    static int getMaxHeight(BNode node){

        if(node== null){
            return 0;
        }

        return Integer.max (getMaxHeight(node.left), getMaxHeight(node.right)) + 1;

    }

    static BNode getTree(int[] ip, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end)/2;
        BNode node = new BNode(ip[mid]);
        node.left = getTree(ip, start, mid-1);
        node.right = getTree(ip, mid+1, end);

        return node;

    }

}
