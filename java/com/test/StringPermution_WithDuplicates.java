package com.test;

import java.util.HashSet;
import java.util.Set;

public class StringPermution_WithDuplicates {
    static Set<String> dup = new HashSet<String>();

    public static void main(String[] args){
        char[] ip = "AABC".toCharArray();
        printStrPer(ip, 0);
    }

    private static void printStrPer(char[] ip, int start){

        if (start == ip.length){
            if(dup.contains(ip)){
                return;
            }else{
                dup.add(ip.toString());
            }
            System.out.println(ip);
            return;
        }

        for (int i = start; i < ip.length; i++){
            swap(ip, start, i);
            printStrPer(ip, start + 1);
            swap(ip, start, i); //backtrack
        }
    }

    private static void swap(char[] ip, int start, int i){
        char temp= ip[start];
        ip[start] = ip[i];
        ip[i] = temp;
    }
}
