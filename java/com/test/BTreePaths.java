package com.test;

import java.util.ArrayList;
import java.util.List;

public class BTreePaths {
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
Op:

1 2 3
1 2 4
1 5 6
1 5 7 8

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

        List<BNode> callList = new ArrayList<BNode>();
        int callDepth = 0;

        printPaths(n1, callList, callDepth); // n1 is the root

    }

    private static void printPaths(BNode cur, List<BNode> callList, int callDepth){
        if(cur == null){
            return;
        }
        callList.add(callDepth, cur);
        callDepth++;

        if(cur.left ==  null && cur.right == null){//print the path
            for(int i = 0; i< callDepth; i++){
                System.out.print(callList.get(i).value+" ");
            }
            System.out.println("");
        }


        printPaths(cur.left, callList, callDepth);
        printPaths(cur.right , callList, callDepth);

    }

}
