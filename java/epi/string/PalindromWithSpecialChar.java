package epi.string;

//Case insensitive Palindrome test while ignoring special chars - Time O(n), space O(1)
public class PalindromWithSpecialChar {
    public static void main(String[] args){
        String ip = "A man, a plan, a canal, Panama.";
        String ip2 = "A man, a plan, a canal, xanama.";
        System.out.println(isPalinDrome(ip));
        System.out.println(isPalinDrome(ip2));

        /*
        Output:
        true
        false
         */
    }

    static boolean isPalinDrome(String ip){

        int left = 0, right = ip.length()-1;

        while (left<right){
            char leftCharUpper = (char)(ip.charAt(left) > 'Z' ? ip.charAt(left) - ('a' - 'A'): ip.charAt(left));
            char rightCharUpper = (char)(ip.charAt(right) > 'Z' ? ip.charAt(right) - ('a' - 'A'): ip.charAt(right));

            if(isSpecial(ip.charAt(left))){//ignore left
                left++;
            }else if (isSpecial(ip.charAt(right))){//ignore right
                right--;
            }else if( leftCharUpper == rightCharUpper){//non special chars should be matching irrespective of case
                left++;
                right--;
            }else{//neither the chars are equal nor they are special
                return false;
            }
        }

        return true;
    }

    static boolean isSpecial(char c){
        return !((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
    }
}
