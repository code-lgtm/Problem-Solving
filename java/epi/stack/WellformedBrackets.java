package epi.stack;

import java.util.Stack;

//Check if brackets are wellformed in O(n) time and O(1) space
public class WellformedBrackets {

    public static void main(String[] args){
        System.out.println(isWellFormed("[()[]{()()}]".toCharArray()));
        System.out.println(isWellFormed("[()[]{()(){]".toCharArray()));

        /*
        Output:

        true
        false
         */
    }

    static boolean isWellFormed(char[] pattern){

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < pattern.length; i++){
            char cur = pattern[i];
            if(cur == '{' ||cur == '(' ||cur == '[' ){
                stk.push(cur);
            }else{
                if(stk.isEmpty()){//there are more closing than opening brackets
                    return false;
                }

                char top = stk.pop();
                if((cur == '}' && top != '{') ||
                        (cur == ']' && top != '[') ||
                        (cur == ')' && top != '(') ){
                    return false;
                }

            }
        }

        //stack should be empty at this point, if not then the pattern isn't wellformed
        return stk.isEmpty();
    }

}
