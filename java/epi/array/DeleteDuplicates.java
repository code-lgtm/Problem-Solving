package epi.array;

//Delete Duplicates from a sorted array - O(n) time, O(1) space
public class DeleteDuplicates {

    public static void main(String[] args){
        int[] ip = {1,1,1,2,3,3,4,4,4,4,5,5,6};
        int[] ip2 = {7,8,9,10,11,11,11,11};
        int n = removeDups(ip);
        for (int i = 0; i <= n;i++){
            System.out.print(ip[i]+" ");
        }
        System.out.println();
        n = removeDups(ip2);
        for (int i = 0; i <= n;i++){
            System.out.print(ip2[i]+" ");
        }

        /*
        Output:

        1 2 3 4 5 6
        7 8 9 10 11
         */
    }

    static int removeDups(int[] ip){
        int left = 0, right = 1;

        for (;right<ip.length; right++){
            if(ip[left] != ip[right]){
                ip[++left] = ip[right];
            }
        }

        return left;
    }
}
