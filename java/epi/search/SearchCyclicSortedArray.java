package epi.search;

//find the min value in the rotated array in log n time
public class SearchCyclicSortedArray {
    public static void main(String[] args){

        int[] ip = {5,6,7,8,9,1,2,3,4};
        int val = findMin(ip, 0, ip.length-1);
        System.out.println(val);

    }
    static int findMin(int[] ip, int min, int max){
        if(min > max){
            return -1;
        }
        int mid = min + (max-min)/2;
        if(min ==  max){
            return ip[min];
        }else if(ip[mid] > ip[max]){//number lies in the right half
            return findMin(ip, mid+1, max);
        }else{//number lies in the left half
            return findMin(ip, min, mid-1);
        }
    }

}
