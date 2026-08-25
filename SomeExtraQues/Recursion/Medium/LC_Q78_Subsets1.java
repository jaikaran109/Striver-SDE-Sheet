class Solution {

    static void helper(int[] nums , List<List<Integer>> ans , int idx , List<Integer> temp){
        if(idx == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        helper(nums,ans,idx+1,temp);
        temp.remove(temp.size() - 1);
        helper(nums,ans,idx+1,temp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,res,0,new ArrayList<>());
        return res;
    }
}
