package com.test;

import java.util.HashMap;
import java.util.Map;

//match two string patterns in O(m+n) time and space
public class MatchPattern {

    public static void main(String[] args){

        System.out.println(match("abbc" , "xyyz"));
        System.out.println(match("abb" , "baa"));
        System.out.println(match("abb" , "bba"));

        /*
        Output:
        1223
        1223
        true
        122
        122
        true
        122
        112
        false
         */
    }

    static boolean match(String pat1, String pat2){

        if(pat1.length()!= pat2.length()){
            return false;
        }
        if(hash(pat1).equals(hash(pat2))){
            return true;//if hashes are same then the patter matches
        }
        return false;
    }

    static String hash(String pat){
        Map charToCode = new HashMap();
        int cnt = 0;
        StringBuffer str = new StringBuffer();

        for(char c: pat.toCharArray()){
            if(charToCode.containsKey(c)){
                str.append(charToCode.get(c));
            }else{
                charToCode.put(c, ++cnt);
                str.append(cnt);
            }
        }

        System.out.println(str);
        return str.toString();
    }
}
