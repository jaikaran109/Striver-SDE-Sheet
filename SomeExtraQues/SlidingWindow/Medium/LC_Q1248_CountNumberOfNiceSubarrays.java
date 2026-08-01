// Same as Binary Subarrays with sum 

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int lessEqualk = helper(nums,k);
        int kMinus1 = helper(nums,k-1);

        return lessEqualk - kMinus1;
    }

    static int helper(int[] nums , int k){

        if(k < 0) return 0;

        int l = 0 , r = 0 , n = nums.length , count = 0 , sum = 0 ;
        while(r < n){
            sum += nums[r] % 2; // if its odd then +1 and if even then +0 
            while(sum > k){
                sum -= nums[l] % 2;
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}
