package epi.recursion;

//Permute an array - Time O(n * n!)
public class AryPermute {
    public static void main(String[] args){
        int[] ary = {1,2,3};
        aryPermute(ary, 0);
    }

    static void aryPermute(int[] ary, int fix){
        if(fix == ary.length){
            print(ary);
            return;
        }

        for (int i = fix;i < ary.length; i++){
            swap(ary, fix, i);
            aryPermute(ary, fix+1);
            swap(ary, fix, i);//backtrack

        }
    }

    static void swap(int[] ary, int i, int j){
        int temp = ary[i];
        ary[i] = ary[j];
        ary[j] = temp;
    }

    static void print(int[] ary){
        for (int i: ary){
            System.out.print(i +" ");
        }
        System.out.println();
    }
}
