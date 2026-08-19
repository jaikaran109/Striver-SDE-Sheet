# Array All Subsequences Using Recursion & Backtracking

## 1. Problem

Given an array, generate **all possible subsequences** of that array.

For example:

``` text
Input:
[1, 2, 3]

Output:
[1, 2, 3]
[1, 2]
[1, 3]
[1]
[2, 3]
[2]
[3]
[]
```

A subsequence is created by deciding for every element whether to:

-   **Pick** the element
-   **Skip** the element

The order of elements is always maintained.

------------------------------------------------------------------------

## 2. Code

``` java
package Striver_Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayAllSubsequences {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        List<int[]> result =
            subsequence(arr, new ArrayList<>(), 0);

        for (int[] sub : result) {
            System.out.println(Arrays.toString(sub));
        }
    }

    static List<int[]> subsequence(
            int[] nums,
            List<Integer> ans,
            int idx) {

        // Base case
        if (idx == nums.length) {

            List<int[]> container = new ArrayList<>();

            int[] sub = new int[ans.size()];

            for (int i = 0; i < ans.size(); i++) {
                sub[i] = ans.get(i);
            }

            container.add(sub);

            return container;
        }

        // Pick current element
        ans.add(nums[idx]);

        List<int[]> left =
            subsequence(nums, ans, idx + 1);

        // Backtrack
        ans.remove(ans.size() - 1);

        // Skip current element
        List<int[]> right =
            subsequence(nums, ans, idx + 1);

        // Combine both branches
        left.addAll(right);

        return left;
    }
}
```

------------------------------------------------------------------------

# 3. Main Idea

At every index we have exactly **two choices**:

``` text
Current Element
      |
   ┌──┴──┐
 PICK   SKIP
```

For `[1, 2, 3]`:

``` text
For 1:
    Pick 1
    Skip 1

For 2:
    Pick 2
    Skip 2

For 3:
    Pick 3
    Skip 3
```

Therefore:

``` text
Number of subsequences = 2^n
```

For `n = 3`:

``` text
2^3 = 8
```

So `[1,2,3]` has 8 subsequences, including the empty subsequence.

------------------------------------------------------------------------

# 4. Meaning of the Parameters

Our function is:

``` java
subsequence(nums, ans, idx)
```

### `nums`

The original array.

``` text
[1, 2, 3]
```

### `ans`

The current subsequence that we are building.

Examples:

``` text
[]
[1]
[1,2]
[1,2,3]
```

### `idx`

The index of the element currently being considered.

For:

``` text
[1, 2, 3]
```

the values are:

``` text
idx = 0 → 1
idx = 1 → 2
idx = 2 → 3
idx = 3 → base case
```

------------------------------------------------------------------------

# 5. Base Case

``` java
if (idx == nums.length) {
```

When `idx` reaches the length of the array, there are no elements left
to process.

For:

``` text
nums = [1,2,3]
```

when:

``` text
idx = 3
```

we have reached the end.

At this point, `ans` is one complete subsequence.

For example:

``` text
ans = [1,2,3]
idx = 3
```

So we convert `ans` into an `int[]` and store it.

------------------------------------------------------------------------

# 6. The Most Important Part

The recursion follows this pattern:

``` java
ans.add(nums[idx]);

List<int[]> left =
    subsequence(nums, ans, idx + 1);

ans.remove(ans.size() - 1);

List<int[]> right =
    subsequence(nums, ans, idx + 1);
```

This means:

``` text
        PICK
          ↓
    recursive call
          ↓
      backtrack
          ↓
        SKIP
          ↓
    recursive call
```

Or simply:

``` text
PICK → RECURSE → REMOVE → SKIP → RECURSE
```

------------------------------------------------------------------------

# 7. Why Do We Remove the Element?

Suppose:

``` text
ans = []
```

At index `0`, the element is `1`.

We pick it:

``` java
ans.add(1);
```

Now:

``` text
ans = [1]
```

We explore **every possible subsequence containing `1`**.

After that branch is completely finished, we need to explore
subsequences **not containing `1`**.

So we remove it:

``` java
ans.remove(ans.size() - 1);
```

Now:

``` text
[1] → []
```

This process is called **backtracking**.

------------------------------------------------------------------------

# 8. Important Question: Does the Right Call Run the Function Again?

Yes.

Suppose we start with:

``` java
subsequence([], 0)
```

The first branch is:

``` java
subsequence([1], 1)
```

This is the **left branch**.

The complete function executes for this new call.

After the left branch finishes:

``` text
[1] → []
```

because of backtracking.

Then the parent executes:

``` java
right = subsequence(nums, ans, idx + 1);
```

So a **new function call** is created:

``` java
subsequence([], 1)
```

The function starts executing again from its beginning for this new
call.

### Important:

The left branch does **not** run again.

Only a **new recursive call** starts.

``` text
                 subsequence([], 0)
                    /          \
                 PICK          SKIP
                  /              \
                 /                \
    subsequence([1],1)      subsequence([],1)
            ↓                       ↓
      entire function          entire function
        executes again           executes again
```

The two calls are separate branches.

------------------------------------------------------------------------

# 9. Detailed Dry Run for `[1,2,3]`

Initial call:

``` text
subsequence([], 0)
```

------------------------------------------------------------------------

## Step 1: Pick `1`

``` text
ans = [1]
idx = 1
```

Call:

``` text
subsequence([1], 1)
```

------------------------------------------------------------------------

## Step 2: Pick `2`

``` text
ans = [1,2]
idx = 2
```

Call:

``` text
subsequence([1,2], 2)
```

------------------------------------------------------------------------

## Step 3: Pick `3`

``` text
ans = [1,2,3]
idx = 3
```

Base case reached.

Store:

``` text
[1,2,3]
```

------------------------------------------------------------------------

## Step 4: Backtrack

Remove `3`:

``` text
[1,2,3] → [1,2]
```

Now skip `3`.

Call:

``` text
subsequence([1,2], 3)
```

Base case.

Store:

``` text
[1,2]
```

So the `[1,2]` branch produces:

``` text
[1,2,3]
[1,2]
```

------------------------------------------------------------------------

## Step 5: Backtrack `2`

Now remove `2`:

``` text
[1,2] → [1]
```

Now skip `2`.

Call:

``` text
subsequence([1], 2)
```

For `3`:

### Pick `3`

``` text
[1] → [1,3]
```

Store:

``` text
[1,3]
```

### Skip `3`

Store:

``` text
[1]
```

So the branch containing `1` produces:

``` text
[1,2,3]
[1,2]
[1,3]
[1]
```

------------------------------------------------------------------------

# 10. Now Backtrack `1`

After completing every branch where `1` is picked:

``` text
[1] → []
```

Now the code executes the `right` recursive call:

``` java
subsequence(nums, [], 1);
```

Notice:

``` text
idx = 0 → 1
```

and the function starts again from the beginning for this new call.

------------------------------------------------------------------------

## Step 11: Skip `1`, Pick `2`

``` text
ans = [2]
idx = 2
```

For `3`:

### Pick `3`

``` text
[2] → [2,3]
```

Store:

``` text
[2,3]
```

### Skip `3`

Store:

``` text
[2]
```

------------------------------------------------------------------------

## Step 12: Skip `2`

Backtrack:

``` text
[2] → []
```

Now process `3`.

### Pick `3`

``` text
[] → [3]
```

Store:

``` text
[3]
```

### Skip `3`

``` text
ans = []
```

Store:

``` text
[]
```

------------------------------------------------------------------------

# 11. Complete Recursion Tree

For `[1,2,3]`:

``` text
                         []
                    /          \
                PICK 1       SKIP 1
                  [1]            []
                 /   \          /   \
            PICK 2  SKIP 2  PICK 2  SKIP 2
              [1,2]   [1]     [2]      []
              /  \     / \     / \      / \
          P 3   S 3  P 3 S 3 P 3 S 3 P 3 S 3
           /      \    /  \   /  \   /  \   /  \
        [1,2,3] [1,2][1,3][1][2,3][2][3][]
```

Where:

``` text
P = Pick
S = Skip
```

------------------------------------------------------------------------

# 12. How `left` and `right` Work

At every element, we generate two lists.

For example, at `idx = 0`:

``` java
ans.add(nums[idx]);

List<int[]> left =
    subsequence(nums, ans, idx + 1);
```

`left` contains all subsequences where the current element is
**picked**.

For `1`:

``` text
left =
[
    [1,2,3],
    [1,2],
    [1,3],
    [1]
]
```

Then:

``` java
ans.remove(ans.size() - 1);
```

Backtrack.

Then:

``` java
List<int[]> right =
    subsequence(nums, ans, idx + 1);
```

`right` contains all subsequences where the current element is
**skipped**.

For `1`:

``` text
right =
[
    [2,3],
    [2],
    [3],
    []
]
```

Finally:

``` java
left.addAll(right);
```

Combines them:

``` text
left =
[
    [1,2,3],
    [1,2],
    [1,3],
    [1],
    [2,3],
    [2],
    [3],
    []
]
```

------------------------------------------------------------------------

# 13. Final Output

For:

``` text
Input:
3
1 2 3
```

Output:

``` text
[1, 2, 3]
[1, 2]
[1, 3]
[1]
[2, 3]
[2]
[3]
[]
```

------------------------------------------------------------------------

# 14. Recursion + Backtracking Pattern

This problem follows a very common recursion pattern:

``` text
                 Current Element
                       |
                 ┌─────┴─────┐
               PICK         SKIP
                 |             |
             add()           don't add
                 |             |
             recurse        recurse
                 |
              remove()
                 |
            BACKTRACK
```

In code:

``` java
ans.add(nums[idx]);                  // PICK

List<int[]> left =
    subsequence(nums, ans, idx + 1); // RECURSE

ans.remove(ans.size() - 1);          // BACKTRACK

List<int[]> right =
    subsequence(nums, ans, idx + 1); // SKIP

left.addAll(right);                  // COMBINE
```

------------------------------------------------------------------------

# 15. Complexity

For `n` elements, there are:

``` text
2^n
```

possible subsequences.

Therefore, the recursion tree has approximately:

``` text
O(2^n)
```

leaf nodes.

Since every subsequence may contain up to `n` elements, storing all
subsequences requires:

``` text
O(n × 2^n)
```

space for the output.

The recursion stack itself uses:

``` text
O(n)
```

stack space.

------------------------------------------------------------------------

# 16. Key Takeaways

1.  Every element has **two choices**: Pick or Skip.
2.  `ans` stores the current subsequence.
3.  `idx` tells us which element we are currently processing.
4.  `ans.add()` means **Pick**.
5.  `ans.remove()` means **Backtrack**.
6.  The second recursive call represents **Skip**.
7.  Every recursive call starts executing the function again from the
    beginning with its own `ans` and `idx`.
8.  `left` and `right` are results of two independent recursive
    branches.
9.  `left.addAll(right)` combines both branches.
10. The empty array `[]` is also a valid subsequence.
11. Total subsequences for `n` elements = **`2^n`**.
