package epi.sorting;

//Find the non duplicate intersection of two sorted arrays in O(m+n) and O(1) space
public class ArrayIntersection {

    public static void main(String[] args){
        int[] ary1 = {2,3,3,5,5,6,7,7,8,12};
        int[] ary2 = {5,5,6,8,8,9,10,10};

        printIntersection(ary1, ary2);

        //Output: 5 6 8

    }

    static void printIntersection(int[] ary1, int[] ary2){
        int cnt1 = 0, cnt2 = 0;

        while (cnt1 < ary1.length && cnt2<ary2.length){

            if(cnt1< ary1.length-1 && ary1[cnt1] == ary1[cnt1+1]){
                cnt1++;
                continue;
            }

            if(cnt2< ary2.length-1 && ary2[cnt2] == ary1[cnt2+1]){
                cnt2++;
                continue;
            }

            if(ary1[cnt1] == ary2[cnt2]){
                System.out.print(ary1[cnt1]+" ");
                cnt1++;
                cnt2++;
            }else if(ary1[cnt1] < ary2[cnt2]){
                cnt1++;
            }else {
                cnt2++;
            }

        }

    }
}
