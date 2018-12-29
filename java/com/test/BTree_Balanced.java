package com.test;

public class BTree_Balanced {
    static class BNode {
        BNode left, right;
        int value;

        BNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        /*
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5
        /   / \     \
       1   1   2     6
          /
         7
        /
       8
         */



        BNode one1 = new BNode(1);
        BNode three1 = new BNode(3);
        BNode mOne = new BNode(-1);
        one1.left = three1;
        one1.right = mOne;
        BNode two1 = new BNode(2);
        BNode one2 = new BNode(1);
        three1.left = two1;
        three1.right = one2;
        BNode one3 = new BNode(1);
        one2.left = one3;

        BNode four = new BNode(4);
        BNode five = new BNode(5);
        mOne.left = four;
        mOne.right = five;

        BNode one4 = new BNode(1);
        BNode two2 = new BNode(2);
        four.left = one4;
        four.right = two2;

        BNode seven = new BNode(7);
        BNode eight = new BNode(8);
        one4.left = seven;
        seven.left = eight;


        BNode six = new BNode(6);
        five.right = six;


        int x = checkBalanced(one1);
        System.out.println(x > -1?"Balanced":"UnBalanced");

    }

    static int checkBalanced(BNode node){

        if(node == null){
            return 0;
        }

        int leftHeight = checkBalanced(node.left);
        int rightHeight = checkBalanced(node.right);

        if (Math.abs(leftHeight-rightHeight) > 1){
            return  -1;//-1 represents that the tree isnt balanced
        }
        return Integer.max(leftHeight, rightHeight) + 1;

    }

}
