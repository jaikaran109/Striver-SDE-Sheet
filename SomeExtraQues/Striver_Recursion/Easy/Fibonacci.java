package Striver_Recursion.Easy;
import java.util.*;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(fibo(n));
    }
    static int fibo(int n){
        if(n <= 1) return n;
        return fibo(n - 1) + fibo(n - 2);
    }
}

// 0 1 1 2 3 5 8 7