class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0 ; i < nums.length ; i++){
            xor ^= nums[i];
        }

        int rightmost = xor & -xor;
        int b1 = 0;
        int b2 = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if((nums[i] & rightmost) != 0) b1 ^= nums[i];
            else b2 ^= nums[i];
        }
        return new int[]{b1,b2};
    }
}




// class Solution {
//     public int[] singleNumber(int[] nums) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         int[] ans = new int[2];
//         for(int i = 0 ; i < nums.length ; i++){
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
//         int got = 0;
//         for(int i = 0 ; i < nums.length ; i++){
//             if(map.get(nums[i]) == 1){ 
//                 ans[got++] = nums[i];
//             }
//         }
//         return ans;
//     }
// }
