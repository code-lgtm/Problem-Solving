package epi.list;

//Given a pivot k, rearrange the list such that all the values less than k are on the left and remaining on the right
//Time: O(n), space (1)
public class ListPivoting {

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
        int[] data = {2,5,1,9,4,3,7,10,5,15};
        LNode list = LNode.createList(data);

        LNode cur = pivotList(list, 7);//7 is the pivot
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        //Output: 2 5 1 4 3 5 7 9 10 15

    }

    static LNode pivotList(LNode list, int pivot){

        LNode left = new LNode(-1), right = new LNode(-1);//dummy nodes
        LNode leftCur = left, rightCur = right;

        LNode pivotNode = null;
        LNode cur= list;

        while (cur!= null){
            if(cur.data == pivot){
                pivotNode = cur;
            }else if(cur.data < pivot){
                leftCur.next = cur;
                leftCur = leftCur.next;
            }else {
                rightCur.next = cur;
                rightCur = rightCur.next;
            }
            cur = cur.next;
        }


        //stitch the three references

        leftCur.next = pivotNode;
        pivotNode.next = right.next;
        rightCur.next = null;

        return left.next;
    }
}
