class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subsets = 1 << n; // its basically 2^n(pow)
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < subsets ; i++){  // - its run 2^n
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){  // N times
                if((i & (1 << j)) != 0) list.add(nums[j]);
            }
            ans.add(list);
        }
        return ans;
    }
}

// Time - O(2^n + N)
// Space - O(n * 2^n)
