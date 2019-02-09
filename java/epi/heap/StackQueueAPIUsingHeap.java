package epi.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//Implement stack and queue using heap - Time complexity O(log n) for addition and deletion
public class StackQueueAPIUsingHeap {

    PriorityQueue<Element> minHeap = new PriorityQueue<>(new Comparator<Element>() {////for queue
        @Override
        public int compare(Element o1, Element o2) {
            return o1.sequence-o2.sequence;
        }
    });
    PriorityQueue<Element> maxHeap = new PriorityQueue<>(new Comparator<Element>() {//for stack
        @Override
        public int compare(Element o1, Element o2) {
            return o2.sequence-o1.sequence;
        }
    });

    public static void main(String[] args){
        int[] ip = {4,5,7,45,9,2,6,7};
        StackQueueAPIUsingHeap stkQue = new StackQueueAPIUsingHeap();
        int sequence  = 0;
        for (int val: ip){
            sequence++;
            stkQue.queueAdd(new Element(val, sequence));
            stkQue.stackAdd(new Element(val, sequence));
        }


        while (!stkQue.isQueEmpty()){
            System.out.print(stkQue.queueRemove()+" ");
        }
        System.out.println();
        while (!stkQue.isStkEmpty()){
            System.out.print(stkQue.stackTop()+" ");
        }

        /*
        Output:
        4 5 7 45 9 2 6 7
        7 6 2 9 45 7 5 4
         */
    }
    static class Element{
        int val;
        int sequence;
        Element(int val, int sequence){
            this.val = val;
            this.sequence = sequence;
        }
    }

    public void stackAdd(Element e){
        maxHeap.add(e);
    }

    public void queueAdd(Element e){
        minHeap.add(e);
    }

    public boolean isStkEmpty(){
        return maxHeap.isEmpty();
    }

    public boolean isQueEmpty(){
        return minHeap.isEmpty();
    }

    public int stackTop(){
        return maxHeap.poll().val;
    }

    public int queueRemove(){
        return minHeap.poll().val;
    }

}
