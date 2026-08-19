package Striver_Recursion.Easy;
import java.util.*;
public class factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(fact(n));
    }
    
    static int fact(int n){
        if(n == 0) return 1;
        return n * fact(n-1);
    }
}
