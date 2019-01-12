package epi.hash;

import java.util.HashSet;
import java.util.Set;

//LCA of a tree with parent pointers on O(D1 + D2) times and space. Where D1 and D2 are distance of the nodes from the LCA
public class LCA {
    static class BNode{
        BNode left, right, parent;
        int value;
        BNode(int value){
            this.value = value;
        }
    }

    public static void main(String[] args){

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


        BNode eight = root.left;
        BNode ten = eight.right.left;
        BNode fourteen = ten.parent.right;
        BNode twentyTwo = root.right;

        System.out.println(getLCA(eight, ten));
        System.out.println(getLCA(ten, fourteen));
        System.out.println(getLCA(eight, twentyTwo));

        /*
        Output:
                8
                12
                20
         */

    }

    static int getLCA(BNode cur1, BNode cur2){
        Set<BNode> seen = new HashSet<BNode>();

        while (!(cur1 == null && cur2 == null)){
                if(cur1!= null){
                    if (seen.contains(cur1)){
                        return cur1.value;
                    }else {
                        seen.add(cur1);
                        cur1 = cur1.parent;
                    }
                }

            if(cur2!= null){
                if (seen.contains(cur2)){
                    return cur2.value;
                }else {
                    seen.add(cur2);
                    cur2 = cur2.parent;
                }
            }
        }

        return -1;
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
