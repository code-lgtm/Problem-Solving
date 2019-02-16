package epi.bst;

//Find the smallest number > k in BST . Time O(log n), space O(1)
public class NumberGreaterThanK {
    static class BNode{
        BNode left, right, parent;
        int value;
        BNode(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {

        /*
                             20
                            /  \
                           8    22
                          / \
                         4   12
                            /  \
                           10  14

         */

        BNode root = insert(null, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);

        System.out.println(numGrThan(root, 8));
        System.out.println(numGrThan(root, 10));
        System.out.println(numGrThan(root, 14));
        System.out.println(numGrThan(root, 22));

        /*
        Output:
        10
        12
        20
        -1
         */

    }


    static int numGrThan(BNode cur, int k){
        BNode smallestBig = null;

        while (cur!= null){
            if(cur.value > k){
                smallestBig = cur; //it is a potential number as it's the smallest value which is > k till now
                cur = cur.left;
            }else {//cur.value <= k go right
                cur = cur.right;
            }
        }

        return smallestBig == null?-1: smallestBig.value;
    }







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
