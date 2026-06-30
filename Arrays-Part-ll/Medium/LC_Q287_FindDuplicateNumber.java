class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] isFound = new boolean[nums.length + 1];

        for(int num : nums){
            if(isFound[num]) return num;
            isFound[num] = true;
        }
        return -1;
    }
}





// class Solution {
//     public int findDuplicate(int[] nums) {
//         HashMap<Integer,Integer> map = new HashMap<>();

//         for(int i = 0 ; i < nums.length ; i++){
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

//             if(map.get(nums[i]) > 1) return nums[i];
//         }
//         return -1;
//     }
// }
