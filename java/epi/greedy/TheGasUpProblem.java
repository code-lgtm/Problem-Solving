package epi.greedy;

public class TheGasUpProblem {
    //Complete a tour of cities on a circular road after filling gas at each city (should not run out of gas) in Time: O(n) Space O(1)
    //The obvious greedy idea of starting from a city with most gas:distance ratio doesn't work
    //The solution is start from any city and find a city where you are at the most gas defisit. This should be the starting city: Page 326 EPI

    static int millage = 20;//20 miles per gallon
    public static void main(String[] args){
        char[] city = {'A','B','C','D','E','F','G'};
        int[] gas = {50, 20, 5, 30, 25, 10, 10};
        int[] distance = {900,600,200,400,600,200,100};
        //the representation is: city A has 50 gallon of gas and next city is 900 miles away

        char startingCity = getStartingCity(city, gas, distance);
        System.out.println("Start from city: "+startingCity);

    }
//Time: O(n) Space O(1)
    static char getStartingCity(char[] city, int[] gas, int[] distance){
        char startingCity = city[0];
        int startingGas = 0;

        //start from first city and find the city with max deficit
        int gasLeft = 0;
        for (int i = 1; i < city.length; i++){
            gasLeft =    (gas[i-1] + gasLeft) - (distance[i-1]/millage);
            if(gasLeft < startingGas){
                startingGas = gasLeft;
                startingCity = city[i];
            }
        }
        return startingCity;
    }
}
