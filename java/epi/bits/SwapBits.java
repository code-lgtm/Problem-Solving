package epi.bits;
//Swap ith and jth Bits of a 64bit int
public class SwapBits {

    public static void main(String[] args){
        System.out.println(swap(5l,0, 20));
        //Output: 1048580
    }

    static long swap(long n, int i, int j){

        //Check if ith and jth bits are different, else swap isnt needed
       if ( ( n & (1 << i ) ) != ( n & (1 << j ) ) ){

           long bitMask = (1L << i) | (1L << j); // basically we need a long with ith and jth bits set

           n = n^bitMask; //XORING with 1 reverses the bit, logically performing swaping

       }

        return n;
    }

}
