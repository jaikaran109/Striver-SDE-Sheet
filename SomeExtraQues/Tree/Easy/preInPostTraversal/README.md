# Preorder, Inorder and Postorder Traversals in One Iteration

This approach is used to find **Preorder, Inorder and Postorder traversals of a Binary Tree in a single iteration** using a **Stack and Pair**.

The main idea is:

> Every node is visited 3 times logically, and each visit has a different state.

---

## 🌳 Example Binary Tree

We will use this **3-level binary tree** for the complete dry run:

```text
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
```

### Levels

```text
Level 1 →        1

Level 2 →      2   3

Level 3 →    4  5 6  7
```

---

# 🔢 Expected Traversals

For the above tree:

### Preorder

**Root → Left → Right**

```text
[1, 2, 4, 5, 3, 6, 7]
```

### Inorder

**Left → Root → Right**

```text
[4, 2, 5, 1, 6, 3, 7]
```

### Postorder

**Left → Right → Root**

```text
[4, 5, 2, 6, 7, 3, 1]
```

---

# 🧠 Main Idea

Normally, we write three separate functions for:

```text
Preorder
Inorder
Postorder
```

But Striver's approach combines all three traversals into **one iteration**.

For this, we use:

```text
Stack<Pair>
```

Each `Pair` stores:

```text
(TreeNode, num)
```

Where:

* `TreeNode` → current node
* `num` → current state of that node

---

# 📦 What is Pair?

We create a Pair class:

```java
class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}
```

So a Pair looks conceptually like:

```text
Pair
 ├── first  → TreeNode
 └── second → state
```

In our implementation:

```text
node → TreeNode
num  → state
```

---

# 🔢 Meaning of num

The most important thing to remember is:

```text
num = 1 → PREORDER
num = 2 → INORDER
num = 3 → POSTORDER
```

Visualize it like this:

```text
        Node
          |
     ┌────┼────┐
     ↓    ↓    ↓
   PRE    IN   POST
    1      2     3
```

Every node passes through these three states.

---

# 💻 Complete Code

```java
class Solution {

    class Pair {
        TreeNode node;
        int num;

        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public void preInPostTraversal(TreeNode root) {

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null) return;

        Stack<Pair> st = new Stack<>();

        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {

            Pair it = st.pop();

            // PREORDER
            if (it.num == 1) {

                pre.add(it.node.val);

                it.num++;
                st.push(it);

                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }

            // INORDER
            else if (it.num == 2) {

                in.add(it.node.val);

                it.num++;
                st.push(it);

                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }

            // POSTORDER
            else {

                post.add(it.node.val);
            }
        }
    }
}
```

---

# 🔍 Understanding the Code

Initially:

```java
st.push(new Pair(root, 1));
```

Our root is:

```text
1
```

So initially:

```text
Stack
┌─────────┐
│ (1, 1)  │
└─────────┘
```

The meaning is:

```text
Node = 1
State = 1
```

Since state is `1`, this means:

```text
PREORDER
```

---

# 🚶 Complete Dry Run

Our tree:

```text
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
```

Initial:

```text
Stack = [(1,1)]

Pre  = []
In   = []
Post = []
```

---

# 🔹 Iteration 1

Stack:

```text
[(1,1)]
```

Pop:

```text
(1,1)
```

Since:

```text
num == 1
```

This is **PREORDER**.

Add `1`:

```text
Pre = [1]
```

Increase state:

```text
(1,1) → (1,2)
```

Push it back:

```text
Stack = [(1,2)]
```

Now push left child `2`:

```text
Stack = [(1,2), (2,1)]
```

Top is:

```text
(2,1)
```

---

# 🔹 Iteration 2

Pop:

```text
(2,1)
```

State is `1`.

Therefore:

```text
PREORDER
```

Add `2`:

```text
Pre = [1,2]
```

Increase state:

```text
(2,1) → (2,2)
```

Push it back:

```text
Stack = [(1,2), (2,2)]
```

Push left child `4`:

```text
Stack = [(1,2), (2,2), (4,1)]
```

Top:

```text
(4,1)
```

---

# 🔹 Iteration 3

Pop:

```text
(4,1)
```

State = `1`

Therefore:

```text
PREORDER
```

Add `4`:

```text
Pre = [1,2,4]
```

Increase state:

```text
(4,1) → (4,2)
```

Push it back:

```text
Stack = [(1,2), (2,2), (4,2)]
```

Node `4` has no left child.

So nothing else is pushed.

---

# 🔹 Iteration 4

Pop:

```text
(4,2)
```

State = `2`

Therefore:

```text
INORDER
```

Add `4`:

```text
In = [4]
```

Increase state:

```text
(4,2) → (4,3)
```

Push it back:

```text
Stack = [(1,2), (2,2), (4,3)]
```

Node `4` has no right child.

---

# 🔹 Iteration 5

Pop:

```text
(4,3)
```

State = `3`.

Therefore:

```text
POSTORDER
```

Add `4`:

```text
Post = [4]
```

Node `4` is now completely finished.

Nothing is pushed.

Stack:

```text
[(1,2), (2,2)]
```

---

# 🔹 Iteration 6

Pop:

```text
(2,2)
```

State = `2`.

Therefore:

```text
INORDER
```

Add `2`:

```text
In = [4,2]
```

Increase state:

```text
(2,2) → (2,3)
```

Push it back:

```text
Stack = [(1,2), (2,3)]
```

Now push right child `5`:

```text
Stack = [(1,2), (2,3), (5,1)]
```

---

# 🔹 Iteration 7

Pop:

```text
(5,1)
```

State = `1`.

Therefore:

```text
PREORDER
```

Add `5`:

```text
Pre = [1,2,4,5]
```

Increase:

```text
(5,1) → (5,2)
```

Push back:

```text
Stack = [(1,2), (2,3), (5,2)]
```

Node `5` has no left child.

---

# 🔹 Iteration 8

Pop:

```text
(5,2)
```

State = `2`.

Therefore:

```text
INORDER
```

Add `5`:

```text
In = [4,2,5]
```

Increase:

```text
(5,2) → (5,3)
```

Push back:

```text
Stack = [(1,2), (2,3), (5,3)]
```

Node `5` has no right child.

---

# 🔹 Iteration 9

Pop:

```text
(5,3)
```

State = `3`.

Therefore:

```text
POSTORDER
```

Add `5`:

```text
Post = [4,5]
```

Node `5` is completely finished.

Stack:

```text
[(1,2), (2,3)]
```

---

# 🔹 Iteration 10

Pop:

```text
(2,3)
```

State = `3`.

Therefore:

```text
POSTORDER
```

Add `2`:

```text
Post = [4,5,2]
```

Node `2` is completely finished.

Stack:

```text
[(1,2)]
```

---

# 🔹 Iteration 11

Pop:

```text
(1,2)
```

State = `2`.

Therefore:

```text
INORDER
```

Add `1`:

```text
In = [4,2,5,1]
```

Increase:

```text
(1,2) → (1,3)
```

Push it back:

```text
Stack = [(1,3)]
```

Now push right child `3`:

```text
Stack = [(1,3), (3,1)]
```

---

# 🔹 Iteration 12

Pop:

```text
(3,1)
```

State = `1`.

Therefore:

```text
PREORDER
```

Add `3`:

```text
Pre = [1,2,4,5,3]
```

Increase:

```text
(3,1) → (3,2)
```

Push it back:

```text
Stack = [(1,3), (3,2)]
```

Push left child `6`:

```text
Stack = [(1,3), (3,2), (6,1)]
```

---

# 🔹 Iteration 13

Pop:

```text
(6,1)
```

State = `1`.

Therefore:

```text
PREORDER
```

Add `6`:

```text
Pre = [1,2,4,5,3,6]
```

Increase:

```text
(6,1) → (6,2)
```

Push back:

```text
Stack = [(1,3), (3,2), (6,2)]
```

Node `6` has no left child.

---

# 🔹 Iteration 14

Pop:

```text
(6,2)
```

State = `2`.

Therefore:

```text
INORDER
```

Add `6`:

```text
In = [4,2,5,1,6]
```

Increase:

```text
(6,2) → (6,3)
```

Push back:

```text
Stack = [(1,3), (3,2), (6,3)]
```

Node `6` has no right child.

---

# 🔹 Iteration 15

Pop:

```text
(6,3)
```

State = `3`.

Therefore:

```text
POSTORDER
```

Add `6`:

```text
Post = [4,5,2,6]
```

Node `6` is completely finished.

Stack:

```text
[(1,3), (3,2)]
```

---

# 🔹 Iteration 16

Pop:

```text
(3,2)
```

State = `2`.

Therefore:

```text
INORDER
```

Add `3`:

```text
In = [4,2,5,1,6,3]
```

Increase:

```text
(3,2) → (3,3)
```

Push it back:

```text
Stack = [(1,3), (3,3)]
```

Push right child `7`:

```text
Stack = [(1,3), (3,3), (7,1)]
```

---

# 🔹 Iteration 17

Pop:

```text
(7,1)
```

State = `1`.

Therefore:

```text
PREORDER
```

Add `7`:

```text
Pre = [1,2,4,5,3,6,7]
```

Increase:

```text
(7,1) → (7,2)
```

Push back:

```text
Stack = [(1,3), (3,3), (7,2)]
```

---

# 🔹 Iteration 18

Pop:

```text
(7,2)
```

State = `2`.

Therefore:

```text
INORDER
```

Add `7`:

```text
In = [4,2,5,1,6,3,7]
```

Increase:

```text
(7,2) → (7,3)
```

Push back:

```text
Stack = [(1,3), (3,3), (7,3)]
```

---

# 🔹 Iteration 19

Pop:

```text
(7,3)
```

State = `3`.

Therefore:

```text
POSTORDER
```

Add `7`:

```text
Post = [4,5,2,6,7]
```

Node `7` is completely finished.

Stack:

```text
[(1,3), (3,3)]
```

---

# 🔹 Iteration 20

Pop:

```text
(3,3)
```

State = `3`.

Therefore:

```text
POSTORDER
```

Add `3`:

```text
Post = [4,5,2,6,7,3]
```

Node `3` is completely finished.

Stack:

```text
[(1,3)]
```

---

# 🔹 Iteration 21

Pop:

```text
(1,3)
```

State = `3`.

Therefore:

```text
POSTORDER
```

Add `1`:

```text
Post = [4,5,2,6,7,3,1]
```

Node `1` is completely finished.

Stack becomes:

```text
[]
```

The loop ends.

---

# 🎯 Final Result

### Preorder

```text
[1,2,4,5,3,6,7]
```

### Inorder

```text
[4,2,5,1,6,3,7]
```

### Postorder

```text
[4,5,2,6,7,3,1]
```

---

# 📊 Complete Dry-Run Summary

| Iteration | Pair  | State | Action | Pre             | In              | Post            |
| --------- | ----- | ----: | ------ | --------------- | --------------- | --------------- |
| 1         | (1,1) |     1 | PRE    | [1]             | []              | []              |
| 2         | (2,1) |     1 | PRE    | [1,2]           | []              | []              |
| 3         | (4,1) |     1 | PRE    | [1,2,4]         | []              | []              |
| 4         | (4,2) |     2 | IN     | [1,2,4]         | [4]             | []              |
| 5         | (4,3) |     3 | POST   | [1,2,4]         | [4]             | [4]             |
| 6         | (2,2) |     2 | IN     | [1,2,4]         | [4,2]           | [4]             |
| 7         | (5,1) |     1 | PRE    | [1,2,4,5]       | [4,2]           | [4]             |
| 8         | (5,2) |     2 | IN     | [1,2,4,5]       | [4,2,5]         | [4]             |
| 9         | (5,3) |     3 | POST   | [1,2,4,5]       | [4,2,5]         | [4,5]           |
| 10        | (2,3) |     3 | POST   | [1,2,4,5]       | [4,2,5]         | [4,5,2]         |
| 11        | (1,2) |     2 | IN     | [1,2,4,5]       | [4,2,5,1]       | [4,5,2]         |
| 12        | (3,1) |     1 | PRE    | [1,2,4,5,3]     | [4,2,5,1]       | [4,5,2]         |
| 13        | (6,1) |     1 | PRE    | [1,2,4,5,3,6]   | [4,2,5,1]       | [4,5,2]         |
| 14        | (6,2) |     2 | IN     | [1,2,4,5,3,6]   | [4,2,5,1,6]     | [4,5,2]         |
| 15        | (6,3) |     3 | POST   | [1,2,4,5,3,6]   | [4,2,5,1,6]     | [4,5,2,6]       |
| 16        | (3,2) |     2 | IN     | [1,2,4,5,3,6]   | [4,2,5,1,6,3]   | [4,5,2,6]       |
| 17        | (7,1) |     1 | PRE    | [1,2,4,5,3,6,7] | [4,2,5,1,6,3]   | [4,5,2,6]       |
| 18        | (7,2) |     2 | IN     | [1,2,4,5,3,6,7] | [4,2,5,1,6,3,7] | [4,5,2,6]       |
| 19        | (7,3) |     3 | POST   | [1,2,4,5,3,6,7] | [4,2,5,1,6,3,7] | [4,5,2,6,7]     |
| 20        | (3,3) |     3 | POST   | [1,2,4,5,3,6,7] | [4,2,5,1,6,3,7] | [4,5,2,6,7,3]   |
| 21        | (1,3) |     3 | POST   | [1,2,4,5,3,6,7] | [4,2,5,1,6,3,7] | [4,5,2,6,7,3,1] |

---

# 🧠 Most Important Visualization

Every node has **3 checkpoints**:

```text
             (1,1)
                |
             PREORDER
                |
             (1,2)
                |
             INORDER
                |
             (1,3)
                |
           POSTORDER
                |
              DONE
```

For node `1`:

```text
(1,1)
  ↓
PREORDER
  ↓
(1,2)
  ↓
INORDER
  ↓
(1,3)
  ↓
POSTORDER
  ↓
DONE
```

The same thing happens for every node.

---

# 🔥 What Happens Between the States?

This is the most important part of the algorithm.

When a node is at:

```text
state = 1
```

We perform:

```text
PREORDER
```

Then:

```text
increase state
push current node again
push left child
```

So:

```text
1 → PRE
      ↓
   state = 2
      ↓
   push left
```

---

When the node comes back with:

```text
state = 2
```

We perform:

```text
INORDER
```

Then:

```text
increase state
push current node again
push right child
```

So:

```text
2 → IN
      ↓
   state = 3
      ↓
   push right
```

---

When the node comes back with:

```text
state = 3
```

We perform:

```text
POSTORDER
```

And the node is finished.

```text
3 → POST
       ↓
     DONE
```

---

# 🌳 Why Does This Work?

Let's understand with node `2`:

```text
        2
       / \
      4   5
```

Node `2` starts with:

```text
(2,1)
```

Since state is `1`:

```text
PREORDER
```

So `2` goes into preorder.

Then:

```text
(2,1) → (2,2)
```

And we process its left subtree:

```text
        2
       /
      4
```

After the left subtree is completely processed, we return to:

```text
(2,2)
```

Now:

```text
INORDER
```

So `2` goes into inorder.

Then:

```text
(2,2) → (2,3)
```

And we process the right subtree:

```text
        2
          \
           5
```

After the right subtree is completely processed, we return to:

```text
(2,3)
```

Now:

```text
POSTORDER
```

So `2` goes into postorder.

Therefore:

```text
             Node 2
                |
        ┌───────┼───────┐
        ↓       ↓       ↓
       PRE      IN     POST
        2        2       2
```

---

# 🧩 Core Intuition

Normally, recursion automatically remembers:

```text
Current Node
    ↓
Process Left
    ↓
Come Back
    ↓
Process Right
    ↓
Come Back
    ↓
Finish Node
```

But in iterative traversal, there is no recursion.

Therefore, we need to manually remember the state.

That is exactly why we use:

```text
Pair(node, state)
```

The state tells us:

```text
What should I do with this node when I pop it?
```

---

# 🔄 Recursion vs Pair State

### Recursion

```text
Node
 ↓
Preorder
 ↓
Left subtree
 ↓
Inorder
 ↓
Right subtree
 ↓
Postorder
```

### Pair Approach

```text
(node,1)
   ↓
PREORDER
   ↓
(node,2)
   ↓
INORDER
   ↓
(node,3)
   ↓
POSTORDER
   ↓
DONE
```

So the Pair is basically replacing the information that recursion normally stores in the **call stack**.

---

# 📌 Final Formula to Remember

```text
             Pair(node, state)
                    |
          ┌─────────┼─────────┐
          ↓         ↓         ↓
       state=1   state=2   state=3
          ↓         ↓         ↓
         PRE        IN       POST
          ↓         ↓         ↓
      push left  push right   done
```

Or simply remember:

```text
1 → Add to PRE → increase state → push left

2 → Add to IN  → increase state → push right

3 → Add to POST → DONE
```

---

# ⚡ One-Line Memory Trick

```text
1 → PRE
2 → IN
3 → POST
```

And:

```text
PRE  → LEFT
IN   → RIGHT
POST → DONE
```

---

# ⏱️ Complexity

Let `N` be the number of nodes.

Each node is processed 3 times logically:

```text
PREORDER
INORDER
POSTORDER
```

But each operation is constant time.

Therefore:

### Time Complexity

```text
O(N)
```

Even though every node has three states, `3N` is still:

```text
O(N)
```

### Space Complexity

The stack stores nodes/states.

In the worst case:

```text
O(N)
```

For a balanced tree, the height is smaller:

```text
O(H)
```

So:

```text
Space = O(H)
```

and in the worst case of a skewed tree:

```text
H = N
```

Therefore:

```text
Worst-case Space = O(N)
```

---

# 🎯 Final Understanding

The complete intuition behind Striver's **Preorder, Inorder and Postorder Traversals in One Traversal** approach is:

```text
Every node has 3 states.

State 1:
    → PREORDER
    → increase state
    → push node
    → push left child

State 2:
    → INORDER
    → increase state
    → push node
    → push right child

State 3:
    → POSTORDER
    → node is DONE
```

The entire algorithm can be remembered as:

```text
             Node
               |
          ┌────┼────┐
          ↓    ↓    ↓
         PRE   IN   POST
          1     2     3
          ↓     ↓     ↓
        LEFT  RIGHT  DONE
```

So instead of writing three separate traversals, we use **one stack, one loop, and a state value** to generate:

```text
Preorder
Inorder
Postorder
```

all together.

The most important line to remember is:

```text
1 → PRE
2 → IN
3 → POST
```

That is the complete intuition behind the **Preorder, Inorder and Postorder Traversals in One Traversal** approach.
