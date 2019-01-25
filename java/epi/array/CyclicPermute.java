package epi.array;

//Apply a cyclic permutation P to an array A in O(n) time and O(1) space
public class CyclicPermute {

    public static void main(String[] args) {

        //n (2,0,1,3} applied to A = (a,b,c,d}
        int[] per = {2, 0, 1, 3};
        char[] pattern = {'a', 'b', 'c', 'd'};
        char[] perPat = permute(pattern, per);
        for (char c : perPat) {
            System.out.print(c + " ");
        }

        System.out.println();

        int[] per2 = {3, 4, 0, 2, 1};
        char[] pattern2 = {'a', 'b', 'c', 'd', 'e'};
        char[] perPat2 = permute(pattern2, per2);
        for (char c : perPat2) {
            System.out.print(c + " ");
        }


        /*
        Output:
        b c a d
        c e d a b
         */

    }

    static char[] permute(char[] pattern, int[] per) {

        for (int i = 0; i < per.length; i++) {

            int cur = i;

            while (per[cur] >= 0) {//the position next shouldn't be visited

                int next = per[cur];//index to be swapped with ith value | Logically ith index will be acting as a buffer of storing the value @ next during circular permutations

                //swap next and i
                char temp = pattern[i];
                pattern[i] = pattern[next];
                pattern[next] = temp;

                //mark next visited by setting the signed bit
                per[next] *= -1;

                cur = next;//advance the cur

            }
        }

        //resetting the signed bit
        for (int i = 0; i < per.length; i++) {
            per[i] *= -1;
        }

        return pattern;
    }

}