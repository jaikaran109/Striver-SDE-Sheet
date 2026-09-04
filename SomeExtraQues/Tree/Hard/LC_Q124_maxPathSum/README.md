# Binary Tree Maximum Path Sum — Detailed Dry Run

This solution finds the **maximum path sum in a Binary Tree** using recursion.

The most important idea is:

> At every node, we calculate two different things:
>
> 1. The maximum path that can be **returned to the parent**
> 2. The maximum path that can exist **through the current node**

---

# 🌳 Example Binary Tree

We will use this tree:

```text
                 -10
                /   \
               9     20
                    /  \
                   15   7
```

This tree contains a negative value:

```text
-10
```

which will help us understand why we use:

```java
Math.max(0, helper(...))
```

---

# 🎯 Expected Maximum Path

The maximum path is:

```text
15 → 20 → 7
```

Its sum is:

```text
15 + 20 + 7 = 42
```

Therefore:

```text
Maximum Path Sum = 42
```

---

# 💻 Code

```java
// if you still have any confusion , go and watch Strivers video

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(root , max);
        return max[0];
    }

    int helper(TreeNode root , int[] max){
        if(root == null) return 0;

        int left = Math.max(0 , helper(root.left , max));
        int right = Math.max(0 , helper(root.right , max));

        max[0] = Math.max(max[0] , (left + right + root.val));

        return Math.max(left , right) + root.val;
    }
}
```

---

# 🧠 First Understand What is a Path?

A path in a binary tree is a sequence of nodes connected by edges.

For example:

```text
15 → 20 → 7
```

is a valid path.

Its sum is:

```text
15 + 20 + 7 = 42
```

But this:

```text
15 → 20 → 7
         ↓
        -10
```

is not a valid path because you cannot branch down from `20` and then come back to `-10`.

---

# 🔥 Most Important Concept

At every node, we calculate:

```text
left
right
```

Then we consider:

```text
left + root.val + right
```

This represents a path that:

```text
Left Subtree
      ↓
    Root
      ↓
Right Subtree
```

So:

```java
left + right + root.val
```

can form a complete path passing through the current node.

---

# ❓ But Why Do We Use Math.max(0, ...)?

This is the most important part:

```java
int left = Math.max(0 , helper(root.left , max));

int right = Math.max(0 , helper(root.right , max));
```

Why `0`?

Because if a subtree gives us a **negative contribution**, we don't want to include it.

For example:

```text
        20
       /
     -5
```

If we include `-5`:

```text
20 + (-5) = 15
```

But if we don't take that subtree:

```text
20
```

is better.

Therefore:

```text
max(0, -5) = 0
```

So we simply ignore the negative path.

---

# 🔍 Two Important Values

This solution uses two different calculations.

## 1. Maximum Path Through Current Node

```java
left + right + root.val
```

This can use:

```text
Left subtree
+
Current node
+
Right subtree
```

Example:

```text
        20
       /  \
      15   7
```

Then:

```text
15 + 20 + 7 = 42
```

This is a complete path.

---

## 2. Value Returned to Parent

We return:

```java
Math.max(left, right) + root.val
```

Why only one side?

Because if the current node connects to its parent, the path cannot branch into both left and right.

For example:

```text
             Parent
                |
               20
              /  \
             15   7
```

If `20` returns to its parent, it can return only:

```text
15 → 20
```

or:

```text
7 → 20
```

It cannot return:

```text
15 → 20 → 7
```

because that would create a branch at `20`.

Therefore:

```java
return Math.max(left, right) + root.val;
```

---

# 🚶 Complete Dry Run

Our tree:

```text
                 -10
                /   \
               9     20
                    /  \
                   15   7
```

Let's start from:

```text
root = -10
```

Initially:

```java
max[0] = Integer.MIN_VALUE;
```

Conceptually:

```text
max = -∞
```

---

# 🔹 Step 1 — Start at -10

We call:

```text
helper(-10, max)
```

Since `-10` is not null, we first calculate its left subtree:

```text
helper(9, max)
```

We haven't calculated anything for `-10` yet.

---

# 🔹 Step 2 — Node 9

Tree:

```text
        9
```

Call:

```text
helper(9, max)
```

Node `9` has no left child.

So:

```java
helper(null, max)
```

returns:

```text
0
```

Therefore:

```java
left = Math.max(0, 0)
```

So:

```text
left = 0
```

Now we calculate the right child.

Again:

```text
helper(null, max)
```

returns:

```text
0
```

Therefore:

```text
right = 0
```

---

## Calculate Maximum Path Through 9

```java
left + right + root.val
```

becomes:

```text
0 + 0 + 9
```

Therefore:

```text
9
```

Update:

```text
max = max(-∞, 9)
```

So:

```text
max = 9
```

---

## What Does Node 9 Return?

We use:

```java
return Math.max(left, right) + root.val;
```

Therefore:

```text
max(0, 0) + 9
```

```text
= 9
```

So node `9` returns:

```text
9
```

to its parent `-10`.

---

# 🔹 Step 3 — Back to -10

Now:

```text
left = 9
```

because node `9` returned `9`.

So:

```text
left = Math.max(0, 9)
```

Therefore:

```text
left = 9
```

Current situation:

```text
                 -10
                /
               9

left = 9
```

Now we process the right subtree:

```text
helper(20, max)
```

---

# 🔹 Step 4 — Node 20

Tree:

```text
        20
       /  \
      15   7
```

We call:

```text
helper(20, max)
```

First, calculate the left subtree:

```text
helper(15, max)
```

---

# 🔹 Step 5 — Node 15

Tree:

```text
15
```

No left child:

```text
helper(null, max) → 0
```

Therefore:

```text
left = max(0, 0)
     = 0
```

No right child:

```text
helper(null, max) → 0
```

Therefore:

```text
right = max(0, 0)
      = 0
```

---

## Calculate Path Through 15

```text
left + right + root.val
```

```text
0 + 0 + 15
```

```text
= 15
```

Current max:

```text
max = max(9, 15)
```

Therefore:

```text
max = 15
```

---

## Return Value from 15

```text
max(left, right) + root.val
```

```text
max(0, 0) + 15
```

```text
= 15
```

So:

```text
15 → returns 15
```

to node `20`.

---

# 🔹 Step 6 — Back to 20

Now:

```text
left = 15
```

because node `15` returned `15`.

Then we calculate the right subtree:

```text
helper(7, max)
```

---

# 🔹 Step 7 — Node 7

Tree:

```text
7
```

No left child:

```text
helper(null, max) → 0
```

Therefore:

```text
left = 0
```

No right child:

```text
helper(null, max) → 0
```

Therefore:

```text
right = 0
```

---

## Calculate Path Through 7

```text
left + right + root.val
```

```text
0 + 0 + 7
```

```text
= 7
```

Update:

```text
max = max(15, 7)
```

Therefore:

```text
max = 15
```

---

## Return Value from 7

```text
max(left, right) + root.val
```

```text
max(0, 0) + 7
```

```text
= 7
```

So:

```text
7 → returns 7
```

to node `20`.

---

# 🔹 Step 8 — Back to 20

Now we have:

```text
left = 15
right = 7
```

Tree:

```text
        20
       /  \
      15   7
```

Now calculate:

```java
left + right + root.val
```

Substitute:

```text
15 + 7 + 20
```

Therefore:

```text
42
```

🔥 This represents the path:

```text
15 → 20 → 7
```

---

# 🏆 Update Global Maximum

Before:

```text
max = 15
```

Now:

```text
max = max(15, 42)
```

Therefore:

```text
max = 42
```

This is currently the best path.

---

# 🔹 What Does Node 20 Return?

Now we need to return something to `-10`.

We cannot return:

```text
15 + 20 + 7
```

because that would contain both left and right branches.

Therefore:

```java
return Math.max(left, right) + root.val;
```

becomes:

```text
max(15, 7) + 20
```

```text
15 + 20
```

```text
= 35
```

So:

```text
20 → returns 35
```

to `-10`.

---

# 🔹 Step 9 — Back to -10

Now the root `-10` has received:

```text
left = 9
right = 35
```

Tree:

```text
                 -10
                /   \
               9     20
                    /  \
                   15   7
```

Now calculate the path passing through `-10`:

```java
left + right + root.val
```

Substitute:

```text
9 + 35 + (-10)
```

Therefore:

```text
34
```

---

# ❗ Notice Something Important

We already had:

```text
max = 42
```

Now:

```text
34
```

is smaller.

Therefore:

```text
max = max(42, 34)
```

So:

```text
max = 42
```

---

# 🔹 What Does -10 Return?

Now:

```java
return Math.max(left, right) + root.val;
```

becomes:

```text
max(9, 35) + (-10)
```

```text
35 - 10
```

```text
= 25
```

So root `-10` returns:

```text
25
```

But we don't actually care about this returned value because `-10` is the root and has no parent.

The important result is:

```text
max = 42
```

---

# 🎯 Final Answer

Therefore:

```text
Maximum Path Sum = 42
```

The path is:

```text
15 → 20 → 7
```

Calculation:

```text
15 + 20 + 7 = 42
```

---

# 📊 Complete Dry-Run Summary

| Node | Left | Right | Path Through Node | Global Max | Returned Value |
| ---- | ---: | ----: | ----------------: | ---------: | -------------: |
| 9    |    0 |     0 |                 9 |          9 |              9 |
| 15   |    0 |     0 |                15 |         15 |             15 |
| 7    |    0 |     0 |                 7 |         15 |              7 |
| 20   |   15 |     7 |                42 |         42 |             35 |
| -10  |    9 |    35 |                34 |         42 |             25 |

Final:

```text
max = 42
```

---

# 🧠 Most Important Part of the Code

These two lines are the heart of the solution:

```java
int left = Math.max(0 , helper(root.left , max));

int right = Math.max(0 , helper(root.right , max));
```

Why?

Because:

```text
Negative contribution → Ignore it
Positive contribution → Take it
```

For example:

```text
left = -5
```

Then:

```text
Math.max(0, -5)
```

gives:

```text
0
```

So we don't include `-5`.

---

# 🔥 Why Do We Initialize max with Integer.MIN_VALUE?

We write:

```java
int[] max = new int[1];
max[0] = Integer.MIN_VALUE;
```

Why not:

```text
max = 0
```

Because the entire tree could contain **only negative values**.

Example:

```text
       -3
      /  \
    -5   -2
```

The answer is:

```text
-2
```

not:

```text
0
```

If we initialized `max = 0`, we could incorrectly return `0`.

Therefore we use:

```java
Integer.MIN_VALUE
```

so that even a negative answer can replace it.

---

# 🧩 Important Difference: `left/right` vs `max`

There are two separate ideas.

### `left` and `right`

These represent the contribution that can be used from the subtree.

Therefore:

```java
Math.max(0, helper(...))
```

is used.

Negative contribution is discarded.

---

### `max[0]`

This represents the **best complete path found anywhere in the tree**.

Therefore, we should not force it to be `0`.

That's why:

```java
max[0] = Integer.MIN_VALUE;
```

---

# 🔄 Why `max[0]` Is an Array?

Java passes primitive `int` values by value.

If we wrote:

```java
int helper(TreeNode root, int max)
```

and changed `max` inside recursion, the updated value would not be available to all recursive calls.

So we use:

```java
int[] max = new int[1];
```

Then every recursive call accesses the same array:

```java
max[0]
```

Conceptually:

```text
                 max[0]
                   ↑
        ┌──────────┼──────────┐
        │          │          │
      node 9     node 20    node -10
        │          │          │
        └──────────┼──────────┘
                   ↓
             same max value
```

---

# 🌳 The Core Pattern

At every node:

```text
                Node
                 |
        ┌────────┴────────┐
        ↓                 ↓
      LEFT              RIGHT
        ↓                 ↓
 max(0,left)         max(0,right)
        \                 /
         \               /
          \             /
           ↓           ↓
          LEFT + NODE + RIGHT
                  ↓
             Update MAX
                  ↓
          Return only ONE side
```

---

# 🚨 Why Return Only One Side?

This is one of the most important interview concepts.

Suppose:

```text
             Parent
                |
               20
              /  \
             15   7
```

At node `20`, we can create a complete path:

```text
15 → 20 → 7
```

So for the global answer:

```text
15 + 20 + 7 = 42
```

But if `20` needs to return a path to its parent:

```text
             Parent
                |
               20
              /  \
             15   7
```

It can return:

```text
15 → 20
```

or:

```text
7 → 20
```

but NOT:

```text
15 → 20 → 7
```

because that branches.

Therefore:

```java
return Math.max(left, right) + root.val;
```

---

# 🎯 Two Different Formulas

Remember these two formulas:

## Formula 1 — Update Global Maximum

```java
left + right + root.val
```

Meaning:

```text
Take both sides
```

This can form a complete path through the current node.

---

## Formula 2 — Return to Parent

```java
Math.max(left, right) + root.val
```

Meaning:

```text
Take only the better side
```

because the parent can continue the path through the current node.

---

# 🧠 One-Line Memory Trick

```text
GLOBAL ANSWER
    ↓
LEFT + ROOT + RIGHT

RETURN TO PARENT
    ↓
MAX(LEFT, RIGHT) + ROOT
```

---

# ⚡ Why `Math.max(0, ...)`?

Remember:

```text
Negative path = Don't take it
Positive path = Take it
```

Therefore:

```java
left = Math.max(0, helper(root.left, max));
right = Math.max(0, helper(root.right, max));
```

Example:

```text
left = -10
```

Then:

```text
max(0, -10) = 0
```

So the node effectively says:

> "I'd rather not take this subtree."

---

# 🧠 Complete Algorithm in Simple Words

For every node:

```text
1. Find the best path coming from left subtree.

2. If left contribution is negative,
   ignore it by taking 0.

3. Find the best path coming from right subtree.

4. If right contribution is negative,
   ignore it by taking 0.

5. Calculate:
      left + root + right

6. Update the global maximum.

7. Return:
      max(left, right) + root
```

---

# 🔥 Complete Visualization

```text
                         Node
                           |
                ┌──────────┴──────────┐
                ↓                     ↓
          helper(left)          helper(right)
                ↓                     ↓
          max(0, left)           max(0, right)
                ↓                     ↓
                └──────────┬──────────┘
                           ↓
                 left + root + right
                           ↓
                    Update global max
                           ↓
                max(left, right) + root
                           ↓
                      Return to parent
```

---

# ⏱️ Complexity

Let `N` be the number of nodes.

Every node is visited once.

Therefore:

### Time Complexity

```text
O(N)
```

### Space Complexity

The recursion stack depends on the height of the tree.

```text
O(H)
```

For a balanced tree:

```text
H = log(N)
```

So:

```text
O(log N)
```

For a completely skewed tree:

```text
H = N
```

So worst case:

```text
O(N)
```

---

# 🏆 Final Understanding

The complete intuition behind this problem is:

```text
At every node:

LEFT CONTRIBUTION
        +
    CURRENT NODE
        +
RIGHT CONTRIBUTION
        ↓
Possible complete path
        ↓
Update global MAX
```

But when returning to the parent:

```text
MAX(LEFT, RIGHT)
        +
    CURRENT NODE
        ↓
Return one-sided path
```

And negative paths are ignored:

```text
Math.max(0, contribution)
```

because:

```text
Negative contribution only decreases the path sum.
```

---

# 📌 Final Formula

```text
left  = max(0, left subtree)
right = max(0, right subtree)

max = max(max, left + root + right)

return max(left, right) + root
```

The easiest way to remember the entire solution is:

```text
          LEFT + ROOT + RIGHT
                   ↓
              GLOBAL MAX

          MAX(LEFT, RIGHT) + ROOT
                   ↓
             RETURN TO PARENT
```

And:

```text
Negative contribution → 0
Positive contribution → Keep it
```

For our tree:

```text
                 -10
                /   \
               9     20
                    /  \
                   15   7
```

the best path is:

```text
15 → 20 → 7
```

and:

```text
15 + 20 + 7 = 42
```

Therefore:

```text
Maximum Path Sum = 42
```

This is the complete intuition behind the **Binary Tree Maximum Path Sum** solution.
