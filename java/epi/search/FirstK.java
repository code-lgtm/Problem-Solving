package epi.search;


//find the first occurrence of K, input is a sorted array in log n time
public class FirstK {

    public static void main(String[] args){
        int[] ip = {1,2,3,4,5,5,5,5,5,5,5,5,5,6,7,8,9};
        int ind = findFirstK(ip, 5, 0, ip.length);
        System.out.println(ind);
        //Output: 4
    }

    static int findFirstK(int[] ip, int k, int min, int max){

        if(min>max){
            return -1;
        }
        int mid = (min+max)/2;
        if (ip[mid] == k && (mid == 0 || ip[mid-1] != k)){// the previous number isn't k
            return mid;//found the index
        }else if(ip[mid] == k){// no need to go right , as the first occurence will be on the left
            return findFirstK(ip, k, 0, mid-1);
        }else{
            int left = findFirstK(ip, k, 0, mid-1);
            int right = findFirstK(ip, k, mid+1, max);
            if(left!= -1 || right!= -1){
                return left == -1? right:left;
            }
        }
        return -1;
    }

}
