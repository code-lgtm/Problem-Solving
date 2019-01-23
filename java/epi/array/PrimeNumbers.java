package epi.array;

import java.util.ArrayList;
import java.util.List;

//Prime numbers till n using Sieve out technique
/*
Time complexity
n ( n/2 + n/3 + n/5 + n/11  .... )

This equates to (n Log (Log n)) Which is better than checking every int till it's square root which would result in O(n x sqroot(n)) = O(n^3/2) time complexity
Space complexity is O(n)

PS: (n Log (Log n)) is better than (n  Log n)

 */
public class PrimeNumbers {

    public static void main(String[] args){
        List<Integer> primes = getPrimesTill(100);

        for (int p: primes){
            System.out.print(p+" ");
        }

        //Output: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

    }

    static List<Integer> getPrimesTill(int n){
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i < isPrime.length; i++){//mark every number >= 2 as a candidate prime
            isPrime[i] = true;
        }

        for(int i = 2; i <=n; i++){//starting with 2 as 0 and 1 are not prime
            if(isPrime[i]){
                primes.add(i);

                for(int j = i+i; j <= n; j+=i){//Sieve out the multiple of i as they cant be prime
                    isPrime[j] = false;
                }


            }
        }

        return primes;
    }

}
