class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pos=0, neg=1;
        int[] ans = new int[n];

        for(int i =0;i<n;i++) {
            if (nums[i] < 0) {
                ans[neg] = nums[i];
                neg +=2;
            } else {
                ans[pos] = nums[i];
                pos +=2;
            }
        }
        return ans;
    }
}

// Time - O(n)
// Space - O(1)






// Brute Force

// class Solution {
//     public int[] rearrangeArray(int[] nums) {

//         int len = nums.length ;
        
//         int[] pos = new int[len/2];   // positive ka array
//         int[] neg = new int[len/2];   // negative ka array

//         int p = 0;  // pos indexing
//         int n = 0;  // neg indexing

//         for(int i = 0 ; i < len ; i++){
//             if(nums[i] > 0){
//                 pos[p] = nums[i];
//                 p++;
//             }
//             else {
//                 neg[n] = nums[i];
//                 n++;
//             }
//         }

//         p = 0;  // reassign 0 for accesing the elements of pos and neg
//         n = 0;

//         for(int i = 0 ; i < len ; i++){
//             if(i % 2 ==0){
//                 nums[i] = pos[p++];
//             }else{
//                 nums[i] = neg[n++];
//             }
//         }

//         return nums;
//     }
// }


// // Time - O(n)
// // Space - O(n)
