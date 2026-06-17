class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 1;
        while(r < n){
            if(nums[l] == nums[r]) r++;
            else nums[++l] = nums[r];
        }
        return l + 1;
    }
}



// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int l = 0;
//         int r = 1;
//         while(r < nums.length){
//             if(nums[l] == nums[r]){
//                 r++;
//             }
//             else{
//                 l++;
//                 nums[l] = nums[r];
//                 r++;
//             }
//         }
//         return l + 1;
//     }
}
