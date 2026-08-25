class Solution {

    static void helper(int[] nums , List<List<Integer>> ans , int idx , List<Integer> temp){
        if(idx == nums.length){
            if(!ans.contains(temp))
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        helper(nums,ans,idx+1,temp);
        temp.remove(temp.size() - 1);
        helper(nums,ans,idx+1,temp);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);      // isko kr lena nhi to 414 and 441 ye dono alg alg count hoga but expected me single count hona chahiye
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,res,0,new ArrayList<>());
        return res;
    }
}
