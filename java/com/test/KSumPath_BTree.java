package com.test;

import java.util.ArrayList;
import java.util.List;

public class KSumPath_BTree {

    //Path can start from any node but must end at any leaf node, and should have sum = k

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
3 2
3 1 1
4 1
1 -1 4 1
-1 4 2
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

        if(node.left == null && node.right == null){//found a leaf node;
            int tempSum = 0;
            for (int i = path.size()-1; i>= 0; i--){
                tempSum += path.get(i);
                if(tempSum == k){
                    for (int j = i; j <= path.size()-1; j++){
                        System.out.print(path.get(j)+" ");
                    }
                }
                System.out.println();

            }

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
