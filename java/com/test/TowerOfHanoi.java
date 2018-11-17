package com.test;

public class TowerOfHanoi {
/*
Resources:
https://www.youtube.com/watch?v=feMjUx_9opU
https://www.mathsisfun.com/games/towerofhanoi.html
https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
 */
    public static void main(String[] args){
        int numberOfDisks = 3;
        printHanoiSolution(numberOfDisks, "A", "C", "B");
    }

    static void printHanoiSolution(int diskCnt, String fromTower, String toTower, String auxTower){

        if(diskCnt == 1){
            System.out.println("Moving Disk "+diskCnt+" from "+fromTower+" -> "+toTower);
            return;
        }

        printHanoiSolution(diskCnt-1, fromTower, auxTower, toTower);
        System.out.println("Moving Disk "+diskCnt+" from "+fromTower+" -> "+toTower);
        printHanoiSolution(diskCnt-1, auxTower, toTower, fromTower);

    }

}
