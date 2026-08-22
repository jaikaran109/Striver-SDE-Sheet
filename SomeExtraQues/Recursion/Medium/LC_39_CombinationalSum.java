class Solution {

    static List<List<Integer>> subsequences(int[] nums , int target , int idx , int currSum , List<Integer> ans){
        List<List<Integer>> temp ;
        if(currSum == target){
            temp = new ArrayList<>();
            temp.add(new ArrayList<>(ans));     //ans ek hi mutable ArrayList hai aur backtracking mein baar-baar change ho raha hai. Isliye result mein direct reference store nahi karna chahiye.

            return temp;
        }
        
        if(idx == nums.length || currSum > target) {   // array Finish or sum exceeded
            return new ArrayList<>(); 
        }

        ans.add(nums[idx]); // add current element 
 
        List<List<Integer>> left = subsequences(nums,target,idx,currSum+nums[idx],ans);

        ans.remove(ans.size() - 1); // Backtrack

        List<List<Integer>> right = subsequences(nums,target,idx+1,currSum,ans);

        left.addAll(right);
        return left;

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return subsequences(candidates,target,0,0,new ArrayList<>());
    }
}
