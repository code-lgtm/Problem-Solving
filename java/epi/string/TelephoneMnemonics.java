package epi.string;

import java.util.ArrayList;
import java.util.List;

//Print all the Mnemonics of a given phone number - Time O(4^n x n) Space: Space O(n)
// Time O(4^n x n) - as 4 chars per digit max and for n digit number there will be 4^n mnemonics, multiplied by n which is for copying the string at the base case (there are 4^n base cases)
// Space O(n) - as there will be at max n recursive levels occupying constant memory each
public class TelephoneMnemonics {
    static final char[][] keyPad = {{'0'},  {'1'},  {'a','b','c'},  {'d','e','f'}, {'g','h','i'},  {'j','k','l'},
            {'m','n','o'}, {'p','q','r', 's'},  {'t','u','v'},   {'w','x','y', 'z'},
    };
    public static void main(String[] args){

        char[] ph = {'9','4','0','5'};
        char[] partialMnemonic = new char[ph.length];
        List<String> mnemonics = new ArrayList();
        createMnemonics(ph, 0, partialMnemonic, mnemonics);
        mnemonics.forEach( mnemonic -> {System.out.print(mnemonic+" ");});
        //Output: wg0j wg0k wg0l wh0j wh0k wh0l wi0j wi0k wi0l xg0j xg0k xg0l xh0j xh0k xh0l xi0j xi0k xi0l yg0j yg0k yg0l yh0j yh0k yh0l yi0j yi0k yi0l zg0j zg0k zg0l zh0j zh0k zh0l zi0j zi0k zi0l
    }

    static void createMnemonics(char[] ph, int digit, char[] partialMnemonic, List<String> mnemonics){

        if(digit == ph.length){
            mnemonics.add(new String(partialMnemonic));//deep copying partialMnemonic as the reference is shared with all the levels of recursive calls and would result in the value being modified otherwise
            return;
        }

        int key = ph[digit] - '0'; //'9' char to 9 int casting

        for (int i = 0; i < keyPad[key].length; i++){
            partialMnemonic[digit] = keyPad[key][i];;//add every char at the key one by one
            createMnemonics(ph, digit+1, partialMnemonic, mnemonics);//call the function to compute the mnemonics from the digit at the next index
        }


    }
}
