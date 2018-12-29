package epi.tree;

public class LCA_BTree {

    static class BNode{
        BNode left, right;
        int value;

        BNode(int value){
            this.value = value;
        }
    }

    static class Ret{
        BNode lca = null;
        boolean found = false;
        Ret(){}
        Ret(BNode lca, boolean found){
            this.lca = lca;
            this.found = found;
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

        Ret res1 = getLCA(one1,  one3, two1);
        System.out.println(!res1.found? "Not Found":res1.lca.value);

        Ret res2 = getLCA(one1,  two2, two1);
        System.out.println(!res2.found? "Not Found":res2.lca.value);

    }

    private static Ret getLCA(BNode cur, BNode one, BNode two){

        if (cur == null){
            return new Ret();
        }

        if(cur == one || cur == two){
            return new Ret(null, true);
        }

        Ret left = getLCA(cur.left, one, two);
        Ret right = getLCA(cur.right, one, two);

        if(left.found && right.found){
            return new Ret(cur, true);
        }else if(left.lca != null || right.lca != null){
            return left.lca != null? left:right;
        }else{
            return left.found?left:right;
        }

    }
}
