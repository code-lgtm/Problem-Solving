package epi.greedy;

public class MaxWaterTrapping {

    public static void main(String[] args){
        //pole[i] is height of the pile @ i in meters, also i and i+1 are 1 meter apart. Find the max area of water which can be trapped between two poles
        int[] poles = {1,2,1,3,4,4,5,6,2,1,3,1,3,2,1,2,4,1};
        System.out.println("Max water: "+getMaxWater(poles));
/*
Output:
Poles selected: 4  4
Index selected: 4  16
Max water: 48
 */
    }

    //O(n) time and O(1) space
    static int getMaxWater(int[] poles){
        int max = Integer.MIN_VALUE;
        int left = 0,  right = poles.length-1;
        int pole1 = -1, pole2 = -1;

        while (left < right && left>=0 && right <= poles.length-1){
            int curArea = Math.min(poles[left], poles[right]) * (right - left);
            if(curArea > max){
                max=curArea;
                pole1=left;
                pole2 = right;
            }

            if (poles[left] > poles[right]){
                right--;
            }else if(poles[left] < poles[right]){
                left++;
            }else{
                left++;
                right--;
            }
        }

        System.out.println("Poles selected: "+poles[pole1]+"  "+poles[pole2]);
        System.out.println("Index selected: "+pole1+"  "+pole2);;
        return max;
    }

}
