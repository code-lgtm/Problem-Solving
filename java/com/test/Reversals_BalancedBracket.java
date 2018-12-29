package com.test;

import java.util.Stack;

public class Reversals_BalancedBracket {

    //https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/

    public static void main(String[] args){
        char[] ip = "}{{}}{{{".toCharArray();
        System.out.println("min cnt: "+getMinCnt(ip));
        ip = "{{{".toCharArray();
        System.out.println("min cnt: "+getMinCnt(ip));
        ip = "{{{{".toCharArray();
        System.out.println("min cnt: "+getMinCnt(ip));
        ip = "{{{{}}".toCharArray();
        System.out.println("min cnt: "+getMinCnt(ip));


        /*
        Output:
        min cnt: 3
        min cnt: -1
        min cnt: 2
        min cnt: 1

         */
    }


    static int getMinCnt(char[] ip){

        Stack<Character> aux = new Stack<Character>();

        if(ip.length % 2 != 0){
            return -1;//can't balance odd brackets
        }

        for(int i =0; i < ip.length; i++){
            Character top = aux.isEmpty()?null:aux.peek();

            if(top!= null && isOpposite(top, ip[i])){
                aux.pop();//remove it, its balanced
            }else {
                aux.push(ip[i]);
            }
        }

        if(aux.size() == 0){
            return 0;//string is balanced
        }

        //now the aux will have something like }}{{{{ left , that is even number of closing brackets followed by even number of opening brackets
        //so to balance this we need to reverse half of closing brackets and half of opening brackets - Please note we need to take the floor of close/2 and open/2 to deal with the cases lie }{{{ . This is equal to actually equal to (open+close)/2 + open%2

        int totalUnbalnced = aux.size();
        int open = 0;

        while( !aux.isEmpty() && aux.peek() != '}'){
            aux.pop();
            open++;
        }

        int close = totalUnbalnced - open;

        return (int)(Math.ceil(open/2d) + Math.ceil(close/2d));
    }


    static boolean isOpposite(char one, char two){
       return (one == '{' && two == '}');
    }

}
