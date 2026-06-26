// Optimal  -- Dry Run this for understanding
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0 , count2 = 0;
        int ele1 = -1 , ele2 = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(count1 == 0 && nums[i] != ele2){
                count1++;
                ele1 = nums[i];
            }
            else if(count2 == 0 && nums[i] != ele1){
                count2++;
                ele2 = nums[i];
            }
            else if (nums[i] == ele1) {
                count1++;
            }
            else if (nums[i] == ele2) {
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        count1 = 0 ;
        count2 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == ele1) count1++;
            if(nums[i] == ele2) count2++;
        }

        if(count1 > nums.length / 3) ans.add(ele1);
        if(count2 > nums.length / 3) ans.add(ele2);
        
        return ans;
    }
}

// TC - O(n)
// Space - O(1)


// Better
// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
        
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             if (entry.getValue() > nums.length / 3) {
//                 ans.add(entry.getKey());
//             }
//         }
//         return ans;
//     }
// }
// TC - O(n)
// Space - o(k)



// Brute Force
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

// TC - O(nLogn)
// Space - o(1)
