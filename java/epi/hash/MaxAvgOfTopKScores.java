package epi.hash;

import javax.swing.*;
import java.util.*;

//Given a file of with student# and their scores, find the top score of the average of top K scores
//Timecomplexity: O(n log k) = O(n) when k is very small like avg of top 3 scores. Space = O(m) - m is the count of unique students
public class MaxAvgOfTopKScores {
    static final int k = 3;
    static class Score{
        String id;
        int score;
        Score(String name, int score){
            this.id = name;
            this.score = score;
        }
    }
    public static void main(String[] args){
        List<Score> file = new ArrayList<>();
        file.add(new Score("Student2", 100));
        file.add(new Score("Student1", 90));
        file.add(new Score("Student2", 90));
        file.add(new Score("Student2", 80));
        file.add(new Score("Student2", 70));
        file.add(new Score("Student1", 80));
        file.add(new Score("Student1", 70));
        file.add(new Score("Student3", 100));

        System.out.println(getMaxScore(file));

       /*
       Output:
             Student2
             90
        */
    }

    static int getMaxScore(List<Score> file){
        int max = -1;
        //this map will store StudentId:Top-K-Scores mapping. Using a min heap will help us store just Top K scores
        Map<String, PriorityQueue<Integer>> scores = new HashMap<String, PriorityQueue<Integer>>();

        for (Score scr: file){//maintains student id: top 3 scores
            if (scores.containsKey(scr.id)){
                PriorityQueue<Integer> minHeap = scores.get(scr.id);
                minHeap.add(scr.score);
                if(minHeap.size() > k){//drop the min element if size has exceeded k
                    minHeap.poll();
                }
            }else {
                PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
                minHeap.add(scr.score);
                scores.put(scr.id, minHeap);
            }
        }

        //Simply iterate the map to get the max
        String student = null;
        for (String key: scores.keySet()){
            PriorityQueue<Integer> scrHeap = scores.get(key);
            if(scrHeap.size() == k){//ignore the students with < k scores
                int sum = 0;
                while (!scrHeap.isEmpty()){
                    sum += scrHeap.poll();
                }
                int avg = sum/k;

                if(avg > max){
                    max = avg;
                    student = key;
                }
            }
        }
        System.out.println(student);
        return max;
    }


}
