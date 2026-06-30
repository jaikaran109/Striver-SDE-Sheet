class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> map = new HashMap<>();
       int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            int num = nums[i];
            int moreNeeded = target - num;
            if(map.containsKey(moreNeeded)){
                return new int[]{map.get(moreNeeded), i};
            }
            map.put(num,i);
        }
        return new int[]{-1,-1};
    }
}




// Brute Force
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int[] arr = new int[2];
//         for(int i = 0 ; i < nums.length ; i++){
//             for(int j = i + 1 ; j < nums.length ; j++){
//                 if((nums[i] + nums[j]) == target) return new int[]{i, j};
//             }
//         }
//         return new int[]{-1,-1};
//     }
// }

// TC - O(n^2)
// SC - O(1)
