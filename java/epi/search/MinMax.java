package epi.search;

//Find the min and max of an unsorted string in less than (2n -1) comparisions on O(n) time and O(1) space. n is even
public class MinMax {

    public static void main(String[] args){
        int[] ip = {3,2,5,1, 2,4};
        int[] minMax = getMinMax(ip);
        System.out.println(minMax[0]+" "+minMax[1]);
        //output: 1 5
    }

    static int[] getMinMax(int[] ip){

        /*
        The idea is the use disjoint set, basically we can divided n items into two sets of n/2 items each
        Then it will take n/2-1 comparisions to find min from min set (as max cannot be there) and
        n/2 - 1 comparisions to find max from max set
        so Total (3n/2  -  1 ) comparisions
        further we can just keep tempMin and tempMax of the sets (treat i/p like stream) to avoid O(n) space
         */

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i = 0; i < ip.length-1; i += 2){
            int tempMin, tempMax;
            if(ip[i] > ip[i+1]){
                tempMin = ip[i+1];
                tempMax = ip[i];
            }else{

                tempMin = ip[i];
                tempMax = ip[i+1];
            }

            if(tempMin < min){
                min = tempMin;
            }

            if( tempMax > max){
                max = tempMax;
            }
        }

        int[] minMax = {min, max};
        return minMax;
    }

}
