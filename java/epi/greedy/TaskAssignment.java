package epi.greedy;

import java.util.Arrays;

public class TaskAssignment {
    //There are tasks of random lengths, each worker can be assigned 2 tasks. Assign so that the task completes soonest
    public static void main(String[] args){
        int[] tasks = {5,2,1,6,4,4};
        int[][] assignment = getTaskAssignment(tasks);
        for(int i = 0 ; i < assignment.length; i++){
            System.out.println(assignment[i][0]+", "+assignment[i][1]);
        }

    }

    //simply group a smallest and largest tasks together -
    // Time complexity - O(n log n), space: O(1)
    static int[][] getTaskAssignment(int[] tasks){
        Arrays.sort(tasks);
        int[][] assignment = new int[tasks.length/2][];
        for(int i = 0 ; i < tasks.length/2; i++){
            int[] task = {tasks[i], tasks[tasks.length -1-i] };
            assignment[i] = task;
        }
        return assignment;
    }
}
