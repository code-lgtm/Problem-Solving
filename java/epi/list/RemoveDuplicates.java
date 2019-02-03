package epi.list;

//Remove the duplicates from a sorted list in O(n) time and O(1) space
public class RemoveDuplicates {
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
        int[] data = {1,2,3,3,3,4,5,5,6,7,8,8,9, 9, 9};
        LNode list = LNode.createList(data);

        LNode cur = removeDups(list);//delete 3rd last, which is 7
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }

        //Output: 1 2 3 4 5 6 7 8 9

    }

    static LNode removeDups(LNode list){
        LNode cur = list;
        LNode prev = cur;
        cur = cur.next;

        while (cur!= null){
            if(prev.data == cur.data){//do not advance prev, simply keep deleting duplicates
                prev.next = cur.next;
                cur = cur.next;
            }else {//advance both
                prev = prev.next;
                cur = cur.next;
            }
        }

        return list;
    }


}
