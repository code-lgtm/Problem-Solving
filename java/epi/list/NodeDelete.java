package epi.list;

//Delete a note in O(1) time and O(1) space, the node to be deleted isn't the last node
public class NodeDelete {
    static class LNode{
        int data;
        LNode next;
        LNode(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LNode l1 = new LNode(1);
        l1.next = new LNode(5);
        l1.next.next = new LNode(8);
        l1.next.next.next = new LNode(10);

        LNode delNode = l1.next.next;//8

        LNode cur = deleteNode(l1, delNode);
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }

        //Output: 1 5 10
    }

    static LNode deleteNode(LNode lst, LNode del){
        //insted of deleting node del, copy del's next's data in del and delete del's next. effectively yielding the same config

        del.data = del.next.data;
        del.next = del.next.next;
        return lst;
    }
}
