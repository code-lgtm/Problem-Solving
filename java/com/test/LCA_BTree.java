package com.test;

public class LCA_BTree {

    //Find the Lowest common ancestor of two given nodes in a tree in O(n) time and O(1) space

    static class BNode{
        BNode left, right;
        int value;

        BNode(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {

        /*
           1
        /     \
      3        -1
    /   \     /   \
   2     12   4     5
        /   / \     \
       13  14  22     6


       Output:
        3
        1

         */

        BNode one1 = new BNode(1);
        BNode three1 = new BNode(3);
        BNode mOne = new BNode(-1);
        one1.left = three1;
        one1.right = mOne;
        BNode two1 = new BNode(2);
        BNode one2 = new BNode(12);
        three1.left = two1;
        three1.right = one2;
        BNode one3 = new BNode(13);
        one2.left = one3;

        BNode four = new BNode(4);
        BNode five = new BNode(5);
        mOne.left = four;
        mOne.right = five;

        BNode one4 = new BNode(14);
        BNode two2 = new BNode(22);
        four.left = one4;
        four.right = two2;

        BNode six = new BNode(6);
        five.right = six;

        BNode res1 = getLCA(one1,  one3, two1);
        System.out.println(res1 == null? "Not Found":res1.value);

        BNode res2 = getLCA(one1,  two2, two1);
        System.out.println(res2 == null? "Not Found":res2.value);

    }

    private static BNode getLCA(BNode cur, BNode node1, BNode node2){

        //boundary condition
        if ( cur.equals(node1) || cur.equals(node2)){
            return cur;// found one of the matching nodes and returning  it
        }else if (cur.left == null && cur.right == null){
            return null;
        }

        BNode left = null, right = null;
        if (cur.left != null){
            left = getLCA(cur.left,  node1, node2);
        }

        if (cur.right != null){
            right = getLCA(cur.right, node1, node2);
        }

        if(left != null && right != null){//if both left and right children are not null, then current is the parent and hence the LCA
            return cur;
        } else {// atmost just one if found yet, return it or return null if none is found yet
            return left == null ? (right == null ? null : right) : left;
        }
    }
}

