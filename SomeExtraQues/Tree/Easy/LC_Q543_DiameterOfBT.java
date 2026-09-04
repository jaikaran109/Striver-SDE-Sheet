class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root,diameter);
        return diameter[0];

    }
    int height(TreeNode root , int[] dia){

        if(root == null) return 0;

        int left = height(root.left,dia);
        int right = height(root.right,dia);

        dia[0] = Math.max(dia[0],left + right);

        return 1 + Math.max(left,right);

    }
}
// TC - O(N)




// Brute Force

// class Solution {

//     int max = 0;

//     int height(TreeNode root){
//         if(root == null) return 0;
//         return 1 + Math.max(height(root.left),height(root.right));
//     }

//     public int diameterOfBinaryTree(TreeNode root) {
//         if(root == null || (root.left == null && root.right == null)) return 0;
//         int left = height(root.left);
//         int right = height(root.right);

//         max = Math.max(max,left+right);

//         diameterOfBinaryTree(root.left);
//         diameterOfBinaryTree(root.right);

//         return max;
//     }
// }

// TIme - O(n^2)
