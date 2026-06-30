class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int l = i + 1; l < nums.length; l++) {
                if (l > i + 1 && nums[l] == nums[l - 1])
                    continue;

                int j = l + 1;
                int k = nums.length - 1;

                while (j < k) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target && j != i && k != j && i != l) {

                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1])
                            j++;
                        while (j < k && nums[k] == nums[k + 1])
                            k--;
                    } else if (sum > target)
                        k--;
                    else
                        j++;
                }
            }
        }
        return ans;
    }
}




// Brute Force
// create 4 nested loop then check all the unique pairs
