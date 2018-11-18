package com.test;

public class RecursiveMultiply {
    public static void main(String[] args) {
        //multiply two numbers without using *, with recursion 
        int res = multiply(7, 5, 0);
        System.out.println(res);
    }

    static int multiply(int a, int b, int temp){
        //add a with a , b times

        if(b==0){
            return temp;
        }

        temp += a;
        return multiply(a, b-1, temp);
    }

}
