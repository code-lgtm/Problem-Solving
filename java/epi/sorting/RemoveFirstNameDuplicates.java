package epi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Remove the names with the same first name from a list in O(n log n) time and O(1) space
public class RemoveFirstNameDuplicates {
   static class Name implements Comparable<Name>{
        String first, last;
        Name(String first, String last){
            this.first = first;
            this.last = last;
        }

        public int compareTo(Name n){
            return this.first.compareTo(n.first);
        }
    }

    public static void main(String[] args){
        List<Name> names = new ArrayList<>();
        names.add(new Name("Ian","Botham"));
        names.add(new Name("David","Gower"));
        names.add(new Name("Ian","Bell"));
        names.add(new Name("Ian","Chappell"));
        names.add(new Name("John","Chappell"));

        int uniqueInd = removeDuplicates(names);

        for (int i = 0; i <=uniqueInd; i++){
            System.out.print(names.get(i).first+" "+names.get(i).last+", ");
        }

        //Output: David Gower, Ian Botham, John Chappell,

    }

    static int removeDuplicates(List<Name> names){
       int left = 0, right = 1;

        Collections.sort(names);//sort by first name

       while (right < names.size()){
           if(names.get(left).first.equals(names.get(right).first)){//first name matches, move the right pointer skipping the current duplicate value
               right++;
           }else{//found an unique name @ right, overwriting the left+1 th index with the unique value
               left++;
               names.set(left, names.get(right));
               right++;
           }
       }

       return left;
    }
}
