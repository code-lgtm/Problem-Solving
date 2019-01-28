package epi.string;

//Encode and decode Excel column names in O(n)
public class ExcelColumnEncodingDecoding {
    public static void main(String[] args){

        System.out.println(decode("AAC"));
        System.out.println(encode(705));

        /*
        Output:
            705
            AAC
         */
    }

    static int decode(String col){
        int dec = 0;
        int mul = 1;

        for (int i = col.length()-1; i >= 0 ; i--){
            int c = col.charAt(i);
            dec += ((c - 'A' + 1) * mul);
            mul *= 26;
        }

        return dec;
    }

    static String encode(int col){
        String num = "";
        while (col > 0 ){
            int colRem = col%26;
            num += ((char)(colRem + 'A' -1));
            col /= 26;
        }

        return new StringBuilder(num).reverse().toString();
    }
}
