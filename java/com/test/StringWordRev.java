package com.test;

public class StringWordRev {
    public static void main(String[] args){
        String ip = "This is a test String\n";
        System.out.println("Reverse is: "+ getStrWordRev(ip.toCharArray()));
    }

    private static String getStrWordRev(char[] ip){

        int wordStart = 0;
        int wordEnd = -2;
        for(int i=0; i < ip.length; i++){
            if(ip[i] == ' '||ip[i] == '\n'){
                wordStart = wordEnd+2;
                wordEnd = i -1;
              //  System.out.println(wordStart+" - "+wordEnd);
                inPlaceWordRev(wordStart, wordEnd, ip);

            }
        }

        return new String(ip);
    }

    private static  void inPlaceWordRev(int start, int end, char[] ip){
        //reverse from start to end including both indices

        while(start < end){
            char temp = ip[start];
            ip[start] = ip[end];
            ip[end] = temp;
            start++;
            end--;
        }


    }

}
