package epi.tree;

public class BTreeSibling {

    static class BNode {
        BNode left, right, parent;
        int value;

        BNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        //https://www.geeksforgeeks.org/find-right-sibling-binary-tree-parent-pointers/
        //Given a binary tree with parent pointers, find the right sibling of a given node(pointer to the node will be given), if it doesn’t exist return null. Do it in O(1) space and O(n) time?

        /*
                             20
                            /  \
                           8    22
                          / \
                         4   12
                        /   /  \
                       3   10  14

         */

        BNode root = insert(null, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 3);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);

        BNode three = root.left.left.left;
        BNode ten = root.left.right.left;
        BNode twelve = root.left.right;

        BNode sub = null;
        sub = getSibling(three);
        System.out.println(sub!= null?sub.value:"No Sibling");

        sub = getSibling(ten);
        System.out.println(sub!= null?sub.value:"No Sibling");

        sub = getSibling(twelve);
        System.out.println(sub!= null?sub.value:"No Sibling");

        /*

        Output:

        14
        14
        No Sibling

         */

    }

    //O(n) time and O(1) space
    static BNode getSibling(BNode cur){
        int height = 0;
        cur = cur.parent;
        height++;
        while(cur!= null){

            if(cur.right!= null){
                int tHeight = height-1;
                BNode tCur = cur.right;
                while (tCur!=null){
                    if(tHeight == 0 && tCur.left == null && tCur.right == null){
                        return tCur;
                    }else{
                        tCur = tCur.right;
                        tHeight--;
                    }
                }

            }

                cur = cur.parent;
                height++;



        }

        return null;

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
