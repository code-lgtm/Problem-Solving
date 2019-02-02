package epi.list;

//Reverse a singly list in O(n) time and O(1) space
public class ListReverse {
    static class LNode{
        int data;
        LNode next;
        LNode(int data){
            this.data = data;
        }
    }

    public static void main(String[] args){
        LNode l1 = new LNode(1);
        l1.next = new LNode(5);
        l1.next.next = new LNode(8);
        l1.next.next.next = new LNode(10);

        LNode reversedList = reverseList(l1);
        while (reversedList!= null){
            System.out.print(reversedList.data+" ");
            reversedList = reversedList.next;
        }

        /*
        Output:
        10 8 5 1
         */
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
