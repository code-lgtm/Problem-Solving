package epi.search;

public class ValueEqualsIndex {

    //find a number which is qual to it's index in log n time
    public static void main(String[] args){
        int[] ip = {-10, -7 , -2, 0, 1, 5, 8, 12, 100};
        int num = findNum(ip, 0, ip.length);
        System.out.println(num);

        //output: 5
    }

    static int findNum(int[] ip, int min, int max){
        if(min > max){
            return -1;
        }
        int mid = min + (max-min)/2;//avoiding overflow error
        if(ip[mid] == mid) {
            return ip[mid];
        }else if(ip[mid] > mid){//go left
            return findNum(ip, min, mid-1);
        }else {
            return findNum(ip, mid+1, max);
        }
    }
}
