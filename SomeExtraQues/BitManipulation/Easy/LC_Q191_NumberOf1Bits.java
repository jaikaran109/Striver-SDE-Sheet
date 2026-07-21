// Brian Kernighan’s Algorithm

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}

// ex - n = 13
// 13 - 1101
// n-1 = 12 - 1100
// n = n & (n - 1) -- 1100
// count = 1

// n = 12 - 1100
// n - 1 = 11 - 1011
// n = n & (n-1) - 1000
// count = 2

// n = 8 - 1000
// n - 1 = 7 - 0111
// n & (n-1) = 0000
// count = 3
// Loop Breaks
