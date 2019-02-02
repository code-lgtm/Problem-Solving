package epi.list;

public class CheckOverLapping {

    static class LNode{
        int data;
        LNode next;
        LNode(int data){
            this.data = data;
        }
    }

    //check if two non-cyclic lists overlap in O(m + n) time and O(1) space
    public static void main(String[] args){
        LNode l1 = new LNode(1);
        l1.next = new LNode(5);
        l1.next.next = new LNode(8);
        l1.next.next.next = new LNode(10);

        LNode l2 = new LNode(7);
        l2.next = new LNode(9);
        l2.next.next = new LNode(11);

        System.out.println(listsOverlapping(l1, l2));
        l1.next.next.next = l2.next; // make the lists overlapping
        System.out.println(listsOverlapping(l1, l2));


        /*
        Output:
            false
            true
         */
    }

    //simply check if the lists have the same last node
    static boolean listsOverlapping(LNode cur1, LNode cur2){

        while (cur1.next != null){
            cur1 = cur1.next;
        }

        while (cur2.next != null){
            cur2 = cur2.next;
        }

        return cur1.data == cur2.data;

    }
}
