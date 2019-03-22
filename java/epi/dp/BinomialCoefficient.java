package epi.dp;

import java.util.ArrayList;

//Get kth Binomial Coefficient of nth row - Time (row^2) space- O(row)
/*
Pascle triangle:

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1

So for example 3rd coef of 5th row = 6
 */
public class BinomialCoefficient {
    public static void main(String[] args){
        int row = 5;
        int k = 3;
        int coef = getbinCoef(row, k);

       System.out.print(coef);

       //Output: 6

    }

    static int getbinCoef(int row, int k){

        if(row<1 || k<1 || k>row){
            return -1;
        }

        ArrayList<Integer> pascleRow = new ArrayList<>();
        pascleRow.add(1);//first value of pascle triangle

        for (int i = 0; i < row-1; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j=0; j< pascleRow.size()-1; j++){
                temp.add(pascleRow.get(j) + pascleRow.get(j+1));
            }
            temp.add(1);
            pascleRow = temp;

        }
        return pascleRow.get(k-1);
    }
}
