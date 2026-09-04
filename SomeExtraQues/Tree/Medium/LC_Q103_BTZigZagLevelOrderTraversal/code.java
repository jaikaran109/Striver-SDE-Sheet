class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
    
        if(root == null) return  ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean flag = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            while(size != 0){
                TreeNode curr = q.poll();
                temp.add(curr.val);

                if(curr.left != null){
                    q.offer(curr.left);
                }

                if(curr.right != null){
                    q.offer(curr.right);
                }

                size--;
            }

            if(!flag){
                Collections.reverse(temp);
            }

            ans.add(temp);
            flag = !flag;
            
        }
        return ans;
        
    }
}
