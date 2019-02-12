package epi.sorting;

//Stable sort (the order of sorted element should be preserved) a list - Time O(n log n), space O(log n)
public class StableSortList {
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
        int[] data = {5,2,4,9,7,2,3,7,6,45,11,12};
        LNode list = LNode.createList(data);

        LNode sortedList = stableSort(list);

        while (sortedList!=null){
            System.out.print(sortedList.data+" ");
            sortedList = sortedList.next;
        }

        //Output: 2 2 3 4 5 6 7 7 9 11 12 45
    }

    //Sort the list similar to merge sort
    static LNode stableSort(LNode cur){
        if(cur == null || cur.next == null){
            return cur;
        }

        //Split the list into two halves
        LNode slow = cur, fast = cur, preSlow = null;

        while (fast!= null && fast.next!= null ){
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        LNode firstHalf = cur;
        LNode secondHalf = slow;
        preSlow.next = null; //IT IS IMPORTANT TO SPLIT THE LIST AT preSlow ELSE WE WOULDNT BE ABLE TO DIVIDE A LIST WITH 2 ELEMENTS
        //now the list is splited, merge it using merge sorted list function

        LNode merged = mergeSortedLists(stableSort(firstHalf), stableSort(secondHalf));
        return merged;

    }

    //runs in O(n)
    static LNode mergeSortedLists(LNode l1, LNode l2){
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
