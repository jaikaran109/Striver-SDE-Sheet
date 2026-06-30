// you can more Optimise this code using set but its little bit tricky - if you want you can watch striver longest Consecutive Sequence video


class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int ans = 1;
        int count = 1;

        for(int i = 1; i < nums.length; i++) {

            if(nums[i] == nums[i - 1]) continue;  // if same then skip

            if(nums[i] == nums[i - 1] + 1) {  // if previous is equal to current - 1 ---- means continuous or not
                count++;
            } else {
                count = 1;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
// Time - O(nLogn)
// Space - O(1)






// Better

// class Solution {
//     public int longestConsecutive(int[] nums) {

//         if(nums.length == 0) return 0;

//         Arrays.sort(nums);

//         int ans = 1;

//         for(int j = 0 ; j < nums.length ; j++){
//         int min = nums[j];

//         int count = 1;
//             for(int i = j + 1 ; i < nums.length ; i++){
                
//                 if(nums[i] == nums[i - 1]) continue;
//                 else{
//                     int diff = nums[i] - min;
//                     min = nums[i];
//                     if(diff > 1){
//                         break;
//                     }
//                     count++;
//                 }

//             }
//             ans = Math.max(ans,count);
//         }
//         return ans;
//     }
// }

// Time - O(n^2)
// Space O(1)



// // Brute Force
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         if (nums.length == 0) return 0;

//         int longest = 1;

//         for (int i = 0; i < nums.length; i++) {
//             int count = 1;
//             int next = nums[i] + 1;

//             while (isPresent(nums, next)) {
//                 count++;
//                 next++;
//             }

//             longest = Math.max(longest, count);
//         }

//         return longest;
//     }

//     private boolean isPresent(int[] nums, int target) {
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == target) {
//                 return true;
//             }
//         }

//         return false;
//     }
// }

// // Time - O(n^3)
