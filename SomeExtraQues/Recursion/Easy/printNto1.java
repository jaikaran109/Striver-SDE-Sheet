package Striver_Recursion.Easy;
import java.util.*;
public class printNto1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        print(1,n);
    }
    static void print(int i , int n){
        if(n < i) return ;
        System.out.println(n);
        print(i,n-1);
    }
}
