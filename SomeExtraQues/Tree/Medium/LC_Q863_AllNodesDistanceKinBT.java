// watch striver video

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        findParent(root, null, parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (distance == k) {
                List<Integer> list = new ArrayList<>();
                for (TreeNode node : q) {
                    list.add(node.val);
                }
                return list;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.offer(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.offer(node.right);
                }

                if (parent.get(node) != null && !visited.contains(parent.get(node))) {
                    visited.add(parent.get(node));
                    q.offer(parent.get(node));
                }
            }

            distance++;
        }

        return new ArrayList<>();
    }

    private void findParent(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;

        parent.put(node, par);
        findParent(node.left, node, parent);
        findParent(node.right, node, parent);
    }
}
