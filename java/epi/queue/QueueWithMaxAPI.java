package epi.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//Implement a queue which returns running max in O(1) time
public class QueueWithMaxAPI {
    Deque<Integer> runningMax = new LinkedList<>();
    Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args){
        QueueWithMaxAPI que = new QueueWithMaxAPI();
        int[] vals = {1, 2,100,5,50,8,-1,20,3,5,4,3,1};
        for (int val: vals){
            que.enqueue(val);
        }
        while (!que.isEmpty()){
            System.out.println("Cur max: "+que.getMax()+", dequed:  "+que.dequeue());
        }
        /*
        Output:

        Cur max: 100, dequed:  1
        Cur max: 100, dequed:  2
        Cur max: 100, dequed:  100
        Cur max: 50, dequed:  5
        Cur max: 50, dequed:  50
        Cur max: 20, dequed:  8
        Cur max: 20, dequed:  -1
        Cur max: 20, dequed:  20
        Cur max: 5, dequed:  3
        Cur max: 5, dequed:  5
        Cur max: 4, dequed:  4
        Cur max: 3, dequed:  3
        Cur max: 1, dequed:  1
         */
    }

    void enqueue(int val){
        que.add(val);

        //update the running max, remove the values less than the val from the right
        while (!runningMax.isEmpty()){
            if(val > runningMax.peekLast()){
                runningMax.removeLast();
            }else{
                break;
            }
        }
        runningMax.addLast(val);
    }

    int dequeue(){
        int val = que.remove();//removeFirst
        if(val == runningMax.peekFirst()){
            runningMax.removeFirst();
        }
        return val;
    }

    int getMax(){
        return runningMax.peekFirst();
    }

    boolean isEmpty(){
        return que.isEmpty();
    }
}
