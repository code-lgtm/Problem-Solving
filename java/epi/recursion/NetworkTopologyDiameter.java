package epi.recursion;

import java.util.ArrayList;

//Find the worst case length of path in a network topology in O(n) time and O(h) space
//This problem can be solved by finding the diameter of the tree
public class NetworkTopologyDiameter {
    static   class TNode{
        String id;
        int length;//length if the edge from its parent
        ArrayList<TNode> children = new ArrayList();
        TNode(String id, int length){
            this.id = id;
            this.length = length;
        }
    }

    static class HeightDiameter{
        double height, diameter;
        HeightDiameter(double height, double diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }
    public static void main(String[] args){

        /*

        Network topology with
                    A
                 3/  1\
                 B     C
             1/ 2| 6\
             D   E   F
                1|
                 G
         */


        TNode g = new TNode("g", 1);
        TNode e = new TNode("e", 2);
        e.children.add(g);
        TNode d = new TNode("d", 1);
        TNode f = new TNode("f", 6);
        TNode b = new TNode("b", 3);
        b.children.add(d);
        b.children.add(e);
        b.children.add(f);
        TNode c = new TNode("c", 1);
        TNode a = new TNode("a", 0);
        a.children.add(b);
        b.children.add(c);

        HeightDiameter max = getDiameter(a);
        System.out.print("Diameter: "+ max.diameter);

        /*
        Output:
        Diameter: 9.0
         */

    }


    static HeightDiameter getDiameter(TNode cur){

        if (cur == null){
            return new HeightDiameter(0,0);
        }

        double maxChildDiameter = 0; //this will be the sum of max child heights
        double[] topTwoHeights = new double[2];

        for (TNode child: cur.children){
            HeightDiameter childHD = getDiameter(child);
            double curHeight = childHD.height + child.length;//child.length is distance of child from cur

            //see if we have a max height
            if (curHeight > topTwoHeights[0]){
                topTwoHeights[1] = topTwoHeights[0];
                topTwoHeights[0] = curHeight;
            }else if(curHeight > topTwoHeights[1]){
                topTwoHeights[1] = curHeight;
            }

            //get the max diameter at the cur
            maxChildDiameter = Math.max(maxChildDiameter, childHD.diameter);

        }

        //at this point we have the max two heights at cur node and the max diameter of cur's children
        //so the max diameter is: max of maxChildDiameter and the sum of the top two heights
        double maxDiameterCur = Math.max(maxChildDiameter, (topTwoHeights[0]+topTwoHeights[1]));

        return new HeightDiameter(topTwoHeights[0], maxDiameterCur);//return the max height and maxDiameter at cur
    }

}
