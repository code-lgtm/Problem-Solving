package epi.array;

import java.util.Random;

//Randomly sample k elements put of n elements, when n cannot fit in main memory - Time complexity O(n), space O(k)
public class OnlineSampling {
//https://www.geeksforgeeks.org/reservoir-sampling/

    public static void main(String[] args) {

        int[] stream = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int k = 5;
        int[] sample = getRandomSample(stream, k);

        for(int i: sample){
            System.out.print(i+ " ");
        }

        //Output: 8 2 11 10 9

    }


    static int[] getRandomSample(int[] stream, int k){
        int[] sample = new int[k];

        Random ran = new Random();
        for (int i = 0; i<stream.length; i++) {

            //copy the first k elements in the sample set
            if(i < k-1){
                sample[i] = stream[i];
            }else{//k elements are copied, now generate a random number <= i, if rand < k then replace sample[rand] with stream[i]; thus randomply copying elements from the stream
                int rand = ran.nextInt(i);
                if(rand < k){
                    sample[rand] = stream[i];
                }
            }
        }
        return sample;
    }
}
