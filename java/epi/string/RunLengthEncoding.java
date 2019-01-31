package epi.string;

//Implement RunLengthEncoding
public class RunLengthEncoding {
    public static void main(String[] args){
        System.out.println(encode("aaaabcccaa".toCharArray()));
        System.out.println(encode("aaaabcccaad".toCharArray()));
        /*
        Output:
        4a1b3c2a
        4a1b3c2a1d
         */
    }

    static String encode(char[] ip){
        StringBuffer enc = new StringBuffer();

        for (int i=0; i < ip.length-1; i++){
            int cnt = 1;
            while (i < ip.length-1 && ip[i] == ip[i+1]){
                i++;
                cnt++;
            }
            enc.append(cnt);
            enc.append(ip[i]);
        }

        if(ip[ip.length-1] != ip[ip.length-2]){//for the inputs where there is a single occurence of unique char at the last
            enc.append(1);
            enc.append(ip[ip.length-1]);
        }

        return enc.toString();
    }
}
