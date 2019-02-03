package epi.list;

//Rightshift a list in O(n+k) time and O(1) space
public class CyclicRightShift {
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

        LNode cur = cyclicRightShift(list, 2);//cyclic right shift
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }

        //Output: 3 4 5 6 7 8 9 1 2

    }

    static LNode cyclicRightShift(LNode list, int k){

        LNode cur = list;
        LNode start = list;
        while (cur.next != null){
            cur = cur.next;
        }

        while (k >0){
            LNode temp = start;
            start = start.next;
            cur.next = temp;
            cur = cur.next;
            cur.next = null;//cur is the last node
            k--;
        }


        return start;
    }

}
