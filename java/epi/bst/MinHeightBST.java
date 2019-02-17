package epi.bst;

//Build min height BST from sorted array - Time and space O(n)
public class MinHeightBST {
    static class BNode {
        BNode left, right;
        int value;

        BNode(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args){

        int[] sortedIP = {1,2,3,4,5,6,7,8,9};
        BNode root = getBST(sortedIP, 0, sortedIP.length);
        printInorder(root);
        //Output: 1 2 3 4 5 6 7 8 9
    }

    static BNode getBST(int[] sortedIP, int min, int max){
        if(min >= max){
            return null;
        }

        int mid = min + (max-min)/2;

        BNode cur = new BNode(sortedIP[mid]);
        cur.left = getBST(sortedIP, min, mid);
        cur.right = getBST(sortedIP, mid+1, max);
        return cur;
    }

    static void printInorder(BNode cur){
        if(cur == null){
            return;
        }
        printInorder(cur.left);
        System.out.print(cur.value+" ");
        printInorder(cur.right);
    }
}
