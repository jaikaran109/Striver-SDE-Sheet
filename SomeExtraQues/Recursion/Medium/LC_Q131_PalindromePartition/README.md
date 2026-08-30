# Palindrome Partitioning — Recursion & Backtracking

## Problem

Given a string `s`, partition it such that **every substring in the partition is a palindrome**.

### Example

```text
Input:
s = "abcba"

Output:
[
    [a, b, c, b, a],
    [a, bcb, a],
    [abcba]
]
```

---

## Approach

This problem is solved using **Recursion + Backtracking**.

At every index, we try every possible substring starting from that index.

```text
Choose substring
      ↓
Check if palindrome
      ↓
   Yes
      ↓
Add to path
      ↓
Recursive call
      ↓
Backtrack
      ↓
Remove from path
      ↓
Try next substring
```

---

## Code

```java
class Solution {

    boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;

            i++;
            j--;
        }

        return true;
    }

    void helper(int idx, String str, List<String> path,
                List<List<String>> ans) {

        if (idx == str.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < str.length(); i++) {

            if (isPalindrome(str, idx, i)) {

                path.add(str.substring(idx, i + 1));

                helper(i + 1, str, path, ans);

                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        helper(0, s, path, ans);

        return ans;
    }
}
```

---

# 1. Understanding `idx`

`idx` tells us:

> **From which index the next partition should start.**

For:

```text
s = "abcba"
```

Indices are:

```text
 a   b   c   b   a
 0   1   2   3   4
```

Initially:

```java
helper(0, ...)
```

means:

```text
a b c b a
↑
idx = 0
```

If we select `"a"`:

```text
a | b c b a
    ↑
   idx = 1
```

Therefore we call:

```java
helper(1, ...)
```

The next partition starts from index `1`.

---

# 2. Understanding the `for` Loop

```java
for (int i = idx; i < str.length(); i++)
```

The loop tries every possible substring starting from `idx`.

For:

```text
idx = 0
```

it tries:

```text
i = 0 → "a"
i = 1 → "ab"
i = 2 → "abc"
i = 3 → "abcb"
i = 4 → "abcba"
```

Then `isPalindrome()` checks them.

```text
"a"       → ✅
"ab"      → ❌
"abc"     → ❌
"abcb"    → ❌
"abcba"   → ✅
```

So the valid choices from index `0` are:

```text
"a"
"abcba"
```

---

# 3. `isPalindrome()` Function

```java
boolean isPalindrome(String s, int i, int j)
```

This function checks whether the substring from index `i` to `j` is a palindrome.

Example:

```text
"bcb"

b c b
↑   ↑

b == b
```

So it is a palindrome.

For:

```text
"bcba"

b c b a
↑     ↑

b != a
```

So it is not a palindrome.

---

# 4. Understanding `path`

`path` stores the **current partition**.

For example:

```text
path = [a, b, c]
```

means:

```text
a | b | c
```

When a palindrome is selected:

```java
path.add(str.substring(idx, i + 1));
```

it is added to `path`.

After the recursive call finishes:

```java
path.remove(path.size() - 1);
```

removes the last selected substring.

This is called **Backtracking**.

---

# 5. Why `i + 1`?

This is one of the most important lines:

```java
helper(i + 1, str, path, ans);
```

Suppose we select:

```text
a | bcb | a
```

`"bcb"` occupies:

```text
index 1 → index 3
```

Therefore, the next partition should start from:

```text
3 + 1 = 4
```

So:

```java
helper(4, ...)
```

is called.

In general:

```text
Selected substring = [idx ... i]

Next starting index = i + 1
```

---

# 6. Base Case

```java
if (idx == str.length()) {
    ans.add(new ArrayList<>(path));
    return;
}
```

When:

```text
idx == str.length()
```

it means the entire string has been partitioned.

For `"abcba"`:

```text
str.length() = 5
```

When:

```text
idx = 5
```

we have reached the end.

For example:

```text
path = [a, b, c, b, a]
```

This is a complete valid partition.

So it is added to `ans`.

### Why `new ArrayList<>(path)`?

Because we need to store a **copy** of the current path.

If we directly stored `path`, later backtracking would modify it.

---

# 7. Recursion Tree for `"abcba"`

Only palindrome choices are shown:

```text
                         idx = 0
                          path=[]
                         /       \
                       "a"      "abcba"
                        |           |
                      idx=1       idx=5
                      [a]        [abcba]
                     /   \           |
                   "b"   "bcb"    COMPLETE
                    |      |
                  idx=2   idx=4
                  [a,b] [a,bcb]
                    |      |
                   "c"     "a"
                    |      |
                  idx=3  COMPLETE
                 [a,b,c] [a,bcb,a]
                    |
                   "b"
                    |
                  idx=4
               [a,b,c,b]
                    |
                   "a"
                    |
                 COMPLETE
```

The three valid partitions are:

```text
[a, b, c, b, a]
[a, bcb, a]
[abcba]
```

---

# 8. Detailed Dry Run

## Step 1 — Start

```java
helper(0, "abcba", [], ans)
```

Current state:

```text
idx = 0
path = []
```

The loop tries:

```text
"a"       → palindrome ✅
"ab"      → ❌
"abc"     → ❌
"abcb"    → ❌
"abcba"   → palindrome ✅
```

First `"a"` is selected.

```text
path = [a]
```

Then:

```java
helper(1, ...)
```

---

## Step 2 — Choose `"b"`

Now:

```text
idx = 1
path = [a]
```

Possible substrings:

```text
"b"      → ✅
"bc"     → ❌
"bcb"    → ✅
"bcba"   → ❌
```

Choose `"b"`:

```text
path = [a, b]
```

Call:

```java
helper(2, ...)
```

---

## Step 3 — Choose `"c"`

Now:

```text
idx = 2
path = [a, b]
```

Possible substrings:

```text
"c"      → ✅
"cb"     → ❌
"cba"    → ❌
```

Choose `"c"`:

```text
path = [a, b, c]
```

Call:

```java
helper(3, ...)
```

---

## Step 4 — Choose `"b"`

Now:

```text
idx = 3
path = [a, b, c]
```

Possible:

```text
"b"  → ✅
"ba" → ❌
```

Choose `"b"`:

```text
path = [a, b, c, b]
```

Call:

```java
helper(4, ...)
```

---

## Step 5 — Choose `"a"`

Now:

```text
idx = 4
path = [a, b, c, b]
```

Only:

```text
"a" → ✅
```

Choose it:

```text
path = [a, b, c, b, a]
```

Call:

```java
helper(5, ...)
```

---

## Step 6 — Base Case

Now:

```text
idx = 5
str.length() = 5
```

Therefore:

```java
idx == str.length()
```

is true.

Store:

```text
[a, b, c, b, a]
```

---

# 9. Backtracking

After the recursive call returns:

```java
path.remove(path.size() - 1);
```

Before:

```text
[a, b, c, b, a]
```

After removing `"a"`:

```text
[a, b, c, b]
```

This allows the previous level to try another possible substring.

Eventually `"b"` is also removed:

```text
[a, b, c, b]
       ↓ remove
[a, b, c]
```

The recursion continues exploring other choices.

---

# 10. `"bcb"` Branch

At:

```text
idx = 1
path = [a]
```

After the `"b"` branch is completely explored and backtracked, the loop tries:

```text
"bcb"
```

Since `"bcb"` is a palindrome:

```text
path = [a, bcb]
```

Then:

```java
helper(4, ...)
```

At index `4`:

```text
"a" → palindrome
```

So:

```text
path = [a, bcb, a]
```

Then:

```text
idx = 5
```

Base case stores:

```text
[a, bcb, a]
```

---

# 11. `"abcba"` Branch

Finally, control returns to:

```text
helper(0)
```

The loop reaches:

```text
i = 4
```

Substring:

```text
"abcba"
```

is a palindrome.

So:

```text
path = [abcba]
```

Then:

```java
helper(5, ...)
```

Base case stores:

```text
[abcba]
```

---

# 12. Final Output

```text
[
    [a, b, c, b, a],
    [a, bcb, a],
    [abcba]
]
```

---

# 13. Core Backtracking Pattern

The most important part of this code is:

```java
path.add(...);

helper(...);

path.remove(...);
```

This follows the standard backtracking pattern:

```text
             Choose
                ↓
              Explore
                ↓
            Backtrack
                ↓
        Try next choice
```

For this problem:

```text
Choose palindrome substring
          ↓
Add to path
          ↓
Recursively partition remaining string
          ↓
Remove substring
          ↓
Try another palindrome substring
```

---

# 14. Quick Summary

| Component | Purpose |
|---|---|
| `idx` | Starting index of the next partition |
| `i` | Ending index of current substring |
| `isPalindrome()` | Checks whether substring is palindrome |
| `path` | Stores current partition |
| `ans` | Stores all valid partitions |
| `path.add()` | Choose a palindrome |
| `helper(i + 1)` | Process remaining string |
| `path.remove()` | Backtrack |
| `idx == str.length()` | Complete partition found |

## Remember

```text
START
  ↓
Choose substring [idx...i]
  ↓
Check palindrome
  ↓
Add to path
  ↓
Recursive call(i + 1)
  ↓
Remove from path
  ↓
Try next i
```

This is the basic **Recursion + Backtracking** pattern used in palindrome partitioning.
