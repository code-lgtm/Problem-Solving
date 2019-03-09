package epi.recursion;

import java.util.ArrayList;

//Find all the Palindromic decompositions of a given String
//Time complexity O(n*2^n) - as there can be atmost 2^n distinct decompositions and we need n time deep copying those. PRACTICALLY THE TIME COMPLEXITY WILL BE MUCH LESS AS WE PROCESS JUST THE PALINDROMIC SEQUENCES
//Space - O(2^n) as we are storing the decompositions , can be reduced to O(n) by simply printing the decompositions
public class PalindromicDecompositions {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        String ip = "geekskeeg";
        generatePD(ip, 0, new ArrayList<String>(), result);

        for (ArrayList<String> pal : result){
            if(pal == null){//start of new decomposition
                System.out.println();
            }else {
                for (String dec: pal){
                    System.out.print(dec+" ");//print the palindromic decomposition
                }
            }
        }

        /*
        Output:
        g e e k s k e e g
        g e e k s k ee g
        g e e ksk e e g
        g e e ksk ee g
        g e ekske e g
        g ee k s k e e g
        g ee k s k ee g
        g ee ksk e e g
        g ee ksk ee g
        g eekskee g
        geekskeeg
         */
    }

    static void generatePD(String ip, int start, ArrayList<String> buffer, ArrayList<ArrayList<String>> result){
        if (start == ip.length()){
            result.add(new ArrayList<>(buffer));
            result.add(null);
            return;
        }

        for (int i = start+1; i <= ip.length(); i++){
            String temp = ip.substring(start, i);
            if(isPalindromic(temp)){// we will only recurse for the string which are palindromic decompositions till this point
                buffer.add(temp);
                generatePD(ip, i, buffer, result);
                buffer.remove(buffer.size()-1);//backtrack to explore other possibilities
            }
        }

    }

    static boolean isPalindromic(String sub){
        int mid = sub.length()/2;

        for (int i = 0; i <= mid; i++){
            if(sub.charAt(i) != sub.charAt(sub.length()-1-i)){
                return false;
            }
        }

        return true;
    }


}


