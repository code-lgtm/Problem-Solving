package com.test;

public class LexoGraphicalPowerset {

    public static void main(String[] args){
        printLexoPS("abc".toCharArray(), -1, "");

        /*
        Output:

                a
                ab
                abc
                ac
                b
                bc
                c
         */
    }

    private static void printLexoPS(char[] ip, int ind, String buff){
        if(ind == ip.length){
            return;
        }

        System.out.println(buff);

        for(int i = ind+1; i< ip.length; i++){
            buff += ip[i];
            printLexoPS(ip, i, buff);
            buff = buff.substring(0, buff.length()-1);//backtrack by removing the last char
        }

    }

}
