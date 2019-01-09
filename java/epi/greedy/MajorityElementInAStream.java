package epi.greedy;

public class MajorityElementInAStream {
    //given a stream find a character which occupies at least half of the stream in O(n) time and O(1) space

    public static void main(String[] args){
        char[] stream = {'b','a','c','a','a','b','a','a','c','a'};
        System.out.println("Majority: "+getMajor(stream));
        //Majority: a
    }

    //The idea is as the majority char occupies more than half of the stream, value of rep in the below code would be > 0
//O(n) time and O(1) space
    static char getMajor(char[] stream){
        char candidate = '\n';
        int rep = 0;

        for(char cur: stream){
            if(rep == 0){
                rep++;
                candidate = cur;
            }else if( candidate == cur){
                rep++;
            }else {
                rep--;
            }
        }

        return candidate;
    }
}
