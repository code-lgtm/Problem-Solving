package com.test;

import java.util.ArrayList;

public class MinSumPath_Tree {

    /*
    Find the min sum path in a tree from root to leaf
    The tree need not be a Binary tree
     */

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }


 /*

                        0
                      / | \
                     5  3   6
                    /    \   \
                   1      0   4
                          /
                          10





                        0
                      / | \
                     5  3   6
                    /  / \  /\
                   4  2   0 1 5
                       \  /
                        1 10
                         \
                          1
  */


    public static void main(String[] args){
        Node root = new Node(0);

        Node five = new Node(5);
        Node three = new Node(3);
        Node zero = new Node(0);
        Node ten = new Node(10);
        Node six = new Node(6);
        Node four = new Node(4);
        Node one = new Node(1);

        five.children = new Node[1];
        five.children[0] = one;

        zero.children = new Node[1];
        zero.children[0] = ten;

        three.children = new Node[1];
        three.children[0] = zero;

        six.children = new Node[1];
        six.children[0]= four;

        root.children = new Node[3];
        root.children[0] = five;
        root.children[1] = three;
        root.children[2] = six;

        one.children = new Node[1];
        one.children[0] = new Node(100);

        System.out.println(getCheapestCost(root));
        Node[] path = new Node[4];//length of path can be at max the height
        printCheapestCostAndPath(root, root, path, 0);

    }

    //O(n) time and O(1) space
    static int getCheapestCost(Node cur) {

        if(cur == null){
            return 0;
        }
        if(cur.children == null){//base case
            return cur.cost;
        }

        int minChild = Integer.MAX_VALUE;
        for(Node child: cur.children){
            int childCost = getCheapestCost(child);
            if(childCost < minChild){
                minChild = childCost;
            }
        }

        return minChild + cur.cost;
    }


    //O(n) time and O(1) space
    static int printCheapestCostAndPath(Node cur, Node root, Node[] path, int ind) {

        if(ind == 0){
           // path[0] = root;
           // ind++;
        }

        if(cur == null){
            return 0;
        }
        if(cur.children == null){//base case
            return cur.cost;
        }

        int minChild = Integer.MAX_VALUE;
       // ind++;
        for(Node child: cur.children){
            int childCost = printCheapestCostAndPath(child, root, path, ind+1);
            if(childCost < minChild){
                minChild = childCost;
                path[ind] = child;

            }
        }


        if(cur.equals(root)){  //top most level of recursion, print the path as all children are done
            System.out.print("Min Cost: "+ (minChild + cur.cost)+", Path: ");
            int tempSum  = 0;
                for(int i = 0 ; i< path.length; i++){
                    if(path[i]!=null) {
                       tempSum += path[i].cost;
                       if(tempSum > minChild + cur.cost){
                           break;
                       }
                        System.out.print(path[i].cost + " -> ");
                    }
                }

        }

        return minChild + cur.cost;
    }

}
