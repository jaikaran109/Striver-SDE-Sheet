// if you still have any confusion , go and watch Strivers video

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(root , max);
        return max[0];
    }
    int helper(TreeNode root , int[] max){
        if(root == null) return 0;
        int left = Math.max(0 , helper(root.left , max));  // yha hm 0 rakh rhe h kyuki hmko negative values consider hi nhi krni h 
        int right = Math.max(0 , helper(root.right , max));

        max[0] = Math.max(max[0] , (left + right + root.val));

        return Math.max(left , right) + root.val;
    }
}
