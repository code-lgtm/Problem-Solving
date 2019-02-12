package epi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Find the maxNumber of overlapping calendar events in O(n log n) time and O(n) space
public class MaxCalendarEvents {

    static class Event implements Comparable<Event>{
        int time;
        boolean isStart;
        Event(int time, boolean isStart){
            this.time = time;
            this.isStart = isStart;
        }

        public int compareTo(Event e){//for sorting in the increasing order
            return this.time - e.time;
        }

        //Output: 4
    }

    public static void main(String[] args){

        int[][] events = {
                {1,5}, {6,10},{11,13},{14,15},
                {2,7}, {8,9}, {12,15} , {4,5},{9,17}, {3,4}
        };

        int maxOverlapping = getMaxOverlapping(events);

        System.out.print(maxOverlapping);

    }

    static int getMaxOverlapping(int[][] events){
        int maxOverlapping = 0;
        int runningOverlapping = 0;

        List<Event> eventList = new ArrayList<>();

        for (int[] event: events){//break the events into start time and end times, marking isStart flag
            eventList.add(new Event(event[0], true));
            eventList.add(new Event(event[1], false));
        }

        Collections.sort(eventList);//sort in the increasing order of start times

        for (Event e: eventList){
            //iterate the list and increase the runningOverlapping whenever an event starts, and decrease it when an event ends
            //it's max value will be the max number of overlapping events

            if(e.isStart){
                runningOverlapping++;
                maxOverlapping = runningOverlapping > maxOverlapping?runningOverlapping:maxOverlapping;
            }else{
                runningOverlapping--;
            }

        }



        return maxOverlapping;
    }

}
