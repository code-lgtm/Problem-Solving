package epi.dp;

//Solve the coin game. Player 1 starts the game by picking a coin from either two end indices such that he gets the max number of coins
//time O(coin^2 * numberOfPlayers) = O(coin^2) as numberOfPlayers is constant = 2
//space O(coin^2)
public class CoinPickGame {
    static class Score{
        int firstPick;
        int remainingAfterFirstPick; //this is what the second player gets
        Score(int firstPick, int remainingAfterFirstPick){
            this.firstPick = firstPick;
            this.remainingAfterFirstPick = remainingAfterFirstPick;
        }
        Score(){}
    }

    public static  void main(String[] args) {

        int[] coins = {3, 9, 1, 2};

        Score playerScores = getScore(coins);

        System.out.println("Player1 gets: "+playerScores.firstPick+", second gets: "+playerScores.remainingAfterFirstPick);

        /*
        Output:
(3,0) (9,3) (4,9) (11,4)
(0,0) (9,0) (9,1) (10,2)
(0,0) (0,0) (1,0) (2,1)
(0,0) (0,0) (0,0) (2,0)
Player1 gets: 11, second gets: 4
         */
    }

    static Score getScore(int[] coins){
        int totalCoins = coins.length;

        Score[][] auxScore = new Score[totalCoins][totalCoins];

        for (int i=0; i<totalCoins; i++) {
            for (int j = 0; j < totalCoins; j++) {
                auxScore[i][j] = new Score(0, 0);
            }
        }


        //Seed the data for the condition when just one coin is present, player1 picks it and the second player is left with nothing
        for (int i=0; i<totalCoins; i++){
            auxScore[i][i] = new Score(coins[i], 0);// so for example auxScore[1][1] implies that when number from index 1 to 1 was picked (including both)
        }


        //this loop start picking chars from digits onwards
        for (int i=1; i<totalCoins; i++){
            for (int j=0; j<totalCoins-i; j++){

                Score curScore = new Score();

                //initialize the start and end index pairs
                int sInd = j;
                int eInd = j+i;

                //player1's chance, he either picks coin at sInd or eInd

                int scoreSInd = coins[sInd] + auxScore[sInd+1][eInd].remainingAfterFirstPick; // basically player1 gets a score of coins[sInd], plus whatever is remaining after the first coin was picked and this subproblem would have been already solved
                int scoreEInd = coins[eInd] + auxScore[sInd][eInd-1].remainingAfterFirstPick; // similarly if the player picks the coin at eInd

                if (scoreSInd >= scoreEInd){//pick the coin at the starting index
                    curScore.firstPick = scoreSInd;
                    sInd++;//remove the coin from second player's consideration
                }else {
                    curScore.firstPick = scoreEInd;
                    eInd--;//remove the coin from second player's consideration
                }

                //Now it's second player's turn he applies the same logic as above on the remaining coins in the current subset
                scoreSInd = coins[sInd] + ( (sInd == eInd) ? 0 : auxScore[sInd+1][eInd].remainingAfterFirstPick);//using (sInd == eInd) check because there was just one element left which was picked
                scoreEInd = coins[eInd] + ( (sInd == eInd) ? 0 : auxScore[sInd][eInd-1].remainingAfterFirstPick);

                if (scoreSInd >= scoreEInd){//pick the coin at the starting index
                    curScore.remainingAfterFirstPick = scoreSInd;
                }else {
                    curScore.remainingAfterFirstPick = scoreEInd;
                }

                auxScore[j][j+i] = curScore;

            }
        }

        printMat(auxScore);

        return auxScore[0][auxScore[0].length-1];// return the top right score
    }

    private static void printMat(Score[][] mat){
        for(int i=0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                Score cur = mat[i][j];
                System.out.print("("+cur.firstPick +","+cur.remainingAfterFirstPick+") ");
            }
            System.out.println();
        }
    }
}
