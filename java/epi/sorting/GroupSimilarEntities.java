package epi.sorting;

import java.util.*;

//Given a very large array of students, group students by their ages  in O(n) time and O(m) space, where m = unique number of ages
//For example if the array is{b,a,c, b,d,a,b,d ) then (a,a,b,b,b,c,d,d) is an acceptable reordering, as is (d, d,c,a,a,b,b,b)
public class GroupSimilarEntities {

    static class Student{
        String name;
        int age;
        Student(int age, String name){
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        students.add(new Student(5, "A"));
        students.add(new Student(6, "B"));
        students.add(new Student(7, "C"));
        students.add(new Student(5, "D"));
        students.add(new Student(6, "E"));
        students.add(new Student(7, "F"));
        students.add(new Student(5, "G"));
        students.add(new Student(5, "H"));
        students.add(new Student(7, "I"));

        groupByAge(students);

        for(Student s: students){
            System.out.print(s.age+" "+s.name+", ");
        }

        //Output: 5 A, 5 G, 5 H, 5 D, 6 B, 6 E, 7 F, 7 C, 7 I, 

    }


    static void groupByAge(List<Student> students){

        Map<Integer, Integer> ageToCnt = new HashMap<>();
        Map<Integer, Integer> ageToOffset = new HashMap<>();

        //store the cnt and the indexes of every age
        for (int i = 0; i < students.size(); i++){
            Student cur = students.get(i);
            if(ageToCnt.containsKey(cur.age)){
                ageToCnt.put(cur.age, ageToCnt.get(cur.age) + 1);
            }else{
                ageToCnt.put(cur.age, 1);
            }
        }

        //calculate the offset of every age
        int offset = 0;
        Set<Integer> ages = ageToCnt.keySet();
        for(int age: ages){
            ageToOffset.put(age, offset);
            offset += ageToCnt.get(age);
        }


        while (! ageToOffset.isEmpty()){

            Map.Entry<Integer,Integer> keyVal = ageToOffset.entrySet().iterator().next();//picks the first availabe key-value pair

            int curAge = keyVal.getKey();
            int curOffset = keyVal.getValue();
            //the idea is the get the element at the current offset and put that in its offset, this way will end up placing all the elements in their offsets

            int tempAge = students.get(curOffset).age;
            int tempOffset = ageToOffset.get(tempAge);

            //The element at currentOffset belongs at tempOffset, swap it with the element which is currently at tempOffset
            Collections.swap(students, curOffset, tempOffset);

            //increment the tempOffset
            if(ageToCnt.get(tempAge) == 1){//this was the last element remove it from both the maps
                ageToCnt.remove(tempAge);
                ageToOffset.remove(tempAge);
            }else{//decrement the count and increment the offset
                ageToOffset.put(tempAge, ageToOffset.get(tempAge)+1);
                ageToCnt.put(tempAge, ageToCnt.get(tempAge)-1);
            }


        }




    }


}
