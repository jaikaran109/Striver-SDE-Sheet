package Striver_Recursion.Easy;
import java.util.*;
public class checkPalindromic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.println(check(str, 0) ? "Yes" : "No");
    }
    static boolean check(String str , int i){
        if(i >= str.length() / 2 ) return true;
        if(str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        return check(str,i+1);
    }
}
