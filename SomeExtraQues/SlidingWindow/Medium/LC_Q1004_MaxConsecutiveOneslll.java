class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0 , maxLen = 0 , r = 0 , zero = 0;

        while(r < nums.length){
            if(nums[r] == 0) zero++;
            while(zero > k){
                if(nums[l] == 0) zero--;
                l++;
            }
            if(zero <= k) {
                int len = r - l + 1;
                maxLen = Math.max(len,maxLen);
            }
            r++;
        }
        return maxLen;
    }
}

// Time - O(n)
// Space - O(1)



// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int zero = 0;
//         int ans = 0;
//         int count = 0;

//         for(int i = 0 ; i < nums.length ; i++){
//             int temp = k;
//             zero = 0;
//             count = 0;
//             for(int j = i ; j < nums.length ; j++){
//                 if(nums[j] != 0) count++;
//                 else{
//                     zero++;
//                     while(zero > 0 && temp > 0){
//                         count++;
//                         zero--;   -- consition me minus mt krna kyuki vo minus kr ke compare kr rha h
//                         temp--;
//                     }
//                     if(zero > 0 && temp == 0) {
//                         break;
//                     }
//                 }
//                 ans = Math.max(count,ans);
//             }   
//         }
//         return ans;
//     }
// }
