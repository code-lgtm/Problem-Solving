package com.test;

//(1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862 ...)

//Find the nth catalan numbers - Time O(n^2)
//Explaination: https://www.youtube.com/watch?v=5KhooVvUKnE
// https://www.geeksforgeeks.org/program-nth-catalan-number/
public class NthCatalanNumber_DP {

    public static void main(String[] args){
        int nthCatalan = getNthCatalan(6);

        System.out.println(nthCatalan);
        //Output: 42
    }

    static int getNthCatalan(int n){
        int[] cat = new int[n];

        if(n < 1){
            return -1;
        }

        //seeding the first 2 catalan numbers
        cat[0] = 1;
        cat[1] = 1;

        for (int i = 2; i < n; i++){
            for (int j = 0; j<i; j++){
                cat[i] = cat[i] + (cat[j] * cat[i-j-1]);
            }
        }


        return cat[n-1];//nth catalan number
    }

}
