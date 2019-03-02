package epi.bst;

//Perform insert and addition in BST
public class InsertionAndDeletion {
    private BNode root = null;

    static class BNode {
        BNode left, right;
        int value;

        BNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        InsertionAndDeletion btreeOps =  new InsertionAndDeletion();
        BNode root = btreeOps.insert(5).insert(7).insert(10).insert(3).insert(2).insert(15).insert(-10).getRoot();
        btreeOps.printInOrder(root);

        btreeOps.delete(-10);

        btreeOps.delete(3);

        btreeOps.delete(5);

        System.out.println();
        btreeOps.printInOrder(root);

        /*
        Output:
        -10 2 3 5 7 10 15
        2 7 10 15
         */

    }

    boolean delete(int value){
        BNode parent = root, cur = root;

        //Binary search the value to be deleted

        while (cur!= null){
            if (cur.value == value){
                break;
            }
            parent = cur;
            if (cur.value < value){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }

        if(cur == null || cur.value != value){
            return false;
        }

        /*
        There are three cases now
        Case 1: cur has no children, then simply update it's parent's ref
        case 2: cur has one child. then parent's child become's cur's child
        case 3: cur has two children, then we find cur's sucessor and overwrite cur's value with sucessor's , then delete the sucessor. Sucesor the last left node of cur's right node
         */

        if (cur.left == null && cur.right == null){
            if(parent.left!= null && parent.left == cur){//cur is the left child
                parent.left = null;
            }else {
                parent.right = null;
            }
        }else if (cur.left == null || cur.right == null){//one of the children is null

            BNode curChild = cur.left!= null? cur.left:cur.right;

            if(parent.left!= null && parent.left == cur){//cur is the left child
                parent.left = curChild;
            }else {
                parent.right = curChild;
            }

        }else {//both children are non null

            //find the sucessor
            BNode sucNode = cur.right;
            while (sucNode.left!= null){
                sucNode = sucNode.left;
            }
            int sucValue = sucNode.value;

            //delete sucesor
            delete(sucNode.value);

            //copy sucessor's data to cur
            cur.value = sucValue;

        }


        return true;
    }

    //insert self ref to use it like builder pattern
    InsertionAndDeletion insert(int value){

        if(root == null){
            root = new BNode( value);
        }else {
            //find a node with empty child to insert the current node
            BNode parent = root, cur = root;

            while (cur!= null){
                parent = cur;
                if(cur.value == value){
                    throw new RuntimeException("Duplicate value");
                }else if(cur.value > value){
                    cur = cur.left;
                }else {
                    cur = cur.right;
                }
            }

            //at this point atleast one of the children of 'parent' is null and we can add the value

            if(value < parent.value && parent.left == null){
                parent.left = new BNode(value);
            }else  if(value > parent.value && parent.right == null){
                parent.right = new BNode(value);
            }

        }

        return this;
    }

    BNode getRoot(){
        return root;
    }

    private  void printInOrder(BNode bst) {
        if(bst ==  null) return;
        printInOrder(bst.left);
        System.out.print(bst.value +" ");
        printInOrder(bst.right);

    }
}
