class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}




// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         Arrays.sort(nums);

//         List<Integer> ans = new ArrayList<>();
//         int n = nums.length;
//         int count = 1;

//         for (int i = 1; i <= n; i++) {
//             if (i < n && nums[i] == nums[i - 1]) {
//                 count++;
//             } else {
//                 if (count > n / 3) {
//                     ans.add(nums[i - 1]);
//                 }
//                 count = 1;
//             }
//         }

//         return ans;
//     }
// }
