package epi.dp;


import java.util.HashSet;
import java.util.Set;

//Check if a given string can be composed by concatenating dictionary words - Time O(n^3) space O(n^2) where n is the size of the input
//Explanation: https://www.youtube.com/watch?v=WepWFGxiwRs
//Update: checkConcatDict2 solves it in O(n^2 * w) and O(n) space - w is the size of the max word
public class WordBreak {
   static int maxWordLen = 10;
    public static  void main(String[] args){
        String input2 = "iamy";
        Set<String> dict2 = new HashSet<>();
        dict2.add("i");
        dict2.add("am");
        dict2.add("x");
        System.out.println("Is string dictionary concatenated: "+checkConcatDict(input2, dict2)+" \n"+checkConcatDict2(input2, dict2)+" \n");

        //bed bat hand beyond
        String input = "BEDBATHANDBEYOND";
        Set<String> dict = new HashSet<>();
        dict.add("BED");
        dict.add("BAT");
        dict.add("HAND");
        dict.add("BEYOND");
        System.out.println("Is string dictionary concatenated: "+checkConcatDict(input, dict)+" \n"+checkConcatDict(input, dict));

        /*
        Output:
true  false true  false
false false true  false
false false false false
false false false false
Is string dictionary concatenated: false

false false true  false false true  false false false true  false false false false false true
false false false false false false false false false false false false false false false false
false false false false false false false false false false false false false false false false
false false false false false true  false false false true  false false false false false true
false false false false false false false false false false false false false false false false
false false false false false false false false false false false false false false false false
false false false false false false false false false true  false false false false false true
false false false false false false false false false false false false false false false false
false false false false false false false false false false false false false false false false
false false false false false false false false false false false false false false false false
false false false false false false false false false false false false false false false true
false false false false false false false false false false false false false false false false
false false false false false false false false false false false false false false false false
false false false false false false false false false false false false false false false false
false false false false false false false false false false false false false false false false
false false false false false false false false false false false false false false false false
Is string dictionary concatenated: true
         */
    }

    //check if the word is concatanation of dictionary words
    static boolean checkConcatDict(String ip, Set<String> dict){
        boolean[][] decomposeAux = new boolean[ip.length()][ip.length()];

        for (int i = 1; i<= ip.length(); i++){
            for (int j=0; j <= ip.length()-i; j++){
                String curDecom = ip.substring(j, j+i);

                if (dict.contains(curDecom)){
                    decomposeAux[j][j+i-1] = true; // deducting one because a decomposition ip.substring(0, 4); is equvalent to saying substring staring at 0 and ending at 3 - including 0 and 3 both
                }else if(curDecom.length() >1){
                    //the decomposition isn't in dictionary, check if an we can split in in two halves which has already been solved as valid dictionary decompositions
                    for (int k = j; k< j+i-1; k++){
                        //The two halves will be j -> k, k+1 -> j+i-1 [Including all these indices]
                        if(decomposeAux[j][k] && decomposeAux[k+1][j+i-1]){
                            decomposeAux[j][j+i-1] = true;//implies that the current decomposition is concatanation of dictionary words, as it's sub decompositions are
                        }
                    }
                }
            }
        }

        printMat(decomposeAux);
        return decomposeAux[0][decomposeAux[0].length-1];//the solution is on the top right corner
    }

    static void printMat(boolean[][] mat){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j]+ (mat[i][j]?"  ":" ") );
            }
            System.out.println();
        }
    }

    static boolean checkConcatDict2(String ip, Set<String> dict){

        boolean[] aux = new boolean[ip.length()];


        for (int i = 0 ; i < ip.length(); i++){
            String sub = ip.substring(0, i+1);
            if (dict.contains(sub)){
                aux[i] = true;
            }else {//check if the pattern sub can be broken into two words which are dictionary

                for (int j = i-1; j>= 0; j--){
                    String sub2 = sub.substring(j, i+1);
                    if (sub2.length() > maxWordLen){//a word with this length cant exist in the dictionary
                        break;
                    }
                    if (aux[j] && dict.contains(sub2)){//check if there is a substring which can which starts at j and ends at i (including both) and it exists in a dictionary
                        aux[i] = true;
                        break;
                    }
                }
            }
        }
        return aux[aux.length-1];
    }
}
