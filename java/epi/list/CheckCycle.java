package epi.list;

//Detect cycle in linked list in O(n) time and O(1) space
public class CheckCycle {
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
        l1.next.next.next.next = l1;//cycle

        LNode l2 = new LNode(7);
        l2.next = new LNode(9);
        l2.next.next = new LNode(11);
        l2.next.next.next = new LNode(12);

        System.out.println(checkCycle(l1));
        System.out.println(checkCycle(l2));

        /*
        Output:
            true
            false
         */
    }

    static boolean checkCycle(LNode cur){


        LNode slow = cur, fast = cur;

        while (slow != null && fast != null){
            slow = slow.next;
            if (slow == null){
                return false;
            }
            if(fast.next == null){
                return false;
            }else {
                fast = fast.next.next;
            }

            if(fast != null && fast.data == slow.data){//found a loop
                return true;
            }

        }

        return false;
    }
}
