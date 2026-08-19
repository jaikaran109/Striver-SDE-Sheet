// package Striver_Recursion.Easy;
// import java.util.*;
// public class print1toN {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         int n = input.nextInt();
//         print(1,n);
//     }

//     static void print(int i ,int n){
//         if(i > n) return ;
//         System.out.println(i);
//         print(i+1,n);
//     }
// }




// Backtracking  -- in this you are not allowed to use i + 1

package Striver_Recursion.Easy;
import java.util.*;
public class print1toN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        print(n,n);  // pass n in both positions
    }

    // isme dekho tm i - 1 kr rhe ho aur condition me less then 1 dekh rhe ho means tm n ko decrease kr ke 1 tk lekr ja rhe ho
    // aur sout recursion call over hone ke baad h to isme stack se values aayenge , phle 1 then 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10
    
    static void print(int i ,int n){
        if(i < 1) return ;
        print(i-1,n);
        System.out.println(i);
    }
}
