class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < 2 * n ; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i % n]){
                res[st.pop()] = nums[i % n];
            }
            if(i < n) st.push(i);
        }
        return res;
    }
}
