package epi.tree;

import java.util.Stack;

public class BTreeExterior {

//https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

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
        \     /   \
         12   4     5
        /   / \     /
       2   14  22  6

         */

        BNode one1 = new BNode(1);//root
        BNode three1 = new BNode(3);
        BNode mOne = new BNode(-1);
        one1.left = three1;
        one1.right = mOne;
        BNode two1 = new BNode(2);
        BNode one2 = new BNode(12);
        one2.left = two1;
        three1.right = one2;

        BNode four = new BNode(4);
        BNode five = new BNode(5);
        mOne.left = four;
        mOne.right = five;

        BNode one4 = new BNode(14);
        BNode two2 = new BNode(22);
        four.left = one4;
        four.right = two2;

        BNode six = new BNode(6);
        five.left = six;

        printExterior(one1);

        /*
        Output:
        1 3 12 2 14 22 6 5 -1
         */

    }
    static void printLeft(BNode cur) {
        while (cur!=null && !(cur.left == null && cur.right == null) ){
            System.out.print(cur.value+" ");
            if(cur.left == null && cur.right!= null){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
    }

    static void printLeaves(BNode cur) {//preorder

        if(cur == null){
            return;
        }
        if(cur.left== null && cur.right == null){
            System.out.print(cur.value+" ");
        }
        printLeaves(cur.left);
        printLeaves(cur.right);


    }


    static void printRight(BNode cur) {
        Stack<BNode> stack = new Stack<BNode>();
        while (cur!=null && !(cur.left == null && cur.right == null)){
            stack.push(cur);
            if(cur.right == null && cur.left!= null){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }

        while (stack.size() > 1){//leave the last element which is root as it is already printed while printing left
            System.out.print(stack.pop().value+" ");
        }


    }

    static void printExterior(BNode root){
        printLeft( root);
        printLeaves( root);
        printRight( root);
    }

}
