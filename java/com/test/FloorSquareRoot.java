package com.test;

public class FloorSquareRoot {

    public static void main(String[] args) {
        int n = 17;
        System.out.println("Floor Sq root of "+n+" is "+findFloorSqRoot(0 , n, n));

    }


    private static int findFloorSqRoot(int min, int max, int n){

        if(n == 0 || n == 1){
            return n;
        }

        int mid = (min + max)/2;
        int sq = mid * mid;

        if( min > max){
            return mid; // this is the closest we can get to the square root, it will be the floor square root
        }

        if (sq == n){//found the number
            return mid;
        }else if (sq > n){//search on the left sub array
            return findFloorSqRoot(min, mid -1, n);
        }else{//search on the right sub array
            return findFloorSqRoot(mid + 1, max, n);
        }

    }


}
