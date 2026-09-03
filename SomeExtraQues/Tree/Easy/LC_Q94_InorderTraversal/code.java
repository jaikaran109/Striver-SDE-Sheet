// iterative method - isme stack ka use hua h

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        TreeNode node = root;

        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty()) break;
                node = st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }
}




// Recursive Method
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();

//         if(root == null) return ans;

//         List<Integer> left = inorderTraversal(root.left);
//         List<Integer> right = inorderTraversal(root.right);

//         ans.addAll(left);
//         ans.add(root.val);
//         ans.addAll(right);
        
//         return ans;
//     }
// }
