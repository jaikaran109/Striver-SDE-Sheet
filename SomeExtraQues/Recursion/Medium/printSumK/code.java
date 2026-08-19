package Recursion.Medium;
import java.util.*;
public class printSumK {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i = 0 ; i < size ; i++){
            arr[i] = input.nextInt();
        }
        int sum = input.nextInt();
        List<int[]> result = sum(arr,0,0,sum,new ArrayList<>());

        for(int[] sub : result){
            System.out.println(Arrays.toString(sub));
        }
    }
    static List<int[]> sum(int[] nums, int idx, int curSum,int target, List<Integer> ans) {

        if(idx == nums.length) {

            List<int[]> container = new ArrayList<>();

            if(curSum == target) {
                int[] sub = new int[ans.size()];

                for(int i = 0; i < ans.size(); i++) {
                    sub[i] = ans.get(i);
                }

                container.add(sub);
            }

            return container;
        }

        // PICK
        ans.add(nums[idx]);

        List<int[]> left =
            sum(nums, idx + 1, curSum + nums[idx], target, ans);

        // BACKTRACK
        ans.remove(ans.size() - 1);

        // SKIP
        List<int[]> right =
            sum(nums, idx + 1, curSum, target, ans);

        // Combine both branches
        left.addAll(right);

        return left;
    }
}
