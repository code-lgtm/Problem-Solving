package epi.array;

import java.util.ArrayList;
import java.util.List;

//generate n rows of pascal triangle
public class PrintPascalTriangle {

    static int rows  = 6;

    public static void main(String[] args) {
        printPascalTriangle(rows);
    }

    static void printPascalTriangle(int rows){

        List<Integer> oldRow = new ArrayList<>(), curRow ;
        oldRow.add(1);//seed data

        for (int i = 1 ; i <= rows; i++){
            curRow = new ArrayList<>();
            if(i == 1){
                print(oldRow);
            }else{
                curRow.add(1);
                for (int ind=0; ind < oldRow.size()-1;ind++){
                    int sum = oldRow.get(ind) + oldRow.get(ind+1);
                    curRow.add(sum);
                }
                curRow.add(1);
                print(curRow);
                oldRow = curRow;
            }
        }

    }

    static void print(List<Integer> row){
        for(int i: row){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
