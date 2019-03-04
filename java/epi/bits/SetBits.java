package epi.bits;

//Count the number of set bits
public class SetBits {

    public static void main(String[] args){
        System.out.println(getSetBits(1));
        System.out.println(getSetBits(8));
        System.out.println(getSetBits(15));
        System.out.println(getSetBits(Integer.MAX_VALUE));
        System.out.println(getSetBits(Integer.MIN_VALUE));

        /*
        Output:
        1
        1
        4
        31
        0

         */
    }

    public static int getSetBits(int i){
        int cnt = 0;

        while(i > 0){
            cnt += (i & 1);//check if LSB is set
            i = i >>> 1; //logical right shift by one. The difference between >>> and >> is that >>> doesn't care of the sign bit
        }

        return cnt;
    }
}
