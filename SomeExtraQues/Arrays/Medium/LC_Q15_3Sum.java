class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int j = i + 1 ;
            int k = nums.length - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0 && j != i && k != j){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }else if(sum > 0) k--;
                else j++;
            }
        }
        return ans;
    }
}





// Brute Force 
// --Array Sort kr ke - 3 loop use kro , jb sum = 0 ho to check kro phle se h ki nhi and last me list print kr do 

// optimal 
// int k = -( arr[i] + arr[j] ) ye calculate kro aur check kro set me h ya nhi agr ho to set mil gya nhi h to aage dekho -- for better understanding Striver 3 Sum lecture
