package com.test;

//find the diameter of a tree in O(n) time
public class BtreeDiameter {
    public static class BNode{
        public BNode left;
        public BNode right;
        public int value;

        public BNode(int value){
            this.value = value;
        }

    }
    static class HeightDiameter{
        int height, diameter;
        HeightDiameter(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }
static BNode getT1(){
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
    return n1;
}

    static BNode getT2(){
        BNode n1 = new BNode(1);
        BNode n2 = new BNode(2);
        BNode n3 = new BNode(3);
        BNode n4 = new BNode(4);
        BNode n5 = new BNode(5);
        BNode n6 = new BNode(6);
        BNode n7 = new BNode(7);
        BNode n8 = new BNode(8);
        BNode n9 = new BNode(9);


        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n3.left = n6;
        n6.left = n8;
        n4.right = n7;
        n7.left = n9;

        return n1;
    }
    public static void main(String[] args) {

/*
Tree1 - diameter passes through root
                1
               / \
              2   5
             / \ / \
            3  4 6  7
                     \
                      8

Tree2 - diameter does not pass through root
                1
               / \
              2   5
             / \
            3   4
           /     \
          6       7
         /       /
        8       9

*/







        HeightDiameter hd = getDiameter(getT1());
        System.out.println("Diameter: "+hd.diameter);

        hd = getDiameter(getT2());
        System.out.println("Diameter: "+hd.diameter);

        /*
        Output:
        Diameter: 5
        Diameter: 6
         */
    }

    static HeightDiameter getDiameter(BNode cur){
        if (cur == null){//base case
            return new HeightDiameter(0,0);
        }

        HeightDiameter lHd = getDiameter(cur.left);
        HeightDiameter rHd = getDiameter(cur.right);

        int newHeight = Math.max(lHd.height, rHd.height)+1;

        //width/diameter would be max ( (lHw.height+rHw.height), left diameter, right diameter)
        int curDiameter = Math.max((lHd.height+rHd.height), Math.max(lHd.diameter, rHd.diameter));


        return new HeightDiameter(newHeight, curDiameter);
    }

}
