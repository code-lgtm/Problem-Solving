package epi.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputeStringDecompositions {

    //given a sentence and few words of equal length, find substrings in sentence which are composed of the permutation of the words. The words can be duplicate
    public static void main(String[] args){

        String sentence = "amanaaplcanacanal aplanacancan";
        String[] words = {"can","apl","ana"};

        List<String> decompositions = getDecompositions(sentence, words);
        for (String decomp: decompositions){
            System.out.println(decomp);
        }
/*
Output:
    anaaplcan
    aplanacan
 */
    }

    //Time complexity O(nm)
    static List<String> getDecompositions(String sentence, String[] words){
        List<String> decomps = new ArrayList<>();
        Map<String, Integer> wordCntMap = new HashMap<>();

        for(String word: words){//insert or update
            wordCntMap.put(word, wordCntMap.containsKey(word)?wordCntMap.get(word)+1:1);
        }

        int window = words[0].length();
        for (int i = 0 ; i <sentence.length()-window;i++){
            String sub = sentence.substring(i, i+window);

            if(wordCntMap.containsKey(sub)){

                String decomp = getDecomp(sentence,i, window, words.length, wordCntMap);
                if(decomp!= null){
                    decomps.add(decomp);
                }
            }
        }

        return decomps;
    }

    //find single decomposition starting @ start
    private static String getDecomp(String sentence, int start, int window, int wordCnt, Map<String, Integer> wordCntMap ){
        Map<String, Integer> temp = new HashMap<>();

        int words = 0;
        for (int i = start ; i <sentence.length()-window;) {
            words++;
            String sub = sentence.substring(i, i + window);
            temp.put(sub, temp.containsKey(sub)?temp.get(sub)+1:1);
            if(words == wordCnt){
                break;
            }
            i += window;
        }

        //match temp map with word map to see if the permutation occurs

        for (String word: wordCntMap.keySet()){
            if (!(temp.containsKey(word) && temp.get(word) == wordCntMap.get(word) && temp.size() == wordCntMap.size())){
                return null;
            }
        }


        return sentence.substring(start, start + (window*wordCnt));
    }

}
