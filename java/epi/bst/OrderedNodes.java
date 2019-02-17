package epi.bst;

//Given three nodes, ancestor, middle and descendant check if ancestor is middle's ancestor and descendant is middle descendant in O(log n) time and space
public class OrderedNodes {
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
                               / \
                              13  19

         */

        BNode root = insert(null, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);
        root = insert(root, 13);
        root = insert(root, 19);

        BNode eight = root.left;
        BNode four = eight.left;
        BNode fourteen = eight.right.right;
        BNode nineteen = fourteen.right;
        BNode thirteen = fourteen.left;

        System.out.println(isOrdered(root, eight, fourteen, thirteen));
        System.out.println(isOrdered(root, eight, fourteen, nineteen));
        System.out.println(isOrdered(root, eight, four, fourteen));

        /*
        Output:
        true
        true
        false
         */

    }

    static boolean isOrdered(BNode root, BNode ancestor, BNode middle, BNode descendant){
        //search ancestor first, then start from ancestor and find middle, then start from middle and find descendant . If all found then elements are ordered

        boolean foundAnc = bSearch(root, ancestor);
        if(!foundAnc){
            return false;
        }
        boolean foundMid = bSearch(ancestor, middle);
        if(!foundMid){
            return false;
        }

        return bSearch(middle, descendant);

    }

    static boolean bSearch(BNode cur, BNode elem){
        if (cur == null){
            return false;
        }

        if (cur.value == elem.value){//found the element
            return true;
        }

        if (cur.value > elem.value){//go left
            return bSearch(cur.left, elem);
        }else {
            return bSearch(cur.right, elem);
        }

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
