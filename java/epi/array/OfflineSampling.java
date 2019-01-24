package epi.array;

import java.util.Random;

//Similar to the onlinesample problem, pick k random numbers from a pre populated array (instead of a stream) - Tome complexity O(n) space O(1)
public class OfflineSampling {

    public static void main(String[] args) {

        int[] offlineData = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int k = 5;
        getSample(offlineData, k);

        for(int i=0; i < k; i++){
            System.out.print(offlineData[i]+ " ");
        }

        //Output: 8 5 2 11 12

    }

    static void getSample(int[] offlineData, int k){

        Random ran = new Random();

        for(int i=0; i < k; i++){
            int rand = ran.nextInt(offlineData.length);
            //swap the rand int with ith int

            int temp = offlineData[i];
            offlineData[i]=offlineData[rand];
            offlineData[rand] = temp;
        }


    }


}
