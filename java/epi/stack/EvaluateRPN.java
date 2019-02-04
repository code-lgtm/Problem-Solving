package epi.stack;

import java.util.Stack;

//Evaluate Reverse Polish Notation in O(n) time and O(1) space
public class EvaluateRPN {

    public static void main(String[] args){
        String expression = "3,4,+,2,*,1,+";//should evaluate to  (3 + 4) X 2 + 1 = 15
        System.out.print(evaluateRPN(expression));
    }

    static int evaluateRPN(String exp){
        String[] tokens =  exp.split(",");

        Stack<Integer> stk = new Stack();

        for (String token: tokens){

            if ("+-/*".contains(token)){//token is an operator

                int b = stk.pop();
                int a = stk.pop();

                if(token.equals("+")){
                    stk.push(a+b);
                }else if(token.equals("-")){
                    stk.push(a-b);
                }else if(token.equals("/")){
                    stk.push(a/b);
                }else if(token.equals("*")){
                    stk.push(a*b);
                }
            }else{
                stk.push(Integer.parseInt(token));
            }
        }

        return stk.pop();
    }

}
