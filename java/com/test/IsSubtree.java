package com.test;

public class IsSubtree {

    private static class BNode{
        BNode left, right;
        int val;
        BNode(int val){
            this.val = val;
        }


        @Override
        public int hashCode() {
            return new Integer(val).hashCode();
        }

        @Override
        public boolean equals(Object o) {
         return this.val == ((BNode)o).val;
        }

    }

    public static void main(String[] args){

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      2
           \
            30

             Tree 2

            10
         /    \
         4      6
          \
          30
          */

        BNode t1 = new BNode(26);
        BNode n10 = new BNode(10);
        BNode n3 = new BNode(3);
        t1.left = n10;
        t1.right = n3;
        n3.right = new BNode(2);
        BNode n4 = new BNode(4);
        n10.left = n4;
        n10.right = new BNode(6);
        n4.right = new BNode(30);


        BNode t2 = new BNode(10);
        t2.right = new BNode(6);
        BNode nn4 = new BNode(4);
        t2.left = nn4;
        nn4.right = new BNode(30);

        boolean isSubtree = checkSubTree(t1, t2);
     //   System.out.println(n10.equals(t2)); //checking overridden equals and hashcode
        System.out.println("isSubtree: "+isSubtree);

    }

    static boolean checkSubTree(BNode t1, BNode t2){

        //t1 is the bigger tree, so search is for t2's root

        BNode subTree = findSubTree(t1, t2);

        if(subTree == null){//T2's root is not found
            return false;
        }

        //T2's root is found , match the subTree and t2

        return matchTree(subTree, t2);
    }

    private static boolean matchTree(BNode t1, BNode t2){

        if((t1 != null && t2 != null) && t1.equals(t2) ){
             return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
        } else if (t1 == null && t2 == null){
            return true;
        }else{
            return false;
        }


    }
    private static BNode findSubTree(BNode t1, BNode t2){

        // do pre - order traversal to find t2;

            if(t1.equals(t2)){
                return t1;
            }

       BNode foundInLeft  = null, foundInright = null;
        if (t1.left != null) {
            foundInLeft =  findSubTree(t1.left, t2);

        }
        if(t1.right != null){
            foundInright  =  findSubTree(t1.right, t2);
        }

        return foundInLeft!= null?foundInLeft: (foundInright!=null ? foundInright: null);
    }
}
