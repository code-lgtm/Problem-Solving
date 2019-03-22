package epi.dp;

//Find the number of ways 12 can be scored if the possible scores are 2, 3 and 7 - Time and space (sum * scores)
/*
There are 4 ways
2*6 = 12
3*4 = 12
2*3 + 3*2 = 12
2*1 + 3*1 + 7*1 = 12
 */
public class ScoreSumProblem {

    public static void main(String[] args){
        int sum = 12;
        int[] scores = {2,3,7};
        int ways = getWays(sum, scores);
        System.out.println("Number of ways: "+ways);
        /*
        1 0 0 0 0 0 0 0 0 0 0 0 0
        1 0 1 0 1 0 1 0 1 0 1 0 1
        1 0 1 1 1 1 2 1 2 2 2 2 3
        1 0 1 1 1 1 2 2 2 3 3 3 4
        Number of ways: 4
         */
    }

    static int getWays(int sum, int[] scores){

        int[][] auxMat = new int[scores.length+1][sum+1];//taking one additional row and column

        for (int i = 0; i < auxMat.length; i++){
            auxMat[i][0] = 1;//Implies that the sum of 0 can be achieved of any score combination in one way
        }

        for (int col = 1;col <= sum; col++) {
            for (int row = 1; row <= scores.length; row++) {

                int curScore = scores[row-1];

                int withOutCurrentScore = auxMat[row-1][col];//value from the row above, as atleast we can get that number of ways the compose the curSum
                int currentScoreWays = 0;
                if(col-curScore >=0){//is there any additional way to compose the sum after introducing the current score?
                    currentScoreWays = auxMat[row][col-curScore];
                }
                //Now, the total ways to compose the current sum will be ways withOutCurrentScore + currentScoreWays
                auxMat[row][col] = withOutCurrentScore + currentScoreWays;
            }
        }

        printMat(auxMat);

        return auxMat[auxMat.length-1][auxMat[0].length-1];
    }

    static void printMat(int[][] mat){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
