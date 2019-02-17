package epi.bst;

import java.util.Comparator;
import java.util.TreeSet;

//Compute kth element of the equation (a + b*sqrt(c)) - Where a and b are non negative numbers. C is not a square of another integer
//Time - O(k log k) space - O(k)
public class ComputeKthElement {

//the elements will be in the order [(0 + 0*sqrt(2)), (1 + 0*sqrt(2)), (0 + 1*sqrt(2)), (2 + 0*sqrt(2)),(1+ 1*sqrt(2)), (0 + 2*sqrt(2)), (2 + 1*sqrt(2)), (2 + 2*sqrt(2)) .........]
    public static void main(String[] args){
        System.out.print(getkthElement(15, 2));
        //Output: 5.242640687119286
    }

    static class Element{
        int a, b;
        double val;
        Element(int a, int b, int c){
            this.a = a;
            this.b = b;
            val = (a + b*Math.sqrt(c));
        }
    }

    static double getkthElement(int k, int c){
        double kth = 0;

        //Sorted set so that we can retrieve the smallest value while avoiding duplicates
        TreeSet<Element> elements = new TreeSet<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return Double.compare(o1.val, o2.val);
            }
        });

        elements.add(new Element(0,0,c));
        int cnt =0;

        while (cnt<k){
            Element small = elements.pollFirst();//smallest value
            cnt++;
            if(cnt == k){
                return small.val;
            }

            //else add the next set of values
            elements.add(new Element(small.a+1, small.b, c));
            elements.add(new Element(small.a, small.b+1, c));
        }



        return kth;
    }

}
