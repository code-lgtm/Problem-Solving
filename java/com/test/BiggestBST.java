package com.test;

import java.text.BreakIterator;

public class BiggestBST {

    static class BNode{
        BNode left, right, parent;
        int value;
        BNode(int value){
            this.value = value;
        }
    }

    static class BRet{
        int size;
        BNode bigRef;
        boolean isBst;
        public BRet(int size, BNode bigRef, boolean isBst){
            this.size = size;
            this.bigRef = bigRef;
            this.isBst = isBst;
        }
    }

    static int maxHeight = Integer.MIN_VALUE;
    static BNode bigRef = null;

    public static void main(String[] args){

            /*
                                 19
                                /   \
                                     50
                             20      /  \
                            /  \    40   100
                           8    22
                          / \
                         4   12
                            /  \
                           10  14

         */

        BNode twenty = insert(null, 20);
        twenty = insert(twenty, 8);
        twenty = insert(twenty, 22);
        twenty = insert(twenty, 4);
        twenty = insert(twenty, 12);
        twenty = insert(twenty, 10);
        twenty = insert(twenty, 14);


        BNode fourty = new BNode(40);
        BNode hundred = new BNode(100);
        BNode fifty = new BNode(50);
        fifty.left = fourty;
        fifty.right = hundred;
        BNode nineteen = new BNode(19);
        nineteen.right = fifty;
        nineteen.left = twenty;

        //  System.out.println(getLargestBst(nineteen, Integer.MIN_VALUE, Integer.MAX_VALUE));
        // System.out.println(maxHeight+" "+bigRef.value);
        BRet big = getLargestBst(nineteen, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(big.bigRef.value);

    }

    static BRet getLargestBst(BNode cur, int min, int max) {

        if(cur == null){
            return new BRet(0, null, true);
        }

        BRet left = getLargestBst(cur.left, min, cur.value-1);
        BRet right = getLargestBst(cur.right, cur.value+1, max);

        BRet big = left.size > right.size? left:right;

        if(!(cur.value > min && cur.value< max)){
            return big;
        }else{
            big.size = big.size+1;
            big.bigRef = cur;
            return big;
        }

    }

    /*
        static int getLargestBst22(BNode cur, int min, int max){
            if(cur == null){
                return 0;
            }

            if(! (cur.value >= min && cur.value <= max)){
                return -1;
            }


            int leftHeight = getLargestBst(cur.left, min, cur.value-1);
            int rightHeight = getLargestBst(cur.right, cur.value+1, max);


            int newHeight = Math.max(leftHeight, rightHeight)+1;
            if(leftHeight ==-1 || rightHeight == -1){
                if(newHeight > maxHeight && leftHeight != -1){
                    maxHeight = newHeight;
                    bigRef = cur.left;
                }
                if(newHeight > maxHeight && rightHeight != -1){
                    maxHeight = newHeight;
                    bigRef = cur.right;
                }
                return -1;//-1 signifies that the tree is not bst
            }else {



                return newHeight;
            }

        }
    */
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
