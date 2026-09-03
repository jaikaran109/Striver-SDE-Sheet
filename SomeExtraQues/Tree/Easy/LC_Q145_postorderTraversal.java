// iterative code

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        st1.push(root);

        while (!st1.isEmpty()) {
            TreeNode curr = st1.pop();
            st2.push(curr);

            if (curr.left != null)
                st1.push(curr.left);
            if (curr.right != null)
                st1.push(curr.right);
        }

        while (!st2.isEmpty()) {
            ans.add(st2.pop().val);
        }

        return ans;
    }
}



// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         if(root == null) return list;
        
//         List<Integer> l = postorderTraversal(root.left);
//         List<Integer> r = postorderTraversal(root.right);
//         list.addAll(l);
//         list.addAll(r);
//         list.add(root.val);
//         return list;
//     }
// }
