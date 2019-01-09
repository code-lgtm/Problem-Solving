package epi.greedy;


import java.util.Arrays;

public class ThreeSumProblem {
    //Find three numbers adding to a given sum in O(n^2) time and O(1) space. Same number can be picked more than ones

    public static void main(String[] args){
        int[] ip = {11,2,5,7,3};
        int[] triplet = get3Sum(ip, 21);
        System.out.println(triplet==null?"No triplet found":triplet[0]+" "+triplet[1]+" "+triplet[2]);
        triplet = get3Sum(ip, 22);
        System.out.println(triplet==null?"No triplet found":triplet[0]+" "+triplet[1]+" "+triplet[2]);

        /*
        Output:
        3 7 11
        No triplet found
         */
    }

    static int[] get3Sum(int[] ip, int sum){
        int[] triplet = new int[3];
        Arrays.sort(ip);
        for (int i: ip){
            int[] twoSum;
            if((twoSum = get2Sum(ip, (sum - i)))!= null){
                triplet[0]= i;
                triplet[1] = twoSum[0];
                triplet[2] = twoSum[1];
                return triplet;
            }
        }

        return null;
    }

    //O(n)
    static int[] get2Sum(int[] ip, int sum){
        int[] twoSum = new int[2];

        int left = 0, right = ip.length-1;

        while(left<= right){
            if (ip[left] + ip[right] == sum){
                twoSum[0] = ip[left];
                twoSum[1] = ip[right];
                return twoSum;
            }else if(ip[left] + ip[right] < sum){
                left++;
            }else {
                right--;
            }
        }

        return null;
    }

}
