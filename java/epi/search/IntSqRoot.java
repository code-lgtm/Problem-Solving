package epi.search;

public class IntSqRoot {

    //find the int sq root in log n time
    public static void main(String[] args){

        System.out.println(intSqRoot(16, 0, 16));
        System.out.println(intSqRoot(21, 0, 21));
        System.out.println(intSqRoot(30, 0, 30));
        System.out.println(intSqRoot(25000, 0, 25000));

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
