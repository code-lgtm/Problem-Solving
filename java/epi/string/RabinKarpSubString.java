package epi.string;

//RabinKarp substring matching in Avg O(m + n) time and O(1) space
//This algo can be extended to search many patterns in a given text simultaneously
//https://www.youtube.com/watch?v=H4VrKHVG5qI
public class RabinKarpSubString {
    static int prime = 101;//take any prime number
    public static void main(String[] args){
        char[] ip = "The quick brown fox jumps over the lazy dog".toCharArray();
        char[] pat = "umps".toCharArray();
        System.out.println(match(ip, pat));

        ip = "The quick brown fox jumps over the lazy dog".toCharArray();
        pat = "uic".toCharArray();
        System.out.println(match(ip, pat));

        ip = "The quick brown fox jumps over the lazy dog".toCharArray();
        pat = "icc".toCharArray();
        System.out.println(match(ip, pat));

        /*
        Output:

        21
        5
        -1
         */
    }

    //see if the hash of the substring matches, if yes then compare the substrings char by char
    static int match(char[] ip, char[] pat){
        int patHash = getInitialHash(pat, pat.length);
        int textHash = getInitialHash(ip, pat.length);//hash of initial chars with length = pat.length

        for (int i = 1; i <= ip.length - pat.length; i++){
//if hash matches then compare the patterns
            if(patHash == textHash && matches(ip, pat, i-1)){
                return i-1;//pattern found
            }

            //get the rolling hash
            textHash = getRollingHash(ip, pat.length, i-1, i+pat.length-1, textHash);

        }

        return -1;
    }

    static int getInitialHash(char[] txt, int len){
        int hash = 0;
        for(int i = 0; i < len; i++){
            hash += (txt[i] * Math.pow(prime, i));
        }

        return hash;
    }

    //this substracts the first digit and add the last digit
    static int getRollingHash(char[] txt, int len, int oldIndex, int newIndex, int oldHash){
        int newHash = oldHash - txt[oldIndex];
        newHash /= prime;
        newHash =newHash +  txt[newIndex] * (int)Math.pow(prime, (len-1));
        return newHash;
    }
    //char by char match
    static boolean matches(char[] text, char[] pat, int start){
        for(int i= start; i < (start+pat.length); i++){
            if(text[i] != pat[i-start]){
                return false;
            }
        }
        return true;
    }
}
