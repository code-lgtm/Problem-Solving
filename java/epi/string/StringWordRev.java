package epi.string;

//Reverse all the words of a string in O(n) time and O(1) space
public class StringWordRev {
    public static void main(String[] args){
        String ip = "This is a test String\n";
        System.out.println("Reverse is: "+ getStrWordRev(ip.toCharArray()));

        //Ouput: Reverse is: sihT si a tset gnirtS
    }

    private static String getStrWordRev(char[] ip){

        int wordStart = 0;
        int wordEnd = -2;
        for(int i=0; i < ip.length; i++){
            if(ip[i] == ' '||ip[i] == '\n'){
                wordStart = wordEnd+2;
                wordEnd = i -1;
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
