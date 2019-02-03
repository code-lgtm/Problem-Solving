package epi.list;

//Add two unbounded numbers represented in list in O(max(m,n)) time and O(max(m,n)) space
public class AddListBasedInts {

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
        int[] data = {8,5,9,9}; //represents 9958
        LNode list1 = LNode.createList(data);
        int[] data2 = {2,9}; //represents 92
        LNode list2 = LNode.createList(data2);

        LNode cur = addLists(list1, list2);
        while (cur != null) {
            System.out.print(cur.data);
            cur = cur.next;
        }
        //Output: 05001  //which represents 10050
    }

    static LNode addLists(LNode num1, LNode num2){
        LNode sum = new LNode(-1);//dummy node for storing sum
        LNode sumCur = sum;

        int carry = 0;
        while (num1!= null || num2!= null){//atleast one should be non null

            int tSum = carry;

            if (num1!= null){
                tSum+= num1.data;
                num1 = num1.next;
            }
            if (num2!= null){
                tSum+= num2.data;
                num2 = num2.next;
            }

            carry = tSum/10;
            tSum = tSum % 10;


            LNode digitSum = new LNode(tSum);
            sumCur.next = digitSum;
            sumCur = sumCur.next;


        }

        if (carry >0){
            sumCur.next = new LNode(carry);
        }


        return sum.next;
    }
}
