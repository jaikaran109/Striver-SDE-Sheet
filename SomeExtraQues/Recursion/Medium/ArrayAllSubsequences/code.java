package Striver_Recursion.Medium.ArrayAllSubsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i = 0 ; i < size ; i++){
            arr[i] = input.nextInt();
        }

        List<int[]> result = subsequence(arr,new ArrayList<>() , 0);

        for(int[] sub : result){
            System.out.println(Arrays.toString(sub));
        }
    }
    static List<int[]> subsequence(int[] nums , List<Integer> ans ,int idx){
        if(idx == nums.length){
            List<int[]> container = new ArrayList<>();
            int[] sub = new int[ans.size()];
            for(int i = 0 ; i < ans.size() ; i++){
                sub[i] = ans.get(i);
            }
            container.add(sub);
            return container;
        }

        ans.add(nums[idx]); // add current element

        List<int[]> left = subsequence(nums, ans, idx+1);

        ans.remove(ans.size() - 1); // remove current element

        List<int[]> right = subsequence(nums, ans, idx+1);

        left.addAll(right);
        return left;
    }
}
