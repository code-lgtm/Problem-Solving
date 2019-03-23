package epi.dp;


import java.util.HashSet;
import java.util.Set;

//Check if a given string can be composed by concatenating dictionary words - Time O(n^3) space O(n^2) where n is the size of the input
//Explanation: https://www.youtube.com/watch?v=WepWFGxiwRs
public class WordBreak {
    public static  void main(String[] args){
        String input2 = "iamy";
        Set<String> dict2 = new HashSet<>();
        dict2.add("i");
        dict2.add("am");
        dict2.add("x");
        System.out.println("Is string dictionary concatenated: "+checkConcatDict(input2, dict2)+" \n");

        //bed bat hand beyond
        String input = "BEDBATHANDBEYOND";
        Set<String> dict = new HashSet<>();
        dict.add("BED");
        dict.add("BAT");
        dict.add("HAND");
        dict.add("BEYOND");
        System.out.println("Is string dictionary concatenated: "+checkConcatDict(input, dict));

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
}
