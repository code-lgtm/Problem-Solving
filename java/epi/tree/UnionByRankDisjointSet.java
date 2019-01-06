package epi.tree;

import java.util.HashMap;
import java.util.Map;

public class UnionByRankDisjointSet {
    //Union By Rank and Path Compression https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
    static class TNode{
        int data;
        int rank;
        TNode parent;
        TNode(int data, int rank){
            this.data = data;
            this.rank = rank;
        }

    }
    static  Map<Integer, TNode> sets = new HashMap<>();

    static void makeSet(int data){
        TNode n = new TNode(data, 0);
        n.parent = n;
        sets.put(data, n);
    }

    static TNode find(int data){
        return find(sets.get(data));
    }

    static TNode find(TNode cur){
        if(cur.parent == cur){
            return cur;
        }
        //else traverse towards parent and apply path compression so that the height if the tree is minimal
        TNode topParent = find(cur.parent);
        cur.parent = topParent;//all the children will start pointing to the top most node. It's path compression

        return topParent;
    }

    static boolean union(int n1, int n2){
        TNode par1 = find(n1);
        TNode par2 = find(n2);

        if(par1.data == par2.data){
            return false;
        }

        // merge the two trees, higher rank tree will be the parent
        if(par1.rank == par2.rank){//anyone can be the new parent
            par1.rank++;
            par2.parent = par1;
        }else if(par1.rank > par2.rank){
            par2.parent = par1;
        }else{
            par1.parent = par2;
        }
        return true;
    }

    public static void main(String args[]) {
        makeSet(1);
        makeSet(2);
        makeSet(3);
        makeSet(4);
        makeSet(5);
        makeSet(6);
        makeSet(7);

        union(1, 2);
        union(2, 3);
        union(4, 5);
        union(6, 7);
        union(5, 6);
        union(3, 7);

        //all the sets would have merged to one
        System.out.println(find(1).data);
        System.out.println(find(2).data);
        System.out.println( find(3).data);
        System.out.println(find(4).data);
        System.out.println(find(5).data);
        System.out.println(find(6).data);
        System.out.println(find(7).data);

        /*
        Output:

        4
        4
        4
        4
        4
        4
        4
         */
    }

}
