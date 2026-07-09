class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
             if(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.removeLast();
            }

            dq.addLast(i);

            if(i >= k - 1) {
                ans[j++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}



/*
// Brute Force - TLE

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - (k - 1)];

        for(int i = 0 ; i < nums.length - (k - 1); i++){
            int max = Integer.MIN_VALUE;
            for(int j = i ; j < i + k ; j++){
                max = Math.max(max,nums[j]);
            }
            ans[i] = max;
        }
        return ans;
    }
}


// Time: O(n * k)
// Space: O(n - k + 1)
*/
