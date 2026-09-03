// Iterative Code - isme recursion use nhi hota h , stack use hota h
// iska beat km h bhai 

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        preorder(root,st,ans);

        System.out.print(ans);
        return ans;
    }

    void preorder(TreeNode root , Stack<TreeNode> st , List<Integer> ans){
        if(root == null) return;

        st.add(root);

        while(!st.isEmpty()){

            TreeNode curr = st.pop();
            
            ans.add(curr.val);

            if(curr.right != null){  // dekho yha right wala phle le rhe h kyuki stack me LIFO hota h na isiliye left wala baad me jayega to phle execute hoga
                st.add(curr.right);
            }
            if(curr.left != null){
                st.add(curr.left);
            }

        }

    }
}



// Recursion

// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         if(root == null) return list;
//         list.add(root.val);
//         List<Integer> l = preorderTraversal(root.left);
//         List<Integer> r = preorderTraversal(root.right);
//         list.addAll(l);
//         list.addAll(r);
//         return list;
//     }
// }
