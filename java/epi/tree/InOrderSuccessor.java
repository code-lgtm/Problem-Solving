package epi.tree;

public class InOrderSuccessor {
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

        BNode eight = root.left;
        BNode four = eight.left;
        BNode ten = eight.right.left;
        BNode fourteen = ten.parent.right;
        BNode twentytwo = root.right;


        BNode suc = getSuccesor(eight);
        System.out.println(suc!=null?suc.value:"No successor");
        suc = getSuccesor(twentytwo);
        System.out.println(suc!=null?suc.value:"No successor");
        suc = getSuccesor(fourteen);
        System.out.println(suc!=null?suc.value:"No successor");
        suc = getSuccesor(four);
        System.out.println(suc!=null?suc.value:"No successor");

        printInOrder_Recursive(root);

        /*
        Output:
        10
        No successor
        20
        8
        4 8 10 12 14 20 22
         */

    }

    static BNode getSuccesor(BNode cur){
        if(cur.right!= null){//find the left most node of cur.right
            cur = cur.right;
            while (cur.left!=null){
                cur = cur.left;
            }
            return  cur;
        }else{
            BNode par = cur.parent;

            while(par!= null){
                if(par.left == cur){
                    return par;
                }else{
                    cur = par;
                    par = cur.parent;
                }
            }
            return null;//there is no successor
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

    static void printInOrder_Recursive(BNode cur){

        if(cur == null){
            return;
        }
        printInOrder_Recursive(cur.left);
        System.out.print(cur.value+" ");
        printInOrder_Recursive(cur.right);
    }
}
