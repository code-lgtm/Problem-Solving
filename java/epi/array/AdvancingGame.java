package epi.array;

//A[i] represents the places you can jump from i, check if a player can reach the end - Time O(n), Space O(1)
public class AdvancingGame {

    public static void main(String[] args){
        int[] game1 = {3,3,1,0,2,0,1};
        int[] game2 = {3,2,0,0,2,0,1};
        System.out.println(canAdvance(game1));
        System.out.println(canAdvance(game2));

        /*
        Output:

        true
        false

         */
    }

    static boolean canAdvance(int[] game){
        int maxReach = 0;
        for (int i = 0 ; i < game.length; i++){
            if(i <= maxReach){//if maxReach < i then the player cant even reach the position i
                maxReach = Math.max(maxReach, i+game[i]);
            }else{
                return false;
            }
        }

        return maxReach >= game[game.length-1];//see if the player could reach the edn
    }
}
