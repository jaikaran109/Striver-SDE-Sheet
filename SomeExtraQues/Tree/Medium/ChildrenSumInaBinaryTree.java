class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root == null) return true;
        if(root != null && (root.left != null ||  root.right != null )) {
            int left = (root.left != null) ? root.left.data : 0;
            int right = (root.right != null) ? root.right.data : 0;

            if (root.data != left + right) return false;
        }
        return isSumProperty(root.left) && isSumProperty(root.right);
        
    }
}
