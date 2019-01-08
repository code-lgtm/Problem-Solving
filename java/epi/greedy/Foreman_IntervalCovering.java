package epi.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Foreman_IntervalCovering {
    //Given Tasks with start and end time, find out the minimum number of visit (and their times) which the foreman take to confirm if the tasks are running

    static class Task{
        int start, end;
        Task(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args){
        List<Task> tasks = new ArrayList<Task>();
        tasks.add(new Task(2,6));
        tasks.add(new Task(0,3));
        tasks.add(new Task(6,9));
        tasks.add(new Task(3,4));
        tasks.add(new Task(12,18));
        tasks.add(new Task(17,20));

        List<Integer> visits = getMinVisits(tasks);
        System.out.println("Number of Min visit required:  "+visits.size());
        for (Integer visit: visits){
            System.out.print(visit+" ");
        }

        /*
        Output:
        Number of Min visit required:  3
        3 9 18
         */
    }

//Time complexity: O(tasks) . Space complexity O(tasks) in the worst case if there is one visit per task
    static List<Integer> getMinVisits(List<Task> tasks){
        /*
        The Idea is to sort the intervals by their end times
        now take a end time and see how many interval it can cover in the sorted interval list
        if we get a task beyond coverage then we move to it's end point and iterate further
        This idea gives the min possible visit required
         */


        List<Integer> visits = new ArrayList<Integer>();
        //sort the tasks by ascending order of their occurrence
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.end - o2.end;
            }
        });

        int currentVisit = Integer.MIN_VALUE;
        for (Task task: tasks){
            if(! (currentVisit>= task.start && currentVisit <= task.end)){
                currentVisit = task.end;//get the right most point. In the further iteration all the Tasks overlapping this point will be covered, hence minimizing the visits
                visits.add(currentVisit);
            }
        }


        return visits;
    }

}
