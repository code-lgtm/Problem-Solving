package epi.array;

//add one to a given Precision int avoiding overflow rollover
public class AddPrecisionIntegers {
    public static void main(String[] args){
        int[] num = {0,9,9,9};//keeping an additional space at the most significant place
        int[] result = addOne(num);
        for (int i: result){
            System.out.print(i);
        }

        //Output: 1000
    }

    static int[] addOne(int[] num){

        int carry = 0;
        for (int i =num.length-1; i >= 0; i--){

            int digit = num[i];
            if(i == num.length-1){
                digit += 1;//adding one
            }

            digit += carry;

            if(digit >= 10){
                carry = digit/10;
                digit = digit%10;
            }else{
                carry = 0;
            }

            num[i] = digit;

        }

        return num;
    }
}
