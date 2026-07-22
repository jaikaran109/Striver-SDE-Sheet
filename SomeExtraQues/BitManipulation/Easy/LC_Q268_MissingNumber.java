class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for(int i = 1 ; i <= nums.length ; i++){
            ans ^= nums[i-1];
            ans ^= i;
        }
        return ans;
    }
}


// class Solution {
//     public int missingNumber(int[] nums) {
//         int sum = 0;
//         int actualSum = nums.length*(nums.length + 1) / 2;
//         for(int i = 0 ; i < nums.length ; i++){
//             sum += nums[i];
//         }
//         return actualSum - sum;
//     }
// }
