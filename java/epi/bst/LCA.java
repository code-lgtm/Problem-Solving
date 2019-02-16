package epi.bst;

//Get LCA of two numbers in BST. Time: O(h)
public class LCA {
    static class BNode {
        BNode left, right, parent;
        int value;

        BNode(int value) {
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

        System.out.print(getLCA(root, 4, 10).value);

        //Output: 8
    }

    static BNode getLCA(BNode cur, int n1, int n2){
        if(cur == null){
            return cur;
        }

        if(cur.value < n1 && cur.value <n2){
            return getLCA(cur.right, n1, n2);
        }

        if(cur.value > n1 && cur.value > n2){
            return getLCA(cur.left, n1, n2);
        }

        return cur;
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
