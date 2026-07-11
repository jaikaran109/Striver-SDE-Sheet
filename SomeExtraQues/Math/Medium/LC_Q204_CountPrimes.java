// Review

// Sieve of Eratosthenses
// logic - prime harmonic series
// Time - Nlog(logN)

// for better explanation watch strivers video

class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;

        boolean[] prime = new boolean[n];

        // initially assume all numbers are prime
        for(int i = 2 ; i < n ; i++) {
            prime[i] = true;
        }

        for(int i = 2 ; i * i < n ; i++) {
            if(prime[i]) {
                for(int j = i * i ; j < n ; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;

        for(int i = 2 ; i < n ; i++) {
            if(prime[i]) {
                count++;
            }
        }

        return count;
    }
}

// Brute Force
// class Solution {
//     public int countPrimes(int n) {
//         int count = 0;

//         for(int i = 2 ; i < n ; i++) {
//             if(isPrime(i)) {
//                 count++;
//             }
//         }

//         return count;
//     }

//     private boolean isPrime(int num) {
//         if(num <= 1) return false;

//         for(int i = 2 ; i * i <= num ; i++) {
//             if(num % i == 0) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }
