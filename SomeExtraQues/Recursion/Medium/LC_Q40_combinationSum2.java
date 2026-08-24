class Solution {

    private void sum(int idx ,int[] nums , int target ,List<List<Integer>> ans , List<Integer> ds){
        
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx ; i < nums.length ; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;

            ds.add(nums[i]);
            sum(i+1,nums,target - nums[i],ans,ds); 
            ds.remove(ds.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        sum(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}

