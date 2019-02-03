package epi.list;

//Delete kthlast element of list in single pass using O(n) time and O(1) space
public class RemoveKthLastElement {
    static class LNode{
        int data;
        LNode next;
        LNode(int data){
            this.data = data;
        }

        static LNode createList(int[] data){
            LNode list = new LNode(data[0]);
            LNode cur = list;
            for (int i = 1; i< data.length; i++){
                cur.next = new LNode(data[i]);
                cur = cur.next;
            }
            return list;
        }
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9};
        LNode list = LNode.createList(data);

        LNode cur = deleteKthLastNode(list, 3);//delete 3rd last, which is 7
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }

        //Output: 1 2 3 4 5 6 8 9

    }

    static LNode deleteKthLastNode(LNode list, int k){
        //advance slow k-1 times, then move slow and fast together, fast jumps k steps at a time, when fast reaches end, slow is at k-1th node from the last

        LNode slowCur = list;
        LNode fasrCur = list;

        int cnt = 0;

        //advance slowCur k-1 times
        while (cnt < k-1){
            cnt++;
            slowCur = slowCur.next;
        }

        //advance fastCur till it reaches end
        while (fasrCur!= null){
            slowCur = slowCur.next;
            int fasrCnt = 0;
            while (fasrCnt <k){
                fasrCnt++;
                fasrCur = fasrCur!=null?fasrCur.next:null;
            }
        }

        //now slowCur is art k-1th node from the last, delete the kth node
        slowCur.next = slowCur.next.next;

        return list;
    }

}
