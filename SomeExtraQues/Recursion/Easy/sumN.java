package Striver_Recursion.Easy;
import java.util.*;
public class sumN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(summ(0,0,n));
    }
    static int summ(int sum , int i , int n){
        if(i > n) return sum;
        sum += i;
        return summ(sum,i+1,n);

    }
}
