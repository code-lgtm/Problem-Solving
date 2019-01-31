package epi.string;

import java.util.Set;
import java.util.TreeSet;

//Generate possible valid IP addresses - Time (2^32) which is O(1) [constant] , same with space
public class ValidIPAddresses {

    public static void main(String[] args){

        printValidIPs("19216811").forEach( ip -> System.out.print(ip + " "));
        System.out.println();
        printValidIPs("10206810").forEach( ip -> System.out.print(ip + " "));

        /*
        Output:
        1.92.168.11 19.2.168.11 19.21.68.11 19.216.8.11 19.216.81.1 192.1.68.11 192.16.8.11 192.16.81.1 192.168.1.1
        10.20.68.10 10.206.8.10 10.206.81.0 102.0.68.10
         */
    }


    static Set<String> printValidIPs(String ip){
        String first, second, third, fourth;
        Set<String> ips = new TreeSet<>();

        for(int i = 0 ; i < ip.length() && i < 3; i++){
            first = ip.substring(0, i+1);
            if(!isValid(first)){continue;}

            for(int j = i+1; j < ip.length() && j < i+1+3; j++){
                second = ip.substring(i+1,j+1);
                if(!isValid(second)){continue;}

                for(int k = j+1; k < ip.length() && k < j+1+3; k++ ){
                    third = ip.substring(j+1, k+1);
                    if(!isValid(third)){continue;}

                    for(int l = k+1; l < ip.length() && l < k+1+3; l++){
                        fourth = ip.substring(k+1, ip.length());
                        if(!isValid(fourth)){continue;}

                        ips.add(first+"."+second+"."+third+"."+fourth);
                    }
                }
            }


        }

        return ips;
    }

    static boolean isValid(String octate){
        Integer intOctate = new Integer(octate);
        if(octate.length()>1 && octate.startsWith("0") || //192.0.1.11 is valid but 192.01.1.1 isnt
                !(intOctate >= 0 && intOctate <= 255) ||
                octate.length() > 3){
            return false;
        }
        return true;
    }

    /*  //Incomplete recurssive solutions
        static void printValidIPs(String ip, String partialIP, int from, int dot){
            if(dot > 4){//discard this value
                return;
            }

            if(partialIP.length() >= ip.length()){
                System.out.println(partialIP);
                return;
            }

            for (int i = from; i < ip.length(); i++){
                for (int j = 1; j <= 3 && i+j < ip.length(); j++){
                    String octate = ip.substring(i, i+j);
                  //  System.out.println(octate);
                    if(isValid(octate) ){
                        partialIP = new String(partialIP +"." + octate);
                        dot++;
                        printValidIPs(ip, partialIP, i+j, dot);
                    }
                }
            }
        }

        /*
        static void printValidIPs(String ip,String partialIP,  int start, int end, int dots){

            if(end == ip.length() && dots == 4){//valid
                System.out.println(partialIP);
                return;
            }else if(end == ip.length() && dots != 4){//discard
                return;
            }
            for (int i = start; i < ip.length(); i+=3 ){
                for (int x = 1; x <= 3 && i+x <= ip.length(); x++){
                    String octate = ip.substring(i, i+x);
                    if(isValid(octate)){
                        partialIP += (octate+".");
                        printValidIPs(ip, partialIP, i+x, i+x, dots+1);
                    }
                }

            }

        }
    */

}
