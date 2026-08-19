package Striver_Recursion.Easy;
import java.util.*;
public class reverseArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i = 0 ; i < size ; i++){
            arr[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(reverse(arr,0,size-1)));
    }
    static int[] reverse(int[] nums , int st , int end) {
        if(st > end) return nums;
        int temp = nums[end];
        nums[end] = nums[st];
        nums[st] = temp;
        return reverse(nums,st+1,end-1);
    }
}
