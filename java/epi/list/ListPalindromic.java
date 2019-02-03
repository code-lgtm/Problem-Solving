package epi.list;

//Check if a linked list is palindromic in O(n) time and O(1) space
public class ListPalindromic {
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
        int[] data = {0,1,2,3,4,3,2,1,0};
        int[] data2 = {0,2,2,3,3,2,1,0};
        LNode list = LNode.createList(data);
        LNode list2 = LNode.createList(data2);

        System.out.println(checkPalindromic(list));
        System.out.println(checkPalindromic(list2));

        /*Output:
        true
        false
         */
    }

    static boolean checkPalindromic(LNode list){

        LNode slowCur = list, fastCur = list;
        LNode cur=list;

        while (fastCur!= null && fastCur.next!= null){
            fastCur = fastCur.next.next;
            slowCur = slowCur.next;
        }

        //slow will be at the middle, reverse the right half of the list
        LNode rev =  reverseList(slowCur.next);//ignore the current value and start from the next (number 4 will be ignored in this example, which is expected)

        //compare the reversed right half to the left half
        while (rev!=null){
            if (rev.data!=cur.data){
                return false;
            }
            rev = rev.next;
            cur = cur.next;
        }



        return true;
    }

    static LNode reverseList(LNode cur){
        LNode prev = null;

        while(cur!= null){
            LNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }

        return prev;
    }
}
