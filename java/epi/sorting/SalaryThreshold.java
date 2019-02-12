package epi.sorting;

import java.util.Arrays;

/*

Design an algo to find a salary cut so that the salary of the emps can be reduced to fit inside a budget - Time complexity O(n log n) space O(1)

if there were five employees with salaries last year were
$90,$30,$100,$40, and $20, and the target payroll this year is $210, then 60 is a
suitable salary cap, since 60 + 30 + 60 + 40 + 20 = 210.
 */
public class SalaryThreshold {
    public static void main(String[] args){
        int budget = 210;
        int[] salaries = {90,30,100,40,20};
        int cap = getCap(salaries, budget);
        System.out.print(cap);
        //Output: 60
    }

    static int getCap(int[] salaries, int budget){

        Arrays.sort(salaries);
        int currentTotal = 0;
        for (int salary: salaries){
            currentTotal += salary;
        }

        if (currentTotal <= budget){
            return -1;//no salary cut is req
        }

        int totalEmps = salaries.length;
        int currentEx = 0;
        for (int i = 0; i < totalEmps; i++){

            if((budget - currentEx)%(totalEmps -i) == 0){// a cut can potentially be applied to the remaining salaries
                int salaryThreshold = (budget - currentEx)/(totalEmps -i);
                if(salaries[i] > salaryThreshold){//then we will limit the salary to salaryThreshold
                    return salaryThreshold;
                }
            }

            currentEx += salaries[i];
        }

        return -1;

    }
}
