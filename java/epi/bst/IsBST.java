package epi.bst;

//Check if a tree is a BST in O(n) time and O(log n) space
public class IsBST {

    static class BNode{
        BNode left, right;
        int value;
        BNode(int value){
            this.value= value;
        }
    }
    public static void main(String[] args) {
        int[] ar = {-1, 2, 3, 7, 8, 9, 50, 100};

        BNode root = getTree(ar, 0, ar.length - 1);
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        root.right.right.value = -1;
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        //Output: true
        //        false
    }


    static boolean isBST(BNode cur, int min, int max){
        if (cur == null){
            return true;
        }
        if(cur.value <= min || cur.value >= max){
            return false;
        }

        return isBST(cur.left, min, cur.value) && isBST(cur.right, cur.value, max);
    }

    /* //This logic doesnt work
    static boolean isBST(BNode cur){
        if(cur == null){
            return true;
        }
        if(cur.left!= null && cur.left.value > cur.value){
            return false;
        }
        if (cur.right!= null && cur.right.value < cur.value){
            return false;
        }
        boolean isLeftBST = isBST(cur.left);
        boolean isRightBST = isBST(cur.right);

        return isLeftBST && isRightBST;
    }
*/
    static BNode getTree(int[] ip, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end)/2;
        BNode node = new BNode(ip[mid]);
        node.left = getTree(ip, start, mid-1);
        node.right = getTree(ip, mid+1, end);

        return node;

    }
}
