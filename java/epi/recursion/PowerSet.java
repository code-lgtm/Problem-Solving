package epi.recursion;

// Generate the powerset - Time (n*2^n) [Total 2^n powersets are generated spending n time each]

public class PowerSet {

    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c', 'd'};
        printPowerSet(set);
        /*
        Output:
        Printing powerset with size: 16

a
b
ab
c
ac
bc
abc
d
ad
bd
abd
cd
acd
bcd
abcd
         */
    }

    private static void printPowerSet(char[] set) {

        int powSetCount = (int) Math.pow(2, set.length);
        System.out.println("Printing powerset with size: " + powSetCount);

        for (int cnt = 0; cnt < powSetCount; cnt++) {
            //check if ith bit is set in the counter i , if yes then print the ith char if the set

            for (int i = 0; i < set.length; i++) {
                if ((cnt & 1 << i) > 0) {//ith bit is set
                    System.out.print(set[i]);
                }
            }
            System.out.println();

        }

    }
}
