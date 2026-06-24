// Boyer Moore Voting Algo

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}


// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             if (entry.getValue() > nums.length / 2) {
//                 return entry.getKey();
//             }
//         }
//         return -1;
//     }
// }


// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length / 2];
//     }
// }

// Time Complexity - nLogn , Space - O(1)
