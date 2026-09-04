# Maximum Depth of Binary Tree

Two Java solutions to find the **maximum depth (height)** of a binary tree — one recursive (DFS), one iterative (BFS level-order).

## Problem Statement

Given the root of a binary tree, return its **maximum depth** — the number of nodes along the longest path from the root node down to the farthest leaf node.

**Example tree (depth = 4, not a complete binary tree):**
```
            1
          /   \
         2     3
        / \     \
       4   5     8
          / \   /
         6   7 9
```
Expected output: **4** (longest path: `1 → 2 → 5 → 6/7`, or `1 → 3 → 8 → 9`)

## Approach 1: Recursive (DFS)

```java
class Solution {
    public int maxDepth(TreeNode root) {
        
        // Base case: agar node hi nahi hai (null), 
        // uski depth 0 maani jaati hai
        if(root == null) return 0;

        // Recursive case:
        // left subtree ki depth nikalo
        // right subtree ki depth nikalo
        // dono me se jo bada hai wo lo, +1 current node ke liye
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
```

**Core idea:** `depth(node) = 1 + max(depth(left subtree), depth(right subtree))`. A `null` node contributes depth `0`, which is what stops the recursion.

### Trace (bottom-up)

| Node(s) | Formula | Result |
|---|---|---|
| 4, 6, 7, 9 (leaves) | `1 + max(0,0)` | **1** |
| 5 | `1 + max(maxDepth(6), maxDepth(7))` = `1 + max(1,1)` | **2** |
| 8 | `1 + max(maxDepth(9), maxDepth(null))` = `1 + max(1,0)` | **2** |
| 2 | `1 + max(maxDepth(4), maxDepth(5))` = `1 + max(1,2)` | **3** |
| 3 | `1 + max(maxDepth(null), maxDepth(8))` = `1 + max(0,2)` | **3** |
| **1 (root)** | `1 + max(maxDepth(2), maxDepth(3))` = `1 + max(3,3)` | **4** |

Each level's result feeds into `Math.max()` one level up, all the way back to the root — this is exactly what happens on the call stack as recursive calls return.

### Complexity

| Metric | Value | Why |
|---|---|---|
| Time | O(n) | Every node is visited exactly once |
| Space | O(h) | Recursion stack depth = height of tree `h` (worst case O(n) for a skewed tree, O(log n) for a balanced tree) |

## Approach 2: Iterative (BFS — Level Order)

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            depth++;
        }

        return depth;
    }
}
```

**Core idea:** Process the tree **one full level at a time** using a queue. Each pass through the `while` loop = one level fully processed = `depth++`.

- `size = queue.size()` snapshots how many nodes are in the **current level** before processing, so the `for` loop only handles that level's nodes (not ones added by them).
- For each node in the level, remove it (`poll`) and add its children to the queue for the next level.
- After finishing a full level, increment `depth`.
- Loop ends when the queue is empty (no more levels).

### Complexity

| Metric | Value | Why |
|---|---|---|
| Time | O(n) | Every node is visited exactly once |
| Space | O(w) | `w` = maximum width of the tree (widest level), for the queue |

## Comparison

| Aspect | Recursive (DFS) | Iterative (BFS) |
|---|---|---|
| Time | O(n) | O(n) |
| Space | O(h) — height | O(w) — max width |
| Style | Shorter, relies on call stack | Explicit queue, no recursion |
| Risk | Can stack-overflow on very deep/skewed trees | No stack overflow risk |
