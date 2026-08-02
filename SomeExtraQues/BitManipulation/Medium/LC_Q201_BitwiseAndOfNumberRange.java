class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left < right){  // tb tk shift kro jb tk dono number equal na ho jaye 
            left = left >> 1;
            right = right >> 1;
            shift++;
        } 
        
        return left << shift; 
    }
}


// dekho isme bss tmko left aur right me common find krna h ki kitne digits same h 
// ex:- 9  -> 00001001
//      12 -> 00001100
// isme dekho starting ke 5 numbers same h aur baki different h , to beech ke numbers me bhi same pattern hoga 
// isiliye hm right shift krenge aur common part find kr lenge , phir jitne right shift honge utne left shift kr denge tb ans mil jayega

// Example in detail
// 9  -> 00001001
// 10 -> 00001010
// 11 -> 00001011
// 12 -> 00001100
// isme tm dhyan do sbka and kroge to common prefix hi rah jayega bss aur baki sb 0 ho jayega 
// same hm right shift kr ke common prefix nikal le rhe h , aur phir left shift kr ke number



// right shift ->

// First Iteration
// 9  -> 00000100
// 12 -> 00000110

// Second Iteration
// 9  -> 00000010
// 10 -> 00000011

// Third Iteration
// 9  -> 00000001
// 12 -> 00000001

// yha 3 iteration me common prefix mil gya h ab isko 3 times left shift kr do 
// 9  -> 00001000
// 12 -> 00001000

// ab iska and kr do => 8








// Brute Force

// TLE - Wrost case me aa skta h
// class Solution {
//     public int rangeBitwiseAnd(int left, int right) {
//         if(left == 1 && right == 1) return left;  // ye edge case h 
//         if(left == 1 || left == 0) return 0; // 1 ka and kisi bhi number ke saath kroge to vo 0 hi dega , neeche dry run ke liye binary me likha h check kr skte ho

//         long and = left; 
//         for(int i = left + 1 ; i <= right ; i++){
//             and &= i;
//         }
//         if(and >= Integer.MAX_VALUE || and <= Integer.MIN_VALUE) return 0;
//         return (int)and;
//     }
// }



// 1 = 01
// 2 = 10
// 3 = 11
// 4 = 100
// 5 = 101
// 6 = 110
// 7 = 111
// 8 = 1000
// 9 = 1001
// 10 = 1010
// 11 = 1011
// 12 = 1100
