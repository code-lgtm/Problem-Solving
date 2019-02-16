package epi.bst;

import java.util.ArrayList;
import java.util.List;

//Find the k largest numbers is BST in O(h + k) time
public class KLargestNumbers {
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

        List<Integer> kLargest = new ArrayList<>();
        getKLargest(root, 3, kLargest);

        for(Integer i: kLargest){
            System.out.print(i+" ");
        }

        //Output: 22 20 14

    }

    //In-Order traversal gives numbers in increasing order. Lets do reverse In-order and stop at K
    static void getKLargest(BNode cur, int k, List<Integer> kLargest ){

        if(cur == null){
            return;
        }

        getKLargest(cur.right, k, kLargest);
        if(kLargest.size() < k){
            kLargest.add(cur.value);
        }else {
            return;
        }
        getKLargest(cur.left, k, kLargest);



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
