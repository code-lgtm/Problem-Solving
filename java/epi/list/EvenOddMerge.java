package epi.list;

//Merge the even and odd indexes of a list in O(n) time and O(1) space
public class EvenOddMerge {

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
        int[] data = {0,1,2,3,4,5,6,7,8,9};
        LNode list = LNode.createList(data);

        LNode cur = evenOddMerge(list);//cyclic right shift
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }

        //Output: 0 2 4 6 8 1 3 5 7 9

    }

    static LNode evenOddMerge(LNode list){

        int cnt = 0;
        LNode evnStart=null, evnEnd=null, oddStart=null, oddEnd=null;
        LNode cur = list;

        while (cur!= null){
            if(cnt%2 == 0){//even
                if (cnt == 0){
                    evnStart = cur;
                    evnEnd = evnStart;
                }else {
                    evnEnd.next = cur;
                    evnEnd = evnEnd.next;
                }

            }else {
                if (cnt == 1){
                    oddStart = cur;
                    oddEnd = oddStart;
                }else {
                    oddEnd.next = cur;
                    oddEnd = evnEnd.next;
                }
            }
            cnt++;
            cur = cur.next;
        }

        evnEnd.next = oddStart;
        oddEnd = null;

        return evnStart;
    }

}
