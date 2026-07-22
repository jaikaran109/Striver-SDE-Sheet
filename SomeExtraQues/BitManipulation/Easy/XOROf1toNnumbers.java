// Java program to find XOR of numbers
// from 1 to n.

class GFG 
{
    // Method to calculate xor
    static int computeXOR(int n)
    {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0;
      
      // Chalo pattern samjhte h 
      // n = 1 = 1
      // n = 2 = 1 ^ 2 = 3  -- yha 3 aa gya 
      // n = 3 = 1 ^ 2 ^ 3 = 0 -- yha 1 xor 2 = 3 and again xor with 3 = 0
	  // n = 4 = 1 ^ 2 ^ 3 ^ 4 = 4 -- uper wale line se clear h 3 tk 0 aa rha h to ab jb 4 ke saath krenge to 4 aayega

      // n = 5 = 1 ^ 2 ^ 3 ^ 4 ^ 5 = 1
      // n = 6 = 1 ^ 2 ^ 3 ^ 4 = 4 ^ 5 ^ 6 = 7 
      // n = 7 = 1 ^ 2 ^ 3 ^ 4 = 4 ^ 5 ^ 6 ^ 7 = 0
      // n = 8 = 1 ^ 2 ^ 3 ^ 4 = 4 ^ 5 ^ 6 ^ 7 ^ 8 = 8
      
      // n = 1 = 1 ^ 2 ^ 3 ^ 4 = 4 ^ 5 ^ 6 ^ 7 ^ 8 ^ 9 = 1
      // ....
      
    }
    
    public static void main (String[] args)
    {
         int n = 5;
         System.out.println(computeXOR(n));
    }
}






// Given a number n, find the XOR from 1 to n for given n number
// import java.io.*;

// public class GfG {
//     static int computeXor(int n){
//         int res = 0;
        
//         return res;
//     }
//     public static void main(String[] args) {
//         int n = 7;
//         System.out.println(computeXor(n));
//     }
// }
