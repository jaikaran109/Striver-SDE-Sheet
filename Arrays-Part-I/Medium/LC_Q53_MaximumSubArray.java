// Kadane's Algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum  += nums[i];
            max = Math.max(sum,max);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
// Time - O(n)
// Space - O(1)




// IF YOU WANT THE SUBARRAY ALSO 
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int max = Integer.MIN_VALUE;
//         int sum = 0;

//         int start = 0;
//         int ansStart = 0;
//         int ansEnd = 0;

//         for (int i = 0; i < nums.length; i++) {

//             sum += nums[i];

//             if (sum > max) {
//                 max = sum;
//                 ansStart = start;
//                 ansEnd = i;
//             }

//             if (sum < 0) {
//                 sum = 0;
//                 start = i + 1;
//             }
//         }

//         System.out.println("Start Index: " + ansStart);
//         System.out.println("End Index: " + ansEnd);

//         return max;
//     }
// }



// Better 
// Remove k from Brute Force
// in j sum += arr[j] and update max simultaneously

// Time - O(n^2)
// Space - O(1)





// Brute Force 
// Starting me max = minValue
// i = 0 - n;
// j = i - n 
// k = i - j
//  Sum += arr[k]
// update max after k in j

// Time - O(n^3)
// Space - O(1)
