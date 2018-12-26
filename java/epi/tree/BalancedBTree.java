package epi.tree;

public class BalancedBTree {
    static class BNode {
        BNode left, right;
        int value;

        BNode(int value) {
            this.value = value;
        }
    }

    static class Ret{
        int height = 0;
        boolean isBalanced = true;
        Ret(){}
        Ret(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static void main(String[] args){
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

        System.out.println("isBalanced "+isBalanced(one1).isBalanced);

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
        BNode six = new BNode(6);
        five.right = six;

        System.out.println("isBalanced "+isBalanced(one1).isBalanced);

        BNode seven = new BNode(7);
        one4.left = seven;
        BNode eight = new BNode(8);
        seven.left = eight;


        System.out.println("isBalanced "+isBalanced(one1).isBalanced);

        /*
        Output:
                isBalanced true
                isBalanced true
                isBalanced false
         */
    }

    static Ret isBalanced(BNode cur){
        if(cur == null){
            return new Ret();
        }

        Ret left = isBalanced(cur.left);
        Ret right = isBalanced(cur.right);

        if(!left.isBalanced || !right.isBalanced){//tree is unbalanced
            return left.isBalanced?right:left;//return the unbalanced tree
        }

        int heightDiff = Math.abs(left.height - right.height);
        if(heightDiff > 1){
            return new Ret(-1, false);
        }else{//balanced
            int height = Integer.max(left.height, right.height) +1 ;
            return new Ret(height, true);
        }
    }

}
