package epi.string;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/look-and-say-sequence/

//Generate the look-and-say-sequence:  1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211
//Time complexity: O(n*2^n) the sequence almost doubles n times - this costs 2^n and the the recuression will be n times . Total n*2^n
public class LookAndSaySequence {
    public static void main(String[] args){
        int n = 5;
        List<Character> seq = new ArrayList<>();
        seq.add('1');

        List<Character> nth =  getNthSeq(seq, n, 0);
        nth.forEach( ch -> {System.out.print(ch);});
    }

    static List<Character> getNthSeq(List<Character> seq, int n, int cur ){

        if(n == cur){//we have the nth seq
            return seq;
        }

        List<Character> next = new ArrayList<>();
        for(int i = 0; i < seq.size(); i++){//count the occurence of each char
            int cnt = 1;
            while (i < seq.size()-1 && seq.get(i) == seq.get(i+1)){
                cnt++;
                i++;
            }

            String cntS = new Integer(cnt).toString();
            for (int x = 0; x< cntS.length(); x++){//If cnt >= 10 then we need to insert all the chars
                next.add(cntS.charAt(x));
            }

            next.add((seq.get(i)));

        }

        return getNthSeq(next, n, cur+1);
    }
}
