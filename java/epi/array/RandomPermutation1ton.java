package epi.array;

import java.util.Random;

//similar to OfflineSampling problem, compute a random permuted string have all the elements from 1 to n in O(n) time and O(1) aux space
public class RandomPermutation1ton {

    public static void main(String[] args) {

        int k = 10;//Random permutation from 1 - 10

        int[] randomPerm = getRandPem(k);
        for (int i: randomPerm){
            System.out.print(i+ " ");
        }
//Output: 7 3 1 2 4 9 6 10 5 8

    }


    static int[] getRandPem(int k){
        int[] randomPerm = new int[k];

        //simply create an array which will be permuted later
        for(int i=0; i < k; i++){
            randomPerm[i] = i+1;
        }


        Random ran = new Random();
//shuffle the array
        for(int i=0; i < k; i++){
            int rand = ran.nextInt(randomPerm.length);
            //swap the rand int with ith int

            int temp = randomPerm[i];
            randomPerm[i]=randomPerm[rand];
            randomPerm[rand] = temp;
        }

        return randomPerm;

    }
}
