package epi.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLeafWithBudget {
   // https://www.geeksforgeeks.org/maximum-number-of-leaf-nodes-that-can-be-visited-within-the-given-budget/
    static class BNode{
        BNode left, right, parent;
        int value;
        BNode(int value){
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

         */

        BNode root = insert(null, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);

        System.out.println(" - Total picked: "+getMaxLeaves(root, 2));
        System.out.println(" - Total picked: "+getMaxLeaves(root, 1));
        System.out.println(" - Total picked: "+getMaxLeaves(root, 50));
        System.out.println(" - Total picked: "+getMaxLeaves(root, 5));
        System.out.println(" - Total picked: "+getMaxLeaves(root, 9));

        /*
        Output:
        22  - Total picked: 1
         - Total picked: 0
        22 4 10 14  - Total picked: 4
        22 4  - Total picked: 2
        22 4 10  - Total picked: 3
         */
    }

    static int getMaxLeaves(BNode root, int budget){

        Queue<BNode> levels = new LinkedList<BNode>();
        levels.add(root);
        levels.add(null);
        int level = 1;
        int picked = 0;

        while (! levels.isEmpty()){
            BNode cur = levels.remove();
            if(cur == null){
                level++;
                if(!levels.isEmpty()){
                    levels.add(null);
                }
            }else if(cur.left == null && cur.right == null){
                if( (budget - level) >= 0){
                    budget = budget - level;
                    picked++;
                    System.out.print(cur.value+" ");
                }else{//no budget
                    return picked;
                }
            }else{//add childeren to the queue
                if(cur.left != null){
                    levels.add(cur.left);
                }
                if(cur.right != null){
                    levels.add(cur.right);
                }
            }
        }

        return picked;
    }


    static BNode insert(BNode root, int value){

        if(root == null){
            return new BNode(value);
        }


        if(value < root.value){//go left
            BNode templ = insert(root.left, value);
            root.left = templ;
            templ.parent = root;
        }else{//go right
            BNode tempr = insert(root.right, value);
            root.right = tempr;
            tempr.parent = root;
        }

        return root;

    }

}
