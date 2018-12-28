package epi.tree;


public class SumRootToLeaf {

    //Find a path from root to leaf with sum k

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
   2     12   4     5
            / \     \
           14  22     6




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
        //  BNode one3 = new BNode(13);
        // one2.left = one3;

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

        BNode[] path = new BNode[4];
        path[0] = one1;//root will always be in the path


        BNode[] kSumPath = getKSumPath(one1, 16, one1.value, path, 0+1);
        if(kSumPath == null){
            System.out.println("No Path found");
        }else {
            for(BNode node: kSumPath){
                if(node == null){
                    break;
                }
                System.out.print(node.value +" ");
            }
            System.out.println();
        }

        kSumPath = getKSumPath(one1, 26, one1.value, path, 0+1);
        if(kSumPath == null){
            System.out.println("No Path found");
        }else {
            for(BNode node: kSumPath){
                if(node == null){
                    break;
                }
                System.out.print(node.value +" ");
            }
            System.out.println();
        }

        kSumPath = getKSumPath(one1, 10, one1.value, path, 0+1);
        if(kSumPath == null){
            System.out.println("No Path found");
        }else {
            for(BNode node: kSumPath){
                if(node == null){
                    break;
                }
                System.out.print(node.value +" ");
            }
            System.out.println();
        }

        /*
        Output:

        1 3 12
        1 -1 4 22
        No Path found


         */

    }

    static BNode[] getKSumPath(BNode cur, int k, int sum, BNode[] path, int ind) {
        if (cur.left == null && cur.right == null && sum == k) {//cur is a leaf node and we found the path
            return path;
        }

        BNode[] left = null;
        if (cur.left != null) {
            path[ind] = cur.left;
            left =  getKSumPath(cur.left, k, (sum + cur.left.value), path, ind + 1);
            if(left!= null){//return iff a non null path has been found in the recursion tree
                return left;
            }
        }

        BNode[] right = null;
        if (cur.right != null) {
            path[ind] = cur.right;
            right = getKSumPath(cur.right, k, (sum + cur.right.value), path, ind + 1);
            if(right!= null){
                return right;
            }

        }

        return null;// not path found
    }

}