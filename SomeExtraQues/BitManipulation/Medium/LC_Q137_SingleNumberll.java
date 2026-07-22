class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;

        for(int i = 0 ; i < nums.length ; i++) {
            ones = (ones ^ nums[i]) & ~twos;   // agr two me hoga to one se dlt kr do -- aise last me ek element bachega jo single hoga
            twos = (twos ^ nums[i]) & ~ones; 
        }

        return ones;
    }
}




// class Solution {
//     public int singleNumber(int[] nums) {
//         int ans = 0;
//         for(int bit = 0 ; bit < 32 ; bit++){
//             int count = 0;
//             for(int i = 0 ; i < nums.length ; i++){
//                 if((nums[i] & (1 << bit)) != 0) count++;
//             }
//             if(count % 3 != 0){
//                 ans = ans | (1 << bit);
//             }
//         }
//         return ans;
//     }
// }
// Time - O(n * 32)
// Space - O(1)


// isme sare numbers ko bit me change kr ke solve kr rhe h 
// jo number 3 times hogi uski sari positioin bits bhi 3 times hogi 
// jo number 1 time hoga uska bit 1 baar hi hoga 

// -- thoda  confusing lag rha h - refer striver -L6.Single Number ll






// class Solution {
//     public int singleNumber(int[] nums) {
//         Arrays.sort(nums);
//         for(int i = 1 ; i < nums.length ; i+=3){  // --  1 se start kr rhe ho to peeche aur aage wala element same hona chahiye
//             if(nums[i] != nums[i-1]) return nums[i-1]; / -- mismatch
//         } 
//         return nums[nums.length - 1];  // agr pure array me single element nhi mila traversal me to vo last me hoga kyuki +3 me last wala index skip ho gya hoga
//     }
// }
// Time  - O(n log n)
// Space - O(1)





// class Solution {
//     public int singleNumber(int[] nums) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i = 0 ; i < nums.length ; i++){
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
//         for(int i = 0 ; i < nums.length ; i++){
//             if(map.get(nums[i]) == 1) return nums[i];
//         }
//         return -1;
//     }
// }
// Time - O(2n)
// Space - O(n)
