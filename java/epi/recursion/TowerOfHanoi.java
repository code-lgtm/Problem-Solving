package epi.recursion;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;


//Solve tower of Hanoi in O(2^n) time
public class TowerOfHanoi {
    static int NUM_PEGS = 3;
    public static void main(String[] args){
        int numRings = 4;

        Deque<Integer>[] pegs = new Deque[NUM_PEGS];
        for (int i=0; i < pegs.length; i++){//initialize the pegs
            pegs[i] = new LinkedList<>();
        }


        for (int i = numRings; i >=1; i--){//add the rings
            pegs[0].addFirst(i);
        }
        print(pegs);
        solveTowerOfHanoi(pegs, numRings, 0, 1, 2);//move the rings from 0th peg to 1th peg using 2th peg as aux peg


        /*
        Output:
        1 2 3 4  |  |  |
        2 3 4  |  | 1  |
        3 4  | 2  | 1  |
        3 4  | 1 2  |  |
        4  | 1 2  | 3  |
        1 4  | 2  | 3  |
        1 4  |  | 2 3  |
        4  |  | 1 2 3  |
         | 4  | 1 2 3  |
         | 1 4  | 2 3  |
        2  | 1 4  | 3  |
        1 2  | 4  | 3  |
        1 2  | 3 4  |  |
        2  | 3 4  | 1  |
         | 2 3 4  | 1  |
         | 1 2 3 4  |  |
         */

    }

    static void solveTowerOfHanoi( Deque<Integer>[] pegs, int numRings,  int fromPeg, int toPeg, int auxPeg){

        if (numRings <=0){
            return;
        }

        solveTowerOfHanoi(pegs, numRings-1, fromPeg, auxPeg, toPeg);//move fromPeg to auxPeg using toPeg

        int ring = pegs[fromPeg].removeFirst();
        pegs[toPeg].addFirst(ring);
        print(pegs);

        solveTowerOfHanoi(pegs, numRings-1, auxPeg, toPeg, fromPeg); //move from auxPeg to toPeg using auxPeg
    }

    static void print(Deque<Integer>[] pegs){
        for (Deque<Integer> peg: pegs){
               Iterator it =  peg.iterator();
               while (it.hasNext()){
                   System.out.print(it.next()+" ");
               }
            System.out.print(" | ");
        }
        System.out.println();
    }
}
