// Traverse Pre , In , Post in single iteration

Class Solution{

    class Pair {
        TreeNode node;
        int num;

        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    Public void preInPostTraversal(TreeNode root){

        Stack<Pair> st = new Stack<>(); // for storing pairs
        st.push(new Pair(root, 1));

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if(root == null) return;

        while(!st.isEmpty()){
            Pair it = st.pop(); // it ek variable h jisme pair store h

            // this part is for Pre
            // increase 1 to 2 
            // push the left side of the tree
            if(it.num == 1){
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.left != null){
                    st.push(new Pair(it.node.left,1));
                }
            }

            // this part is for In
            // increase 2 to 3
            // push the right side of tree
            else if(it.num == 2){
                in.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.right != null){
                    st.push(new Pair(it.node.right,1));
                }
            }

            else{
                post.add(it.node.val);
            }
        }
        
    }
}
