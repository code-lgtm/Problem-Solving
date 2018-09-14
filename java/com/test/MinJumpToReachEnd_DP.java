package com.test;

public class MinJumpToReachEnd_DP {
    /*
    Given an array having number of jumps which can be taken from a given index, compute the min jump required
    Desc:  https://www.youtube.com/watch?v=cETfFsSTGJI
     */
    public static void main(String[] args){

        int[] ip = {2,3,1,1,2,4,2,0,1,1};

        getMinJumps(ip);


    }

    private static void getMinJumps(int[] ip){
        int[] minSteps = new int[ip.length];

        for(int i=1; i < ip.length ; i++){
            minSteps[i] = Integer.MAX_VALUE-1;
        }

        for(int i= 1; i < ip.length; i++){
            for(int j = 0; j < ip.length; j++){

                //check if i is reachable from j, if yes, then put the min distance in minSteps[i]
                if(j+ ip[j] >= i){//is reachable?
                    if((minSteps[i] > minSteps[j] + 1 )){//if this step is taken then is that the min yet
                        minSteps[i] = minSteps[j] + 1;
                    }
                }

            }
        }

        System.out.println(minSteps[minSteps.length-1]);

    }

}
