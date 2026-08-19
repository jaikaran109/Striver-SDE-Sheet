# Print Subsequences Whose Sum is K

## Problem

Given an array and a target sum `K`, find and print all subsequences whose sum is exactly equal to `K`.

A subsequence is formed by deciding for every element whether to:

- **Pick** the element
- **Skip** the element

The order of elements remains the same.

### Example

```text
Input:
arr = [1, 2, 1]
K = 2

Output:
[1, 1]
[2]
```

---

## Approach

For every element, we have two choices:

```text
                 Current Element
                    /       \
                 PICK       SKIP
                   |           |
              Include      Exclude
              element      element
```

The recursion follows this pattern:

```text
PICK
  ↓
Recursive Call
  ↓
BACKTRACK
  ↓
SKIP
  ↓
Recursive Call
```

In this problem, we maintain two important things:

- `ans` → stores the current subsequence
- `curSum` → stores the sum of elements currently present in `ans`

---

## Code

```java
package Recursion.Medium;

import java.util.*;

public class printSumK {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int size = input.nextInt();

        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = input.nextInt();
        }

        int sum = input.nextInt();

        List<int[]> result =
            sum(arr, 0, 0, sum, new ArrayList<>());

        for(int[] sub : result){
            System.out.println(Arrays.toString(sub));
        }
    }

    static List<int[]> sum(
            int[] nums,
            int idx,
            int curSum,
            int target,
            List<Integer> ans) {

        if(idx == nums.length) {

            List<int[]> container = new ArrayList<>();

            if(curSum == target) {

                int[] sub = new int[ans.size()];

                for(int i = 0; i < ans.size(); i++) {
                    sub[i] = ans.get(i);
                }

                container.add(sub);
            }

            return container;
        }

        // PICK
        ans.add(nums[idx]);

        List<int[]> left =
            sum(nums, idx + 1, curSum + nums[idx], target, ans);

        // BACKTRACK
        ans.remove(ans.size() - 1);

        // SKIP
        List<int[]> right =
            sum(nums, idx + 1, curSum, target, ans);

        // Combine both branches
        left.addAll(right);

        return left;
    }
}
```

---

# Understanding the Parameters

The recursive function is:

```java
sum(nums, idx, curSum, target, ans)
```

### 1. `nums`

The original array.

Example:

```text
[1, 2, 1]
```

---

### 2. `idx`

The index of the element currently being processed.

For:

```text
[1, 2, 1]
```

we have:

```text
idx = 0 → 1
idx = 1 → 2
idx = 2 → 1
idx = 3 → Array finished
```

---

### 3. `curSum`

The sum of all elements currently present in `ans`.

Example:

```text
ans = [1, 2]

curSum = 1 + 2
       = 3
```

---

### 4. `target`

The required sum.

Example:

```text
target = 2
```

We only store a subsequence when:

```text
curSum == target
```

---

### 5. `ans`

The current subsequence being constructed.

It can be:

```text
[]
[1]
[1, 2]
[1, 1]
```

---

# Base Case

The base case is:

```java
if(idx == nums.length)
```

This means:

> We have processed all elements of the array.

Now we check:

```java
if(curSum == target)
```

If the current sum equals the target, the current subsequence is a valid answer.

For example:

```text
ans = [1, 1]
curSum = 2
target = 2
```

Therefore:

```text
[1, 1]
```

is added to the result.

If:

```text
curSum != target
```

nothing is added.

---

# Pick Choice

This code represents the Pick choice:

```java
ans.add(nums[idx]);

List<int[]> left =
    sum(nums, idx + 1, curSum + nums[idx], target, ans);
```

Suppose:

```text
nums[idx] = 2

ans = [1]
curSum = 1
```

After picking `2`:

```text
ans = [1, 2]

curSum = 1 + 2
       = 3
```

Then recursion moves to the next index:

```text
idx → idx + 1
```

---

# Backtracking

After completely exploring the Pick branch, we need to remove the element:

```java
ans.remove(ans.size() - 1);
```

Suppose:

```text
ans = [1, 2]
```

After backtracking:

```text
ans = [1]
```

Why?

Because now we want to explore the possibility where `2` is **not picked**.

So:

```text
PICK 2
   ↓
[1,2]
   ↓
Explore all possibilities
   ↓
BACKTRACK
   ↓
[1]
   ↓
SKIP 2
```

This is called **backtracking**.

---

# Skip Choice

After backtracking, we execute:

```java
List<int[]> right =
    sum(nums, idx + 1, curSum, target, ans);
```

Notice that we do not change:

```text
ans
curSum
```

because the current element is skipped.

For example:

```text
ans = [1]
curSum = 1
```

If we skip `2`:

```text
ans = [1]
curSum = 1
```

Only `idx` changes:

```text
idx → idx + 1
```

---

# Complete Pattern

The important part of the code is:

```java
// PICK
ans.add(nums[idx]);

List<int[]> left =
    sum(nums, idx + 1, curSum + nums[idx], target, ans);

// BACKTRACK
ans.remove(ans.size() - 1);

// SKIP
List<int[]> right =
    sum(nums, idx + 1, curSum, target, ans);
```

Think of it as:

```text
                    Current Element
                           |
                    ┌──────┴──────┐
                  PICK           SKIP
                    |               |
               Add element     Don't add
                    |               |
            curSum + element    curSum same
                    |               |
                 RECURSE         RECURSE
                    |
                BACKTRACK
                    |
               Remove element
```

---

# Detailed Dry Run

Consider:

```text
Array = [1, 2, 1]
Target = 2
```

Initial call:

```text
sum([1,2,1], 0, 0, 2, [])
```

Current state:

```text
idx = 0
curSum = 0
ans = []
```

---

## Step 1: Pick `1`

```java
ans.add(nums[idx]);
```

Now:

```text
ans = [1]
```

And:

```java
curSum + nums[idx]
```

becomes:

```text
0 + 1 = 1
```

So the recursive call is:

```text
sum([1,2,1], 1, 1, 2, [1])
```

---

## Step 2: Pick `2`

Now:

```text
ans = [1,2]
curSum = 1 + 2 = 3
idx = 2
```

Recursive call:

```text
sum([1,2,1], 2, 3, 2, [1,2])
```

But:

```text
curSum = 3
target = 2
```

So this is not a valid answer.

The recursion continues to explore other possibilities.

---

## Step 3: Backtrack `2`

We execute:

```java
ans.remove(ans.size() - 1);
```

So:

```text
[1,2] → [1]
```

Now the state is:

```text
ans = [1]
curSum = 1
```

Now we **skip `2`**.

---

## Step 4: Skip `2`

The recursive call becomes:

```text
sum([1,2,1], 2, 1, 2, [1])
```

Now `idx = 2`, so we are at the last `1`.

---

## Step 5: Pick last `1`

```text
ans = [1,1]
curSum = 1 + 1
       = 2
```

Now:

```text
idx = 3
```

Since:

```text
idx == nums.length
```

we reach the base case.

Check:

```text
curSum == target

2 == 2
```

True.

Therefore:

```text
[1,1]
```

is stored.

---

## Step 6: Backtrack Last `1`

After storing `[1,1]`:

```text
[1,1] → [1]
```

Now we explore the Skip branch of the last `1`.

The sum remains:

```text
curSum = 1
```

Since:

```text
1 != 2
```

this branch does not produce an answer.

---

# Back to First Element

After all possibilities where the first `1` was picked have been explored, we backtrack:

```text
[1] → []
```

Now the first `1` is skipped.

So we explore:

```text
sum([1,2,1], 1, 0, 2, [])
```

---

# Pick `2`

Now:

```text
ans = [2]
curSum = 2
```

At the end of this branch:

```text
curSum == target

2 == 2
```

Therefore:

```text
[2]
```

is stored.

---

# Recursion Tree

For:

```text
arr = [1,2,1]
target = 2
```

the recursion conceptually looks like:

```text
                            []
                         sum = 0
                       /         \
                  PICK 1       SKIP 1
                   [1]            []
                 sum=1          sum=0
                 /   \          /   \
            PICK 2  SKIP 2  PICK 2  SKIP 2
             [1,2]    [1]      [2]      []
             sum=3   sum=1    sum=2    sum=0
                                  |
                                FOUND
                                  |
                                 [2]


                  [1]
                 sum=1
                /    \
           PICK 1    SKIP 1
            [1,1]      [1]
            sum=2     sum=1
              |
            FOUND
              |
            [1,1]
```

The important valid results are:

```text
[1,1]
[2]
```

---

# `left` and `right`

The code creates two lists:

```java
List<int[]> left =
    sum(nums, idx + 1, curSum + nums[idx], target, ans);
```

and:

```java
List<int[]> right =
    sum(nums, idx + 1, curSum, target, ans);
```

### `left`

Contains results from the **Pick branch**.

For example, when processing `1`:

```text
left =
[
    [1,2,1],
    ...
    [1,1]
]
```

### `right`

Contains results from the **Skip branch**.

For example:

```text
right =
[
    [2],
    ...
]
```

Then:

```java
left.addAll(right);
```

combines both branches.

---

# Does the Right Call Run the Function Again?

Yes.

This is an important recursion concept.

Suppose we have:

```text
sum([], 0)
```

The Pick branch calls:

```text
sum([1], 1)
```

This is a new function call.

The entire function executes for this call.

After it finishes, we backtrack:

```text
[1] → []
```

Then the Skip branch calls:

```text
sum([], 1)
```

This is another new function call.

So:

```text
                    sum([], 0)
                   /          \
                PICK          SKIP
                 /              \
        sum([1],1)            sum([],1)
             ↓                    ↓
       full function        full function
          executes             executes
             ↓                    ↓
           left                 right
```

### Important

The Left branch **does not execute again**.

It has already completed and its result has been stored in:

```java
left
```

The Right branch is a **separate recursive call**.

---

# Why Do We Need Backtracking?

Without:

```java
ans.remove(ans.size() - 1);
```

the selected element would remain inside `ans` while exploring the Skip branch.

For example:

```text
Pick 1

ans = [1]
```

After exploring it, if we don't remove it:

```text
ans = [1]
```

Then when we try to Skip `1`, it would still be present.

That would be incorrect.

Therefore:

```text
PICK
 ↓
Explore
 ↓
REMOVE
 ↓
SKIP
```

is necessary.

---

# Final Output

For input:

```text
3
1 2 1
2
```

the output is:

```text
[1, 1]
[2]
```

---

# Complexity

For every element, there are two choices:

```text
Pick
Skip
```

Therefore, the total number of possible subsequences is:

```text
2^n
```

### Time Complexity

Approximately:

```text
O(n × 2^n)
```

There are `2^n` possible subsequences, and copying a subsequence can take up to `O(n)` time.

### Space Complexity

For storing all results:

```text
O(n × 2^n)
```

Recursion stack:

```text
O(n)
```

---

# Key Takeaways

- Every element has two choices: **Pick** or **Skip**.
- `ans` stores the current subsequence.
- `curSum` stores the sum of the current subsequence.
- `idx` tells which element is currently being processed.
- `target` is the required sum.
- `ans.add()` represents **Pick**.
- `ans.remove()` represents **Backtracking**.
- The second recursive call represents **Skip**.
- `left` stores results from the Pick branch.
- `right` stores results from the Skip branch.
- `left.addAll(right)` combines both branches.
- The Right recursive call starts the function again with a new state.
- For `n` elements, there are `2^n` possible subsequences.

## Recursion Pattern to Remember

```text
              PICK
                ↓
            ADD ELEMENT
                ↓
             RECURSE
                ↓
            BACKTRACK
                ↓
            REMOVE ELEMENT
                ↓
              SKIP
                ↓
             RECURSE
```
