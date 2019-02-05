package epi.stack;


import java.util.Stack;

//Iterate a list with special Jump node in O(n) time and space
public class JumpStack {
    static class LNode{
        int data;
        LNode next, jump;
        boolean visited = false;
        LNode(int data){
            this.data = data;
        }

    }

    static LNode getList(){
        LNode head = new LNode(1);
        LNode two = new LNode(2);
        LNode three = new LNode(3);
        LNode four = new LNode(4);
        LNode five = new LNode(5);

        head.next = two;
        head.jump = three;

        two.next = three;
        two.jump = four;

        three.next = four;
        three.jump = two;

        four.next = five;

        return head;
    }
    public static void main(String[] args){
        visitRec(getList());
        System.out.println();
        visitIteratively(getList());
        /*
        Output:
        13245
        13245
         */
    }

    static void visitIteratively(LNode list){
        Stack<LNode> stk = new Stack<>();
        stk.push(list);

        while (!stk.isEmpty()){
            LNode cur = stk.pop();
            if(cur == null || cur.visited){
                continue;
            }

            System.out.print(cur.data);
            cur.visited = true;

           //STACY IS LIFO, SO WE ARE INSERTING NEXT FIRST THEN JUMP, WHERE AS IN RECURSSION ITS JUMP FIRST AND THEN NEXT
            stk.push(cur.next);
            stk.push(cur.jump);


        }
    }
    static void visitRec(LNode cur){
        if(cur == null || cur.visited){
            return;
        }

        System.out.print(cur.data);
        cur.visited = true;
        visitRec(cur.jump);
        visitRec(cur.next);
    }
}
