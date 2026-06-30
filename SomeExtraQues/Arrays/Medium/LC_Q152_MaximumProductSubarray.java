class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;

        int pref = 1 , suff = 1;

        for(int i = 0 ; i < nums.length ; i++){
            if(pref == 0) pref = 1;  // jb 0 mile to 1 se start kro 
            if(suff == 0) suff = 1;

            pref *= nums[i];
            suff *= nums[nums.length - 1 - i];

            max = Math.max(max,Math.max(pref,suff));

        }
        return max;

        // iss code ko dry run kro samjh aa jayega 
        
    }
}



// Better
// class Solution {
//     public int maxProduct(int[] nums) {
//         int max = Integer.MIN_VALUE;

//         for(int i = 0 ; i < nums.length ; i++){
//             int  product = 1;
//             for(int j = i ; j < nums.length ; j++){
//                 product *= nums[j];
//                 max = Math.max(max,product);
//             }
//         }
//         return max;
//     }
// }

// Time - O(n^2)
// Space - O(1)



// Brute Force
// inside j of Better Approach run another loop from k = i -- < j and place product = 1 after j  and prod *= nums[k] and update max after k in j 
// Time - O(n^3)
// Space - O(1)
