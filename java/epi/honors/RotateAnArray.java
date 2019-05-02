package epi.honors;

//Rotate an array to the right by k elements in O(n) time and O(1) space
public class RotateAnArray {

    public static void main(String[] args){
        int[] ip = {5,-1,7,9,11,15,2};
        int[] ip2 = {1,2,3,4,5,6,7,8,9,0};
        int k = 3;

        rotate(ip, k);
        printAry(ip);
        rotate(ip2, k);
        printAry(ip2);

        /*
        Output:
        11 15 2 5 -1 7 9
        8 9 0 1 2 3 4 5 6 7

         */
    }

    static void rotate(int[] ip, int k){

        int curInd = 0, curVal = ip[curInd], cnt = 0;
        while (cnt < ip.length){

            int destInd =curInd + k;
            if(destInd >= ip.length){
                destInd = (destInd % ip.length);
            }
            int destValTemp = ip[destInd];
            ip[destInd] = curVal;
            curInd = destInd;
            curVal = destValTemp;

            cnt++;
        }

    }

    /****************/
    static void printAry(int[] ary){
        for (int j = 0; j < ary.length; j++){
            System.out.print(ary[j]+" ");
        }
        System.out.println();
    }
}
