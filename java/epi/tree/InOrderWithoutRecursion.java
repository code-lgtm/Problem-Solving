package epi.tree;

import java.util.Stack;

public class InOrderWithoutRecursion {

    static class BNode {
        BNode left, right;
        int value;
        boolean isPrinted = false;

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
   2     12   4     5
            / \     \
           14  22     6

         */

        BNode one1 = new BNode(1);//root
        BNode three1 = new BNode(3);
        BNode mOne = new BNode(-1);
        one1.left = three1;
        one1.right = mOne;
        BNode two1 = new BNode(2);
        BNode one2 = new BNode(12);
        three1.left = two1;
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
        five.right = six;

        printInOrder_NonRecursive(one1);
        System.out.println();
        printInOrder_Recursive(one1);//for validation

        /*
        Output:
        2 3 12 1 14 4 22 -1 5 6
        2 3 12 1 14 4 22 -1 5 6
         */
    }

    static void printInOrder_NonRecursive (BNode root){
        Stack<BNode> stk = new Stack<BNode>();
        stk.push(root);
        while (!stk.isEmpty()){
            BNode peek = stk.peek();
            if(peek.left!= null && !peek.left.isPrinted){
                stk.push(peek.left);
            }else{
                BNode top = stk.pop();
                System.out.print(top.value+" ");
                top.isPrinted = true;
                if(top.right != null && ! top.right.isPrinted){
                    stk.push(top.right);
                }
            }
        }
    }

    static void printInOrder_Recursive(BNode cur){

        if(cur == null){
            return;
        }
        printInOrder_Recursive(cur.left);
        System.out.print(cur.value+" ");
        printInOrder_Recursive(cur.right);
    }


}
