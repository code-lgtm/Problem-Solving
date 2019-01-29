package epi.string;

//Permute a string - Time O(n* n!) [n! for the recursion and n for println method ]- Space O(n)
public class Permute {
    public static void main(String[] args){
        char[] pat = {'M', 'A', 'N'};
        permute(pat, 0);
    }


    static void permute(char[] pat, int fix){
        if(fix == pat.length -1){
            System.out.println(pat);
            return;
        }

        for (int i = fix; i < pat.length; i++){
            swap(pat, fix, i);
            permute(pat, fix+1);
            swap(pat, fix, i);//backtrack
        }
    }

    static void swap(char[] pat, int x, int y){
        char temp = pat[x];
        pat[x] = pat[y];
        pat[y] = temp;
    }
}
