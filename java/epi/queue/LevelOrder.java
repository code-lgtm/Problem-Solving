package epi.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Create Array of levels of a tree in O(n) time and space . Example: ((314),(6,6),(271,561, 2, 271),(28,0,3,1,28),(17,401, 257), (641)}
public class LevelOrder {
    static class BNode{
        BNode left, right;
        int value;

        BNode(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {

        /*
           1
        /     \
      3        -1
    /   \     /   \
   2     12   4     5
        /   / \     \
       13  14  22     6


       Output:
        3
        1

         */

        BNode one1 = new BNode(1);
        BNode three1 = new BNode(3);
        BNode mOne = new BNode(-1);
        one1.left = three1;
        one1.right = mOne;
        BNode two1 = new BNode(2);
        BNode one2 = new BNode(12);
        three1.left = two1;
        three1.right = one2;
        BNode one3 = new BNode(13);
        one2.left = one3;

        BNode four = new BNode(4);
        BNode five = new BNode(5);
        mOne.left = four;
        mOne.right = five;

        BNode one4 = new BNode(14);
        BNode two2 = new BNode(22);
        four.left = one4;
        four.right = two2;

        BNode six = new BNode(6);
        five.right = six;

        List<List<Integer>> levels = getLevels(one1);
        for (List<Integer> level: levels){
            for(Integer val: level){
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

    //level order traversal using two queues
    static  List<List<Integer>>  getLevels(BNode root){

        List<List<Integer>> levels = new ArrayList<>();
        Queue<BNode> level = new LinkedList<>();
        level.add(root);
        List<Integer> levelVals = new ArrayList<>();
        Queue<BNode> nextLevel = new LinkedList<>();

        while (!level.isEmpty()){
            BNode cur = level.poll();
            levelVals.add(cur.value);

            if(cur.left!= null){
                nextLevel.add(cur.left);
            }
            if(cur.right!= null){
                nextLevel.add(cur.right);
            }

            if(level.isEmpty()){
                level = nextLevel;
                nextLevel = new LinkedList<>();
                levels.add(levelVals);
                levelVals = new ArrayList<>();
            }


        }

        return levels;

    }
}
