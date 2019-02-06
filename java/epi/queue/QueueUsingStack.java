package epi.queue;

import java.util.Stack;

//Implement queue using stack
public class QueueUsingStack {
    public static void main(String[] args){
        enqueu(1);
        enqueu(2);
        enqueu(3);
        System.out.println(dequeue());
        System.out.println(dequeue());
        enqueu(4);
        System.out.println(dequeue());
        System.out.println(dequeue());

        /*
        output:
        1
        2
        3
        4
         */
    }

    static Stack<Integer> enq = new Stack<>(), deq = new Stack<>();

    static void enqueu(int val){
        enq.push(val);
    }

    static int dequeue(){

        if(deq.isEmpty()){
            while (!enq.isEmpty()){
                deq.push(enq.pop());
            }
        }

        return deq.pop();

    }
}
