package epi.bst;

import java.util.ArrayList;
import java.util.List;
//Find all the nodes in the given range. This logic can be used in problems like finding restaurants close to a given location
//Time complexity 0(m + h) and space 0(m) - m: number of nodes in range
public class RangeLookup {
    static class BNode {
        BNode left, right;
        int value;

        BNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        /*
                             20
                            /  \
                           8    22
                          / \
                         4   12
                            /  \
                           10  14
                               / \
                              13  19

         */

        BNode root = insert(null, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);
        root = insert(root, 13);
        root = insert(root, 19);

        List<BNode> matchingNodes = new ArrayList<>();
        rangeLookup(root, 8,15, matchingNodes);//find all the nodes in the given range. This logic can be used in problems like finding restaurants close to a given location

        for (BNode cur: matchingNodes){
            System.out.print(cur.value+" ");
        }
//Output: 8 12 10 14 13
    }

    static void rangeLookup(BNode cur, int min, int max, List<BNode> matchingNodes){
        if (cur == null){
            return;
        }

        if(cur.value< min){//no need to check the left subtree
            rangeLookup(cur.right, min, max, matchingNodes);
        }else if(cur.value > max){//ignore right
            rangeLookup(cur.left, min, max, matchingNodes);
        }else {//the current node is in the range, store it and visit it's left and right
            matchingNodes.add(cur);
            rangeLookup(cur.left, min, max, matchingNodes);
            rangeLookup(cur.right, min, max, matchingNodes);
        }



    }


    static BNode insert(BNode root, int value){

        if(root == null){
            return new BNode(value);
        }


        if(value < root.value){//go left
            BNode templ = insert(root.left, value);
            root.left = templ;
        }else{//go right
            BNode tempr = insert(root.right, value);
            root.right = tempr;
        }

        return root;

    }
}
