package epi.string;

import java.util.ArrayList;
import java.util.List;
//SinosoidalStringPrint
public class SinosoidalStringPrint {
    public static void main(String[] args){
        char[] ip = "HelloWorld".toCharArray();
        sinosoidalPrint(ip);
        /*
        Output:
            e                W                d
H        l        o        o        l
             l                 r
         */
    }

    static void sinosoidalPrint(char[] ip){
        List<Character> first = new ArrayList<>(), second = new ArrayList<>(), third = new ArrayList<>();
        for (int i=0; i < ip.length; i++){
            if(i % 2 == 0){
                second.add(ip[i]);
            }else if( (i-1) % 4 == 0){
                first.add(ip[i]);
            }else if( (i - 3) % 4 == 0){
                third.add(ip[i]);
            }
        }
        System.out.print("    ");
        for (char c: first){
            System.out.print(c+"                ");
        }
        System.out.println();
        for (char c: second){
            System.out.print(c+"        ");
        }
        System.out.println();
        System.out.print("             ");
        for (char c: third){
            System.out.print(c+"                 ");
        }
    }
}
