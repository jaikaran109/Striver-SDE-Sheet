# 🌳 Binary Tree Inorder Traversal — Iterative Approach

This README explains the **Iterative Inorder Traversal** of a Binary Tree using a **Stack**, with a complete visual dry run.

---

## 📌 Code

```java
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
```

---

# 🌳 Example

We will dry run the above code on:

```text
[1,2,3,4,5,null,8,null,null,6,7,9]
```

First, understand the tree represented by this array:

```text
             1
           /   \
          2     3
         / \     \
        4   5     8
           / \   /
          6   7 9
```

## Inorder Traversal

Inorder follows:

```text
Left → Root → Right
```

Expected output:

```text
[4, 2, 6, 5, 7, 1, 3, 9, 8]
```

---

# 🔥 Dry Run of the Code

Initial state:

```text
node = 1
st = []
ans = []
```

---

## 🔹 Step 1 — Keep Going LEFT

Currently:

```text
node = 1
```

Since `node != null`, this code executes:

```java
st.push(node);
node = node.left;
```

Push `1` into the stack:

```text
st = [1]
node = 2
```

Now:

```text
node = 2
```

Again, `node != null`.

Push `2`:

```text
st = [1,2]
node = 4
```

Now:

```text
node = 4
```

Again, `node != null`.

Push `4`:

```text
st = [1,2,4]
node = null
```

Because:

```text
4.left = null
```

Visual:

```text
             1
           /   \
        [2]      3
        /
      [4]

Stack:
┌───┐
│ 4 │  ← Top
├───┤
│ 2 │
├───┤
│ 1 │
└───┘

node = null
ans = []
```

---

## 🔹 Step 2 — `node` is `null` → POP

Now:

```text
node = null
```

So we enter the `else` block:

```java
else{
    if(st.isEmpty()) break;
    node = st.pop();
    ans.add(node.val);
    node = node.right;
}
```

Stack is not empty.

Pop `4`:

```text
st = [1,2]
node = 4
```

Add `4` to the answer:

```text
ans = [4]
```

Then:

```java
node = node.right;
```

Since:

```text
4.right = null
```

We get:

```text
node = null
```

---

## 🔹 Step 3 — POP Again

Again:

```text
node = null
```

Stack:

```text
[1, 2]
```

Stack is not empty, so pop `2`:

```text
st = [1]
node = 2
```

Add `2`:

```text
ans = [4,2]
```

Now:

```java
node = node.right;
```

Since:

```text
2.right = 5
```

We get:

```text
node = 5
```

---

## 🔹 Step 4 — Go LEFT from `5`

Now:

```text
node = 5
```

Push `5`:

```text
st = [1,5]
node = 5.left = 6
```

Now:

```text
node = 6
```

Push `6`:

```text
st = [1,5,6]
node = 6.left = null
```

Visual:

```text
             1
           /   \
          2     3
         / \
        4  [5]
           / \
         [6]  7

Stack:
┌───┐
│ 6 │  ← Top
├───┤
│ 5 │
├───┤
│ 1 │
└───┘

node = null
ans = [4,2]
```

---

## 🔹 Step 5 — POP `6`

Since:

```text
node = null
```

Pop `6`:

```text
st = [1,5]
node = 6
```

Add `6`:

```text
ans = [4,2,6]
```

Then:

```java
node = node.right;
```

Since:

```text
6.right = null
```

We get:

```text
node = null
```

---

## 🔹 Step 6 — POP `5`

Again, `node = null`.

Stack is not empty.

Pop `5`:

```text
st = [1]
node = 5
```

Add `5`:

```text
ans = [4,2,6,5]
```

Now move to the right:

```text
node = 5.right = 7
```

---

## 🔹 Step 7 — Process `7`

Currently:

```text
node = 7
```

Push `7`:

```text
st = [1,7]
```

Move left:

```text
node = 7.left = null
```

Now `node = null`, so pop `7`:

```text
st = [1]
node = 7
```

Add `7`:

```text
ans = [4,2,6,5,7]
```

Move right:

```text
node = 7.right = null
```

So:

```text
node = null
```

---

## 🔹 Step 8 — POP `1`

Currently:

```text
node = null
st = [1]
```

Pop `1`:

```text
st = []
node = 1
```

Add `1`:

```text
ans = [4,2,6,5,7,1]
```

Now move right:

```text
node = 1.right = 3
```

---

## 🔹 Step 9 — Process `3`

Currently:

```text
node = 3
```

`3` has no left child.

So push `3`:

```text
st = [3]
node = null
```

Since `node = null`, pop `3`:

```text
st = []
node = 3
```

Add `3`:

```text
ans = [4,2,6,5,7,1,3]
```

Now move right:

```text
node = 3.right = 8
```

---

## 🔹 Step 10 — Process `8`

Push `8`:

```text
st = [8]
node = 8.left = 9
```

Push `9`:

```text
st = [8,9]
node = null
```

Visual:

```text
             1
           /   \
          2     3
         / \     \
        4   5     8
           / \   /
          6   7 [9]

Stack:
┌───┐
│ 9 │  ← Top
├───┤
│ 8 │
└───┘

ans = [4,2,6,5,7,1,3]
```

Since `node = null`, pop `9`:

```text
st = [8]
node = 9
```

Add `9`:

```text
ans = [4,2,6,5,7,1,3,9]
```

Now:

```text
9.right = null
```

So:

```text
node = null
```

Again, pop `8`:

```text
st = []
node = 8
```

Add `8`:

```text
ans = [4,2,6,5,7,1,3,9,8]
```

Then:

```text
8.right = null
```

So:

```text
node = null
```

---

# 🏁 Final Step

Now:

```text
node = null
st = []
```

The code reaches:

```java
if(st.isEmpty()) break;
```

The stack is empty, so the loop terminates.

---

# ✅ Final Answer

```text
[4, 2, 6, 5, 7, 1, 3, 9, 8]
```

---

# 📊 Complete Dry Run Summary

| Step | Current Node | Stack       | Action              | Answer                        |
| ---- | ------------ | ----------- | ------------------- | ----------------------------- |
| 1    | `1`          | `[1]`       | Push `1`, move left | `[]`                          |
| 2    | `2`          | `[1, 2]`    | Push `2`, move left | `[]`                          |
| 3    | `4`          | `[1, 2, 4]` | Push `4`, move left | `[]`                          |
| 4    | `null`       | `[1, 2]`    | Pop `4`             | `[4]`                         |
| 5    | `null`       | `[1]`       | Pop `2`             | `[4, 2]`                      |
| 6    | `5`          | `[1, 5]`    | Push `5`, move left | `[4, 2]`                      |
| 7    | `6`          | `[1, 5, 6]` | Push `6`, move left | `[4, 2]`                      |
| 8    | `null`       | `[1, 5]`    | Pop `6`             | `[4, 2, 6]`                   |
| 9    | `null`       | `[1]`       | Pop `5`             | `[4, 2, 6, 5]`                |
| 10   | `7`          | `[1, 7]`    | Push `7`, move left | `[4, 2, 6, 5]`                |
| 11   | `null`       | `[1]`       | Pop `7`             | `[4, 2, 6, 5, 7]`             |
| 12   | `null`       | `[]`        | Pop `1`             | `[4, 2, 6, 5, 7, 1]`          |
| 13   | `3`          | `[3]`       | Push `3`, move left | `[4, 2, 6, 5, 7, 1]`          |
| 14   | `null`       | `[]`        | Pop `3`             | `[4, 2, 6, 5, 7, 1, 3]`       |
| 15   | `8`          | `[8]`       | Push `8`, move left | `[4, 2, 6, 5, 7, 1, 3]`       |
| 16   | `9`          | `[8, 9]`    | Push `9`, move left | `[4, 2, 6, 5, 7, 1, 3]`       |
| 17   | `null`       | `[8]`       | Pop `9`             | `[4, 2, 6, 5, 7, 1, 3, 9]`    |
| 18   | `null`       | `[]`        | Pop `8`             | `[4, 2, 6, 5, 7, 1, 3, 9, 8]` |

---

# 🧠 The Important Pattern Behind the Code

The code repeatedly follows this pattern:

```text
Go LEFT → LEFT → LEFT
             ↓
          NULL
             ↓
           POP
             ↓
        Add to ans
             ↓
        Go RIGHT
             ↓
        Again go LEFT
```

This is the complete core idea of iterative inorder traversal.

### For this tree:

```text
             1
           /   \
          2     3
         / \     \
        4   5     8
           / \   /
          6   7 9
```

The nodes are popped in this exact order:

```text
4 → 2 → 6 → 5 → 7 → 1 → 3 → 9 → 8
```

Therefore, the inorder traversal becomes:

```text
[4, 2, 6, 5, 7, 1, 3, 9, 8]
```

---

# 🔑 Core Intuition

The most important thing to understand is:

> **The stack is manually doing the job that recursion's call stack normally does.**

We first keep moving toward the **leftmost node**.

Every node we pass through is saved in the stack because we still need to process it later.

When we finally reach:

```text
node = null
```

we know there is no more left subtree to explore.

Then we:

```text
POP from Stack
        ↓
Visit the node
        ↓
Move to its RIGHT subtree
        ↓
Again go as LEFT as possible
```

This is why the traversal correctly follows:

```text
LEFT → ROOT → RIGHT
```

---

## ⏱️ Complexity

### Time Complexity

```text
O(N)
```

Every node is pushed and popped exactly once.

### Space Complexity

```text
O(H)
```

Where `H` is the height of the tree.

In the worst case of a skewed tree:

```text
O(N)
```
