// package Striver_Recursion.Medium;
// import java.util.*;
// public class allSubsequences {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         String str = input.next();
//         subsequence(str,"",0);
//     }
//     static void subsequence(String str,String ans,int idx){
//         if(idx == str.length()) {
//             System.out.print(ans + " ");
//             return;
//         }
//         char ch = str.charAt(idx);
//         subsequence(str,ans+ch,idx+1);
//         subsequence(str,ans,idx+1);
//     }
// }




// With return type

package Striver_Recursion.Medium;
import java.util.*;
public class allSubsequences {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        List<String> result = subsequence(str,"",0);
        System.out.println(result);

    }
    static List<String> subsequence(String str,String ans,int idx){
        if(idx == str.length()) {
            List<String> container = new ArrayList<>();
            container.add(ans);
            return container;
        }
        char ch = str.charAt(idx);
        List<String> left = subsequence(str,ans+ch,idx+1);

        List<String> right = subsequence(str,ans,idx+1);

        left.addAll(right);
        return left;
    }
}
