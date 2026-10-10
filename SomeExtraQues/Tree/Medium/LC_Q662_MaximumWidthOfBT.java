// watch strivers video for better understanding

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;   // agr root null the width 0 

        Queue<TreeNode> q = new LinkedList<>(); // nodes ke liye
        Queue<Integer> idx = new LinkedList<>(); // idx ke liye

        q.offer(root); // root push kr do
        idx.offer(0); // idx 0 push kr do

        int maxWidth = 0; 

        while (!q.isEmpty()) {  
            int size = q.size(); // initial 1 , then increase further
            int first = idx.peek(); // initial 0 , then  increase further
            int last = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();  // pop
                int index = idx.poll() - first; // curr idx lo aur 

                last = index; // ab dekho logic ke acc tmko hrr level pe idxing 0 se start krni h soo last idx pick kro and aage ke operations perform kro

                if (node.left != null) { // push left node -- q size increases common sense 
                    q.offer(node.left);
                    idx.offer(2 * index + 1);
                }

                if (node.right != null) {  // push right node -- q size increases common sense 
                    q.offer(node.right);
                    idx.offer(2 * index + 2);
                }
            }

            maxWidth = Math.max(maxWidth, last + 1);  // update maxlen
        }

        return maxWidth;
    }
}



/*
Approach: BFS (Level Order Traversal) using Queue

1. Use two queues: one to store tree nodes and another to store their positional indices.

2. Assign indices as if the tree were a complete binary tree:
   - Root: 0
   - Left child: 2 * index + 1
   - Right child: 2 * index + 2

3. We cannot simply count nodes as 1, 2, 3, ... N because the problem
   counts missing positions (null gaps) between the leftmost and rightmost
   nodes, not just the number of existing nodes.

4. At each level, store the first node's index and subtract it from every
   index at that level. This normalization keeps indices small while
   preserving the gaps between nodes.

5. Since the first normalized index is 0, calculate the level width as:
   width = lastIndex - firstIndex + 1 = lastIndex + 1

6. Update the maximum width after processing each level and return it
   after the traversal is complete.

Time Complexity: O(N)
Space Complexity: O(N)
*/
