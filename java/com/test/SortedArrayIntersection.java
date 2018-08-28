package com.test;

public class SortedArrayIntersection {

    //O(n) solution
    public static void main(String[] args) {

        int[] ip1 = {7, 7, 7, 24, 123, 435};
        int[] ip2 = {5, 6, 7, 7, 23, 123, 400, 435};

        //Outputs 7 7 123 435 in O(n) time
        findIntersection(ip1, ip2);

    }


    public static void findIntersection(int[] ip1, int[] ip2) {
        //start with the smaller in outer loop
        int[] smaller, bigger;
        if (ip1.length <= ip2.length) {
            smaller = ip1;
            bigger = ip2;
        } else {
            smaller = ip2;
            bigger = ip1;
        }


        //O(n)
        for (int i = 0; i < smaller.length; ) {
            for (int j = 0; j < bigger.length; ) {

                if (smaller[i] == bigger[j]) {
                    System.out.print(smaller[i]+" ");
                    i++;
                    j++;
                } else if (smaller[i] < bigger[j]) {
                    i++;
                } else {
                    j++;
                }


            }
        }


    }

}
