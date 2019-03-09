package epi.recursion;


//Generate n pairs of matching parenthesis
public class MatchingParenthesis {

    public static void main(String[] args) {
        int n = 3;
        generateMatchingPatenthesis(n, 0, 0, new char[2*n], 0);

        /*
        ((()))
        (()())
        (())()
        ()(())
        ()()()
         */
    }

    static void generateMatchingPatenthesis(int n, int open, int close, char[] buff, int bufInd){
        if (open == n && close == n){
            System.out.println(buff);
            return;
        }


        if (open < n){
            buff[bufInd] = '(';
            generateMatchingPatenthesis(n, open+1, close, buff, bufInd+1);
        }

        if (open > close){
            buff[bufInd] = ')';
            generateMatchingPatenthesis(n, open, close+1, buff, bufInd+1);
        }



    }
}
