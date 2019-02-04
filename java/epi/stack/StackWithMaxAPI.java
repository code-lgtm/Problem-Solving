package epi.stack;

import java.util.Deque;
import java.util.LinkedList;

//Implement a stack API which returns max at any point in O(1) time
//Time complexity O(1) for all operations
//Space complexity - O(1) in best case when the number of unique elements is small compared to the number of elements in the stack, otherwise O(n)
public class StackWithMaxAPI {
    static class MaxWithCnt{
        int max;//max value till now
        int cnt;//cnt of the max
        MaxWithCnt(int max, int cnt){
            this.max = max;
            this.cnt = cnt;
        }
    }

    private Deque<Integer> stk = new LinkedList<>();//doubly linked list as stack
    private Deque<MaxWithCnt> maxs = new LinkedList<>();//keeps the max seen till now and its count

    public static void main(String[] args){
//2 2 1 4 5 5 3

        StackWithMaxAPI mStk = new StackWithMaxAPI();

        mStk.push(2);
        mStk.push(2);
        mStk.push(1);
        mStk.push(4);
        mStk.push(5);
        mStk.push(5);
        mStk.push(3);
        while (!mStk.isEmpty()){
            System.out.println( "max before pop: "+mStk.max()+", popped: "+mStk.pop());
        }

        /*
max before pop: 5, popped: 3
max before pop: 5, popped: 5
max before pop: 5, popped: 5
max before pop: 4, popped: 4
max before pop: 2, popped: 1
max before pop: 2, popped: 2
max before pop: 2, popped: 2
         */

    }

    public  void push(Integer val){//add the value to stack and update the MaxWithCnt

        stk.addFirst(val);
        if(stk.size() == 1){//first value, simply make it the MaxWithCnt
            maxs.addFirst(new MaxWithCnt(val, 1));
        }else{//ignore the case where val < max
            int max = max();//get the max before this value is added
            if(val == max){//update the max cnt
                maxs.peekFirst().cnt++;
            }else if (val > max){//we got a new max
                maxs.addFirst(new MaxWithCnt(val, 1));
            }
        }

    }

    public  boolean isEmpty(){
        return stk.size() == 0;
    }

    public  Integer pop(){//remove the top element in the stack and adjust the max cnt
        Integer cur = stk.removeFirst();

        if(max() ==  cur && maxs.peekFirst().cnt > 1){
            maxs.peekFirst().cnt--;
        }else if(max() ==  cur && maxs.peekFirst().cnt == 1){
            maxs.removeFirst();
        }

        return cur;
    }

    public Integer max(){
        return maxs.peekFirst().max;
    }


}
