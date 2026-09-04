# Zigzag Level Order Traversal — Detailed Dry Run

This solution finds the **Zigzag Level Order Traversal** of a Binary Tree using a **Queue**.

The main idea is:

> Traverse the tree level by level using a Queue, but alternate the direction of every level.

That means:

```text
Level 1 → Left → Right
Level 2 → Right → Left
Level 3 → Left → Right
Level 4 → Right → Left
...
```

---

# 🌳 Example Binary Tree

We will use this tree for the complete dry run:

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

# 🎯 Expected Zigzag Traversal

Normal Level Order would be:

```text
[1]
[2, 3]
[4, 5, 6, 7]
```

But Zigzag Level Order alternates the direction:

```text
Level 1 → Left → Right
Level 2 → Right → Left
Level 3 → Left → Right
```

Therefore:

```text
[
    [1],
    [3, 2],
    [4, 5, 6, 7]
]
```

---

# 💻 Complete Code

```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

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
```

---

# 🧠 Main Idea

This solution uses:

```text
Queue + Flag
```

The Queue is responsible for:

```text
Level Order Traversal
```

And the `flag` is responsible for:

```text
Zigzag Direction
```

---

# 📦 Why Do We Need a Queue?

A Queue follows:

```text
FIFO

First In
First Out
```

So when we insert:

```text
1
2
3
```

we remove them in the same order:

```text
1 → 2 → 3
```

This makes Queue perfect for **Level Order Traversal**.

---

# 🚩 Meaning of flag

We have:

```java
boolean flag = true;
```

We use:

```text
flag = true
```

for normal direction:

```text
Left → Right
```

And:

```text
flag = false
```

for reverse direction:

```text
Right → Left
```

After every level:

```java
flag = !flag;
```

This changes:

```text
true → false
false → true
true → false
...
```

Therefore the direction alternates.

---

# 🔥 Why Do We Use `Collections.reverse(temp)`?

This is an important part.

The Queue always gives us nodes in:

```text
Left → Right
```

order.

For example, level 2 gives:

```text
[2, 3]
```

But zigzag requires:

```text
[3, 2]
```

Instead of changing how we insert children into the Queue, we simply reverse the current level:

```java
if(!flag){
    Collections.reverse(temp);
}
```

So:

```text
[2, 3]
```

becomes:

```text
[3, 2]
```

The Queue itself still works normally.

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

Initially:

```text
ans = []
```

Root is not null.

So:

```java
Queue<TreeNode> q = new LinkedList<>();
```

Then:

```java
q.offer(root);
```

Queue becomes:

```text
Queue
┌───┐
│ 1 │
└───┘
```

And:

```text
flag = true
```

Meaning:

```text
Current direction = Left → Right
```

---

# 🔹 Iteration 1 — Level 1

We enter:

```java
while(!q.isEmpty())
```

Queue:

```text
[1]
```

Now:

```java
int size = q.size();
```

Therefore:

```text
size = 1
```

Create:

```java
List<Integer> temp = new ArrayList<>();
```

So:

```text
temp = []
```

---

## Process Node 1

Inside:

```java
while(size != 0)
```

We execute:

```java
TreeNode curr = q.poll();
```

Node removed:

```text
1
```

Queue becomes:

```text
[]
```

Add it to `temp`:

```java
temp.add(curr.val);
```

Therefore:

```text
temp = [1]
```

---

## Add Children of 1

Node `1` has:

```text
left  = 2
right = 3
```

So:

```java
q.offer(curr.left);
```

Queue:

```text
[2]
```

Then:

```java
q.offer(curr.right);
```

Queue:

```text
[2, 3]
```

Now:

```text
size--
```

Therefore:

```text
size = 0
```

Inner loop ends.

---

# 🚩 Check flag

Currently:

```text
flag = true
```

Therefore:

```java
if(!flag)
```

is:

```text
if(false)
```

So we **do not reverse**.

Therefore:

```text
temp = [1]
```

Add to answer:

```java
ans.add(temp);
```

So:

```text
ans = [
    [1]
]
```

Now:

```java
flag = !flag;
```

Therefore:

```text
true → false
```

Current flag:

```text
false
```

---

# 📌 State After Level 1

```text
Queue:
[2, 3]

Temp:
[1]

Ans:
[
    [1]
]

Flag:
false
```

---

# 🔹 Iteration 2 — Level 2

Queue:

```text
[2, 3]
```

Now:

```java
int size = q.size();
```

Therefore:

```text
size = 2
```

This is important.

`size = 2` means:

> There are exactly 2 nodes belonging to the current level.

Create:

```text
temp = []
```

---

## Process Node 2

First:

```java
curr = q.poll();
```

Node:

```text
2
```

Queue becomes:

```text
[3]
```

Add:

```text
temp = [2]
```

Now process children of `2`.

Tree:

```text
        2
       / \
      4   5
```

Push left:

```text
q.offer(4)
```

Queue:

```text
[3, 4]
```

Push right:

```text
q.offer(5)
```

Queue:

```text
[3, 4, 5]
```

Decrease size:

```text
size = 1
```

---

# 🔹 Process Node 3

Now:

```java
curr = q.poll();
```

Node:

```text
3
```

Queue:

```text
[4, 5]
```

Add:

```text
temp = [2, 3]
```

Process children of `3`.

Tree:

```text
        3
       / \
      6   7
```

Push left:

```text
q.offer(6)
```

Queue:

```text
[4, 5, 6]
```

Push right:

```text
q.offer(7)
```

Queue:

```text
[4, 5, 6, 7]
```

Decrease:

```text
size = 0
```

Inner loop ends.

---

# 🚩 Check flag

Current:

```text
flag = false
```

Therefore:

```java
if(!flag)
```

becomes:

```text
if(true)
```

So we reverse:

```text
temp = [2, 3]
```

After:

```java
Collections.reverse(temp);
```

we get:

```text
temp = [3, 2]
```

Add to answer:

```text
ans = [
    [1],
    [3, 2]
]
```

Toggle flag:

```text
false → true
```

---

# 📌 State After Level 2

```text
Queue:
[4, 5, 6, 7]

Temp:
[3, 2]

Ans:
[
    [1],
    [3, 2]
]

Flag:
true
```

---

# 🔹 Iteration 3 — Level 3

Queue:

```text
[4, 5, 6, 7]
```

Now:

```java
int size = q.size();
```

Therefore:

```text
size = 4
```

This means:

```text
Current level contains 4 nodes.
```

Create:

```text
temp = []
```

---

# 🔹 Process Node 4

Poll:

```text
curr = 4
```

Queue:

```text
[5, 6, 7]
```

Add:

```text
temp = [4]
```

Node `4` has no children.

Decrease:

```text
size = 3
```

---

# 🔹 Process Node 5

Poll:

```text
curr = 5
```

Queue:

```text
[6, 7]
```

Add:

```text
temp = [4, 5]
```

Node `5` has no children.

Decrease:

```text
size = 2
```

---

# 🔹 Process Node 6

Poll:

```text
curr = 6
```

Queue:

```text
[7]
```

Add:

```text
temp = [4, 5, 6]
```

Node `6` has no children.

Decrease:

```text
size = 1
```

---

# 🔹 Process Node 7

Poll:

```text
curr = 7
```

Queue:

```text
[]
```

Add:

```text
temp = [4, 5, 6, 7]
```

Node `7` has no children.

Decrease:

```text
size = 0
```

Inner loop ends.

---

# 🚩 Check flag

Current:

```text
flag = true
```

Therefore:

```java
if(!flag)
```

becomes:

```text
if(false)
```

So we **do not reverse**.

Therefore:

```text
temp = [4, 5, 6, 7]
```

Add to answer:

```text
ans = [
    [1],
    [3, 2],
    [4, 5, 6, 7]
]
```

Toggle:

```text
true → false
```

---

# 📌 Final State

Queue:

```text
[]
```

Therefore:

```java
while(!q.isEmpty())
```

becomes:

```text
while(false)
```

The loop ends.

Return:

```java
return ans;
```

---

# 🎯 Final Output

```text
[
    [1],
    [3, 2],
    [4, 5, 6, 7]
]
```

Therefore:

```text
Zigzag Level Order Traversal
=
[[1], [3,2], [4,5,6,7]]
```

---

# 📊 Complete Dry-Run Summary

| Level | Queue Before | Nodes Processed | Temp Before Reverse | Flag  | Reverse? | Final Level |
| ----- | ------------ | --------------- | ------------------- | ----- | -------- | ----------- |
| 1     | [1]          | 1               | [1]                 | true  | No       | [1]         |
| 2     | [2,3]        | 2,3             | [2,3]               | false | Yes      | [3,2]       |
| 3     | [4,5,6,7]    | 4,5,6,7         | [4,5,6,7]           | true  | No       | [4,5,6,7]   |

Final:

```text
[
    [1],
    [3,2],
    [4,5,6,7]
]
```

---

# 🧠 Most Important Concept — `size`

This line is extremely important:

```java
int size = q.size();
```

Why?

Because we need to process **only the current level**.

For example, after processing `1`:

```text
Queue:
[2,3]
```

So:

```text
size = 2
```

We process exactly 2 nodes:

```text
2
3
```

While processing them, we add their children:

```text
4,5,6,7
```

But these children should **not** be processed in the same level.

That's why we store:

```text
size = 2
```

and process exactly two nodes.

---

# 🔥 Why Not Simply Use `while(!q.isEmpty())`?

If we did:

```java
while(!q.isEmpty()){
    ...
}
```

inside the level, then while processing:

```text
2
3
```

we would add:

```text
4,5,6,7
```

and immediately start processing them too.

Then we would lose the concept of separate levels.

Therefore:

```java
int size = q.size();
```

is used to capture:

> How many nodes belong to this level?

---

# 🔄 How the Queue Changes

Let's observe the Queue carefully.

Initially:

```text
[1]
```

After processing `1`:

```text
[2,3]
```

After processing `2` and `3`:

```text
[4,5,6,7]
```

After processing `4,5,6,7`:

```text
[]
```

So the Queue naturally moves us from:

```text
Level 1
   ↓
Level 2
   ↓
Level 3
```

---

# 🚩 How the Flag Changes

Initially:

```text
flag = true
```

### Level 1

```text
true
↓
Left → Right
```

After level:

```text
true → false
```

### Level 2

```text
false
↓
Right → Left
```

After level:

```text
false → true
```

### Level 3

```text
true
↓
Left → Right
```

So:

```text
true
 ↓
false
 ↓
true
 ↓
false
 ↓
...
```

This is what creates the zigzag pattern.

---

# 🎯 Visualizing the Zigzag

Our tree:

```text
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
```

Normal Level Order:

```text
Level 1 → 1
Level 2 → 2 3
Level 3 → 4 5 6 7
```

Zigzag:

```text
Level 1 → 1
           ↓
Level 2 → 3 2
           ↓
Level 3 → 4 5 6 7
```

Therefore:

```text
[
    [1],
    [3,2],
    [4,5,6,7]
]
```

---

# 🧩 Core Intuition

The Queue always processes:

```text
Left → Right
```

We don't change the Queue's behavior.

Instead:

```text
Queue gives:
[2,3]

If direction is reverse:
reverse it

[3,2]
```

So the Queue handles:

```text
LEVEL ORDER
```

and the `flag` handles:

```text
DIRECTION
```

---

# 🔥 The Complete Pattern

```text
                 Binary Tree
                      |
                    Queue
                      |
                Level by Level
                      |
                 int size
                      |
                Process Level
                      |
                  temp list
                      |
                 Check flag
                      |
            ┌─────────┴─────────┐
            ↓                   ↓
         true                 false
            ↓                   ↓
      Left → Right          Reverse temp
            ↓                   ↓
          Add                  Add
```

---

# 🧠 Why Does `flag` Start With `true`?

We want the first level to be:

```text
Left → Right
```

For root:

```text
[1]
```

there is no visible difference.

But for the second level:

```text
[2,3]
```

we want:

```text
[3,2]
```

So we start:

```java
boolean flag = true;
```

After processing the first level:

```java
flag = !flag;
```

Therefore:

```text
true → false
```

and the second level gets reversed.

---

# 🔍 Understanding This Part

```java
if(!flag){
    Collections.reverse(temp);
}
```

Suppose:

```text
flag = true
```

Then:

```text
!flag = false
```

So:

```text
No reverse
```

But if:

```text
flag = false
```

then:

```text
!flag = true
```

So:

```text
Reverse temp
```

Therefore:

```text
flag = true
     → normal

flag = false
     → reverse
```

---

# 🔄 Why Are Children Always Added Left Then Right?

We always do:

```java
if(curr.left != null){
    q.offer(curr.left);
}

if(curr.right != null){
    q.offer(curr.right);
}
```

This means the Queue always receives:

```text
Left → Right
```

For example:

```text
        2
       / \
      4   5
```

Queue gets:

```text
4
5
```

So:

```text
[4,5]
```

For zigzag, if required, we can simply reverse:

```text
[5,4]
```

This makes the implementation simple.

---

# ⚡ One-Line Memory Trick

Remember:

```text
QUEUE → LEVEL ORDER
SIZE  → CURRENT LEVEL
FLAG  → DIRECTION
REVERSE → ZIGZAG
```

---

# 🎯 Complete Algorithm in Simple Words

```text
1. Create an answer list.

2. If root is null, return empty answer.

3. Create a Queue.

4. Add root to Queue.

5. Set flag = true.

6. While Queue is not empty:

      a. Get the number of nodes in current level.

      b. Create temp list.

      c. Process exactly `size` nodes.

      d. Add each node's value to temp.

      e. Add its left and right children
         to the Queue.

      f. If flag is false,
         reverse temp.

      g. Add temp to answer.

      h. Toggle flag.

7. Return answer.
```

---

# 📌 Final Formula

```text
Queue
  ↓
Process one level
  ↓
Store values in temp
  ↓
flag?
  ↓
true  → Keep order
false → Reverse order
  ↓
Add to answer
  ↓
Toggle flag
```

---

# ⏱️ Complexity

Let `N` be the number of nodes.

Every node is:

```text
Inserted into Queue once
```

and:

```text
Removed from Queue once
```

Therefore the traversal itself takes:

```text
O(N)
```

However, this particular implementation also uses:

```java
Collections.reverse(temp);
```

for every alternate level.

Reversing a level containing `k` nodes takes:

```text
O(k)
```

Across all levels, the total number of nodes reversed is at most `N`.

Therefore overall:

### Time Complexity

```text
O(N)
```

### Space Complexity

The Queue can contain nodes from a level.

In the worst case, a level can contain `O(N)` nodes.

The temporary list also stores the current level.

Therefore:

```text
O(N)
```

space in the worst case.

---

# 🏆 Final Understanding

The complete intuition behind this solution is:

```text
                 Queue
                   ↓
            Level by Level
                   ↓
              temp list
                   ↓
             Check flag
              /       \
           true       false
            ↓           ↓
        Keep order   Reverse
            \           /
             \         /
                ↓
              ans
                ↓
          Toggle flag
```

The most important four things are:

```text
QUEUE
  ↓
LEVEL ORDER

SIZE
  ↓
CURRENT LEVEL

FLAG
  ↓
DIRECTION

REVERSE
  ↓
ZIGZAG
```

For our tree:

```text
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
```

we get:

```text
Level 1 → [1]
Level 2 → [3,2]
Level 3 → [4,5,6,7]
```

Therefore:

```text
Zigzag Level Order Traversal
=
[
    [1],
    [3,2],
    [4,5,6,7]
]
```

And the easiest way to remember the entire solution is:

```text
QUEUE → LEVEL
SIZE → LEVEL SIZE
FLAG → DIRECTION
REVERSE → ZIGZAG
```

This is the complete intuition behind the **Zigzag Level Order Traversal** solution.
