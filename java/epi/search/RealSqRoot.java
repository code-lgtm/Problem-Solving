package epi.search;

//calculate precision sq root - Time complexity O(log n) + O(tolerance) = O(log n) if tolerance is significantly less than n
public class RealSqRoot {
    static int tolerance = 3;//that is tolerance till 0.001
    public static void main(String[] args) {

        System.out.println(realSqRoot(21));
//ouput: 4.582499999999996
    }

    static double realSqRoot(int num){

        double incr = 0.1d;
        double sqRt = intSqRoot(num, 0, num);//get the floor sq root
        for(int i = 0 ; i <= 3; i++){//add the floating point part starting @ .1
            while (sqRt*sqRt <= num){//max 10 iterations here
                sqRt += incr;
            }
            sqRt -= incr;
            incr /= 10d;
        }

        return sqRt;
    }

    static int intSqRoot(int val, int min, int max){

        if(min > max){
            return min-1;
        }

        int mid = min + (max-min)/2;
        int sq = mid*mid;
        if(sq == val){
            return mid;
        }else if(sq > val){//go left
            return intSqRoot(val, min, mid-1);
        }else {//go right
            return intSqRoot(val, mid+1, max);
        }

    }
}
