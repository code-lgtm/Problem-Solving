package epi.tree;

import java.util.HashSet;
import java.util.Set;

public class LCA_ParentPtr {
    static class BNode{
        BNode left, right, parent;
        int value;
        BNode(int value){
            this.value = value;
        }
    }

    static Set<BNode> seen = new HashSet<BNode>();

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
        BNode four = eight.left;
        BNode ten = eight.right.left;
        BNode fourteen = ten.parent.right;
        BNode twentytwo = root.right;

        System.out.println(getLCA(root, four, fourteen).value);
        seen = new HashSet<BNode>();
        System.out.println(getLCA(root, eight, ten).value);
        seen = new HashSet<BNode>();
        System.out.println(getLCA(root, twentytwo, ten).value);


        /*
        Output:
        8
        8
        20
         */

    }

    //O(n) time and space

    static BNode getLCA(BNode root, BNode cur1, BNode cur2){

        if(cur1 == null && cur2 == null){
            return root;
        }

        if(cur1!= null && seen.contains(cur1)){
            return cur1;
        }else if(cur2!=null && seen.contains(cur2)){
            return cur2;
        } else{
            if (cur1 !=null) {seen.add(cur1);};
            if (cur2 !=null) {seen.add(cur1);};
        }


        return getLCA(root, cur1 == null?null:cur1.parent, cur2==null?null:cur2.parent);

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
