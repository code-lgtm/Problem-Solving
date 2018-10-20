package com.test;
import java.util.Stack;

public class BTreeZigZag {
    public static class BNode{
        public BNode left;
        public BNode right;
        public int value;

        public BNode(int value){
            this.value = value;
        }

    }


    public static void main(String[] args) {

/*
                1
               / \
              2   5
             / \ / \
            3  4 6  7
                     \
                      8



 */

        BNode n1 = new BNode(1);
        BNode n2 = new BNode(2);
        BNode n3 = new BNode(3);
        BNode n4 = new BNode(4);
        BNode n5 = new BNode(5);
        BNode n6 = new BNode(6);
        BNode n7 = new BNode(7);
        BNode n8 = new BNode(8);

        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.left = n6;
        n5.right = n7;
        n7.right = n8;

        printZigZag(n1);

    }

    //O(n) time and space
    private static void printZigZag(BNode root){

        boolean lr = false;// start right to left

        Stack<BNode> cur = new Stack<BNode>();
        Stack<BNode> aux = new Stack<BNode>();

        cur.add(root);

        while (! cur.isEmpty()){
            BNode node = cur.pop();
            System.out.print(node.value+" ");

            if(lr){
                if(node.right != null) {
                    aux.push(node.right);
                }
                if(node.left != null) {
                    aux.push(node.left);
                }

            }else{//rl
                if(node.left != null) {
                    aux.push(node.left);
                }
                if(node.right != null) {
                    aux.push(node.right);
                }
            }

            //cur is empty and there are more elements in the lower level, then process the lower level and change the dir
            if(cur.isEmpty() && !aux.isEmpty()){
                cur = aux;
                aux = new Stack<BNode>();
                lr = !lr;
            }


        }


    }

}
