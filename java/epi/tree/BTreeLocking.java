package epi.tree;

public class BTreeLocking {

    // API to lock a node or check if the node is locked
    // a node cannot be locked of any of its descendants or ancestors are locked

    //the idea is to maintained a locked flag and count of the lockedDecendants to avoid traversal of tree below, reducing time complexity from (m + d) to O(d) ; m = number of decendants, d = depth

    static class BNode {
        BNode left, right, parent;
        int value;
        boolean isLocked = false;
        int lockedDecendants = 0;

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

        BNode eight = root.left;
        BNode four = eight.left;
        BNode ten = eight.right.left;
        BNode fourteen = ten.parent.right;
        BNode twentytwo = root.right;

        System.out.println(isLocked(eight));//false
        System.out.println(lock(eight));//true
        System.out.println(lock(root));//false// canot lock as 8 is locked
        System.out.println(unLock(eight));//true
        System.out.println(lock(root));//true

/*
Output:

false
true
false
true
true

 */

    }

    static boolean isLocked(BNode cur){//O(1)
        return cur.isLocked;
    }

    static boolean lock(BNode cur){//(O(depth)
        BNode temp = cur.parent;
        while(temp != null){//check if any parent is locked
            if(temp.isLocked){
                return false;
            }
            temp = temp.parent;
        }

        if(cur.lockedDecendants > 0){//cannot lock cur
            return false;
        }

        //reached this line, now we are good to lock cur, increment lockedDecendants of parents and set isLocked of cur
        cur.isLocked = true;
        temp = cur.parent;
        while(temp != null){//check if any parent is locked
            temp.lockedDecendants++;
            temp = temp.parent;
        }

        return true;
    }

    static boolean unLock(BNode cur){//(O(depth)
        if(!cur.isLocked){
            return false;
        }

        BNode temp = cur.parent;
        while(temp != null){//check if any parent is locked
            temp.lockedDecendants--;
            temp = temp.parent;
        }

        cur.isLocked = false;
        return true;
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
