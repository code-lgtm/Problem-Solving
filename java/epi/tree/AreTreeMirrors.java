package epi.tree;

public class AreTreeMirrors {
    static class BNode {
        BNode left, right;
        int value;

        BNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
                /*
           1
        /     \
      3         3
    /   \     /   \
   5     1   1     5



         */


        BNode tree1 = getTree();
        BNode tree2 = getTree();


        boolean isSymmetrical = checkSymmetry(tree1, tree2);
        System.out.println("isSymmetrical: " +isSymmetrical);

        tree2.right.right = new BNode(6);

        isSymmetrical = checkSymmetry(tree1, tree2);
        System.out.println("isSymmetrical: " +isSymmetrical);

    }

    static boolean checkSymmetry(BNode sub1, BNode sub2){

        if(sub1 == null && sub2 == null){
            return true;
        }

        if(sub1!= null && sub2!=null &&
                sub1.value == sub2.value){
            return checkSymmetry(sub1.left, sub2.right) && checkSymmetry(sub1.right, sub2.left);
        }

        return false;
    }


    static BNode getTree(){
        BNode one1 = new BNode(1);
        BNode three1 = new BNode(3);
        BNode three2 = new BNode(3);
        one1.left = three1;
        one1.right = three2;

        BNode five1 = new BNode(5);
        BNode one2 = new BNode(1);
        three1.left = five1;
        three1.right = one2;

        BNode one3 = new BNode(1);
        BNode five2 = new BNode(5);
        three2.left = one3;
        three2.right = five2;
        return one1;
    }
}
