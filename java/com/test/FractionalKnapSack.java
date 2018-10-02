package com.test;

import java.util.Arrays;
import java.util.Comparator;

//Greedy approach
public class FractionalKnapSack {
//Time complexity O(n log n)
    public static void main(String[] args){
        int[] wt = {10, 40, 20, 30};
        int[] val = {60, 40, 100, 120};
        int capacity = 50;

        double maxValue = getMaxValue(wt, val, capacity);
        System.out.println("maxValue: "+maxValue);

        /*
        Output:
        Picked weight: 10, with val: 60
        Picked weight: 20, with val: 100
        Picked Fraction weight: 0.6666666666666666 Weight: 20.0, with val: 80.0
        maxValue: 240.0
         */
    }

    private static double getMaxValue(int[] wt, int[] val, int capacity){
    ItemValue[] iVal = new ItemValue[wt.length];

        for(int i = 0; i < wt.length; i++){
            iVal[i] = new ItemValue(wt[i], val[i], i);
        }

        //sorting items by value;
        Arrays.sort(iVal, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost) ;
            }
        });


        double totalValue = 0d;

        for(ItemValue i: iVal){

            int curWt = (int) i.wt;
            int curVal = (int) i.val;

            if (capacity - curWt >= 0){//this weight can be picked while
                capacity = capacity-curWt;
                System.out.println("Picked weight: "+curWt+", with val: "+curVal);
                totalValue += curVal;

            }else{//item cant be picked whole

                double fraction =   ((double)capacity/(double)curWt);
                totalValue += (curVal*fraction);
                System.out.println("Picked Fraction weight: "+fraction+" Weight: "+(curWt*fraction)+", with val: "+(curVal*fraction));
                capacity = (int)(capacity - (curWt*fraction));
                break;
            }


        }

        return totalValue;

    }

    static class ItemValue  {
        Double cost;
        double wt, val, ind;

        public ItemValue(int wt, int val, int ind){
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = new Double(val/wt );
        }

    }

}
