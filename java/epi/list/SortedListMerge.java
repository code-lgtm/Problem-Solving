package epi.list;

public class SortedListMerge {

    static class LNode{
        int data;
        LNode next;
        LNode(int data){
            this.data = data;
        }
        LNode(int data, LNode next){
            this.data = data;
            this.next = next;
        }
    }

    //Merge two sorded linkslists in O(m + n) time and O(1) space
    public static void main(String[] args){
        LNode l1 = new LNode(1);
        l1.next = new LNode(5);
        l1.next.next = new LNode(8);
        l1.next.next.next = new LNode(10);

        LNode l2 = new LNode(7);
        l2.next = new LNode(9);
        l2.next.next = new LNode(11);

        LNode mergedList = mergeLists(l1, l2);
        while (mergedList!= null){
            System.out.print(mergedList.data+" ");
            mergedList = mergedList.next;
        }

        /*
        Output:
        1 5 7 8 9 10 11
         */
    }

    static LNode mergeLists(LNode l1, LNode l2){
        LNode cur = new LNode(0);//a dummy node for merging;
        LNode curRef = cur;


        while (l1!= null && l2!= null){//add the smaller value to the sorted cur
            if(l1.data < l2.data){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        //Add the remaining elements
        if(l1!= null){
            cur.next = l1;
        }

        if (l2!= null){
            cur.next = l2;
        }
        return curRef.next;

    }

}
