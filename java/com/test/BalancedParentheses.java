package com.test;

public class BalancedParentheses {
    //https://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
    public static void main(String[] args){
        int pairs = 10;
        char[] buff = new char[pairs * 2];
        printValidParentheses(buff, pairs, 0, 0, 0);
    }

    static void printValidParentheses(char[] buff, int pairs, int ind, int open, int close){

        if(open == close && open == pairs){
            for(char c: buff){
                System.out.print(c);
            }
            System.out.println();
        }

        if (open > close){
            buff[ind] = '}';
            printValidParentheses(buff, pairs, ind + 1, open, close +1);
        }

        if(open < pairs){
            buff[ind] = '{';
            printValidParentheses(buff, pairs, ind+1, open +1, close);
        }
    }

}
