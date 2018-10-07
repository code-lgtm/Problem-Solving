package com.test;

import java.util.ArrayList;
import java.util.List;

public class KSumPath_BTree_2 {

    //Path can start from any node which can start at any node and can end at any node within the path, and should have sum = k
    //https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/

    static class BNode{
        BNode left, right;
        int value;

        BNode(int value){
            this.value = value;
        }
    }
    public static void main(String[] args){

        /*
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5
        /   / \     \
       1   1   2     6
         */
/*
Output
2 3
1 3 1
1 1 3
1 4
1 4 -1 1
2 4 -1
5
5 -1 1
 */

        BNode one1 = new BNode(1);
        BNode three1 = new BNode(3);
        BNode mOne = new BNode(-1);
        one1.left = three1;
        one1.right = mOne;
        BNode two1 = new BNode(2);
        BNode one2 = new BNode(1);
        three1.left = two1;
        three1.right = one2;
        BNode one3 = new BNode(1);
        one2.left = one3;

        BNode four = new BNode(4);
        BNode five = new BNode(5);
        mOne.left = four;
        mOne.right = five;

        BNode one4 = new BNode(1);
        BNode two2 = new BNode(2);
        four.left = one4;
        four.right = two2;

        BNode six = new BNode(6);
        five.right = six;

        List<Integer> path = new ArrayList<Integer>();

        printPathsWithSum(one1, 5, path);


    }

    private static void printPathsWithSum(BNode node, int k, List<Integer> path){

        path.add(node.value);

        //K sum can start at any point so keep checking for the sum at every recursive level
            int tempSum = 0;
            for (int i = path.size()-1; i>= 0; i--){
                tempSum += path.get(i);
                if(tempSum == k){
                    for (int j = path.size()-1; j >= i; j--){
                        System.out.print(path.get(j)+" ");
                    }
                }
                System.out.println();
            }


        if(node.left != null) {
            printPathsWithSum(node.left, k, path);
        }

        if(node.right!= null) {
            printPathsWithSum(node.right, k, path);
        }

        //remove the last element as the call is returning

        if(path.size()>0){
            path.remove(path.size() -1);
        }

    }
}
