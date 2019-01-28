package epi.string;

//replace a with dd and delete b from a string in O(n) time and O(1) space, assume that the input array as sufficient blank spaces
public class ReplaceRemove {

    public static void main(String[] args){
        char[] ip = {'a','c','b','a','a','\n','\n'};
        int size = 5;

        replaceRemove(ip, size);
        for(char c: ip){
            System.out.print(c+" ");
        }

        //Output: d d c d d d d
    }

    static void replaceRemove(char[] ip, int size){
        //pass one left to right- delete b
        int cur = 0;
        for (int i = 0 ; i < size; i++){
            if(ip[i] !='b'){
                ip[cur] = ip[i];
                cur++;
            }
        }
        //at this point we will have deleted string till cur-1

        //pass 2  - right to left - copy from left to right
        int left = cur-1, right = ip.length-1;

        while(left >=0){
            if(ip[left] == 'a'){
                ip[right--] = 'd';
                ip[right--] = 'd';
                left--;
            }else{
                ip[right--] = ip[left--];
            }
        }

    }
}
