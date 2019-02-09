package epi.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//find the k closest stars from earth in O(n log k) time and O(k) time, assume earth is at (0,0,0) and you are given the coordinates of the stars. There are 10^12 total stars in the galaxy
public class KClosestStars {

    static class Star{
        int x, y, z;
        String name;
        Star(String name, int x, int y, int z ){
            this.name = name;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        int distance(){//the dance of this planet from earth
            return (int)Math.sqrt(x*x + y*y + z*z);
        }
    }

    public static void main(String[] args){

        List<Star> stars = new ArrayList<>();
        stars.add(new Star("D", 4,4,4));
        stars.add(new Star("E", 5,5,5));
        stars.add(new Star("A", 1,1,1));
        stars.add(new Star("F", 6,6,6));
        stars.add(new Star("C", 3,3,3));
        stars.add(new Star("F", 6,6,6));
        stars.add(new Star("G", 7,7,7));
        stars.add(new Star("B", 2,2,2));

        int k = 3;
        printKClosestStars(stars, k);
        //Output: C B A

    }

    static void printKClosestStars(List<Star> stars, int k){
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, new Comparator<Star>() {
            @Override
            public int compare(Star o1, Star o2) {//return in reverse o
                return o2.distance() - o1.distance();
            }
        });

        maxHeap.add(stars.get(0));
        for(int i = 1; i < stars.size(); i++){
            if(stars.get(i).distance() < maxHeap.peek().distance()){//pool the biggest element from the heap and insert the curent
                maxHeap.add(stars.get(i));
            }

            if(maxHeap.size() == k+1){//we just need to keep k elements in the heap
                maxHeap.poll();//throw away the farther star
            }
        }

        //at this point we are left with k closest stars
        while (!maxHeap.isEmpty()){
            System.out.print(maxHeap.poll().name+" ");
        }

    }


}
