class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int lesserEqualsGoal = helper(nums,goal);
        int GoalMinus1 = helper(nums,goal-1);

        return lesserEqualsGoal - GoalMinus1;

    }
    static int helper(int[] nums , int goal){

        if(goal < 0) return 0; // ye edge case h , agr goal 0 ho to
        
        int l = 0 , r = 0 , n = nums.length , count = 0 , sum = 0;
        while(r < n){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}


// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int ans = 0;
//         for(int l = 0 ; l < nums.length ; l++){
//             int sum = 0;
//             for(int r = l ; r < nums.length ; r++){
//                 sum += nums[r];
//                 if(sum == goal) ans++;
//                 if(sum > goal) break;
//             }
//         }
//         return ans;
//     }
// }
