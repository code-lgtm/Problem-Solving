package com.test;

import java.util.*;

public class VerticalBTreeTraversal {

    private static int minHDis= 0;
    private static int maxHDis= 0;
    private static Map<Integer, ArrayList> hDisMap = new HashMap<Integer, ArrayList>();//stores horizontal distance to list of BNode

    public static class BNode{
        public BNode left;
        public BNode right;
        public int value;
        public int hDistance = 0;

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

Expected Output:

3
2
1 4 6
5
7
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

        //Time complexity is O(n) - as all the nodes are visited only ones
        printVertical(n1);//n1 is the root

        /*
         Output:
3 @ distance -2
2 @ distance -1
1 @ distance 0
4 @ distance 0
6 @ distance 0
5 @ distance 1
7 @ distance 2
8 @ distance 3
         */

    }

    private static void printVertical(BNode root){
//we will do a level order traversal and then assign the horizontal distance

        Queue<BNode> iterationQ = new LinkedList<BNode>();
        iterationQ.add(root);


        while(! iterationQ.isEmpty()){

          BNode cur =  iterationQ.remove();
       //   System.out.println(cur.value+" @ distance "+ cur.hDistance);
          addToHM(cur);
          if(cur.left != null){
              cur.left.hDistance = cur.hDistance -1;
              if (cur.left.hDistance < minHDis){
                  minHDis = cur.left.hDistance;
              }
              iterationQ.add(cur.left);
          }
          if(cur.right != null){
              cur.right.hDistance = cur.hDistance +1;
              if (cur.right.hDistance > maxHDis){
                  maxHDis = cur.right.hDistance;
              }
              iterationQ.add(cur.right);
          }

        }



        for(int i = minHDis ; i<= maxHDis; i++){

            ArrayList<BNode> bNodeList =  hDisMap.get(i);
            if(bNodeList != null){
                    for(BNode node: bNodeList){
                       System.out.println(node.value +" @ distance "+ node.hDistance);
                    }

            }

        }

    }

    private static void addToHM(BNode cur){
        Integer hmKey = cur.hDistance;

        ArrayList<BNode> bNodeList =  hDisMap.get(hmKey);
        if(bNodeList == null){
            hDisMap.put(hmKey, new ArrayList<BNode>());
            bNodeList = hDisMap.get(hmKey);
        }

        bNodeList.add(cur);


    }

}
