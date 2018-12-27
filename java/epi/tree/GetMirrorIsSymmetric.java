package epi.tree;

//get the mirror of a tree and check of two trees are symmetric
public class GetMirrorIsSymmetric {

    static class BNode {
        BNode left, right;
        int value;

        BNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args){
                /*
           1
        /     \
      3         3
    /   \     /   \
   5     1   1     5



         */


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



        BNode mirror = getMirror(one1);
        System.out.println("Mirror created" +mirror);//the input is symmetrical, so mirror image will be same as the input

        boolean isSymmetrical = checkSymmetry(one1, one1);
        System.out.println("isSymmetrical: " +isSymmetrical);

        five2.right = new BNode(10);
        isSymmetrical = checkSymmetry(one1, one1);
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

    static BNode getMirror(BNode cur){
        if(cur == null){
            return null;
        }

        BNode left = getMirror(cur.left);
        BNode right = getMirror(cur.right);

        cur.left = right;
        cur.right = left;

        return cur;


    }


}
