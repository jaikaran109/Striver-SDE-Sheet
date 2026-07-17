// Optimal

class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while(map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if(map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            r++;
        }
        return maxLen;
    }
}




// Brute Force

// class Solution {
//     public int totalFruit(int[] nums) {
//         int ans = 0;
//         for(int i = 0 ; i < nums.length ; i++){
//             int count = 0;
//             HashSet<Integer> set = new HashSet<>();
//             for(int j = i ; j < nums.length ; j++){
//                 set.add(nums[j]);
//                 if(set.size() > 2) break;
//                 count++;
//             }
//             ans = Math.max(ans,count);
//         }
//         return ans;
//     }
// }
