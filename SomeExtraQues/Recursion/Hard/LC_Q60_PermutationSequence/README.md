# Permutation Sequence (LeetCode 60)

A Java solution that finds the **k-th permutation sequence** of numbers `1` to `n`, using the **factorial number system (Lehmer code)** — without generating all permutations.

## Problem Statement

Given `n` and `k`, return the `k`-th permutation sequence (1-indexed) of the numbers `[1, 2, ..., n]`, in lexicographic order.

**Example:**
```
Input: n = 4, k = 9
Output: "2314"
```

## Approach

Instead of generating all `n!` permutations and picking the k-th one, this solution directly computes each digit using factorial math.

**Key idea:** If we fix the first digit, the remaining `(n-1)` numbers form `(n-1)!` permutations. So:

- The first `(n-1)!` permutations start with the smallest available number
- The next `(n-1)!` permutations start with the second smallest available number
- ...and so on

By dividing `k` by `(n-1)!`, we can figure out which "block" (i.e. which digit) is correct — without generating anything.

## Code

```java
class Solution {
    int fact(int n){
        if(n <= 1) return 1;
        return n * fact(n-1); 
    }

    void check(int n , int k , StringBuilder sb , boolean[] visit){
        if(n == 0) return;
        int fc = fact(n - 1);
        int block = (k-1)/fc;
        int i = 1 ; 
        while(block > 0 || visit[i]){
            if(!visit[i]) block--;
            i++;
        }
        sb.append(i);
        visit[i] = true;
        k = (k-1) % fc + 1;
        check(n-1,k,sb,visit);
    }

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n+1];
        check(n,k,sb,visited);
        return sb.toString();
    }
}
```

## How It Works

### `fact(n)`
A simple recursive factorial function.
```
fact(3) = 6, fact(2) = 2, fact(1) = 1, fact(0) = 1
```

### `check(n, k, sb, visit)`

| Step | Line | What it does |
|---|---|---|
| 1 | `if(n == 0) return;` | Base case — all digits placed, recursion stops |
| 2 | `fc = fact(n - 1)` | Number of permutations possible for the remaining `(n-1)` digits, once the first is fixed — the "block size" |
| 3 | `block = (k-1)/fc` | Converts `k` to 0-indexed and divides by block size to find how many available numbers to skip |
| 4 | `while(block > 0 \|\| visit[i])` | Walks forward from `i = 1`, skipping already-used numbers and decrementing `block` for each unused number passed, until it lands on the correct unused digit |
| 5 | `sb.append(i)` | Appends the chosen digit to the result |
| 6 | `visit[i] = true` | Marks the digit as used |
| 7 | `k = (k-1) % fc + 1` | Recomputes `k` as the relative position within the chosen block, for the next recursive call |
| 8 | `check(n-1, k, sb, visit)` | Recurses with one fewer digit remaining |

### `getPermutation(n, k)`
Sets up the `StringBuilder` and `visited` array, then kicks off the recursion.

## Full Trace: `n = 4, k = 9`

Expected output: `"2314"`

| Depth | n | k (input) | fc | block | chosen digit | k (updated) |
|---|---|---|---|---|---|---|
| 1 | 4 | 9 | 6 | 1 | 2 | 3 |
| 2 | 3 | 3 | 2 | 1 | 3 | 1 |
| 3 | 2 | 1 | 1 | 0 | 1 | 1 |
| 4 | 1 | 1 | 1 | 0 | 4 | — |

**Result:** `sb = "2314"` ✅

### Step-by-step walkthrough

**Call 1: `check(4, 9, ...)`**
- `fc = fact(3) = 6`
- `block = (9-1)/6 = 1`
- Loop skips `1` (unused), lands on `i = 2` → append `2`
- `k = (9-1)%6 + 1 = 3`

**Call 2: `check(3, 3, ...)`**
- `fc = fact(2) = 2`
- `block = (3-1)/2 = 1`
- Loop skips `1` (unused), skips `2` (already visited, doesn't count as a block decrement), lands on `i = 3` → append `3`
- `k = (3-1)%2 + 1 = 1`

**Call 3: `check(2, 1, ...)`**
- `fc = fact(1) = 1`
- `block = (1-1)/1 = 0`
- Loop condition immediately false → lands on `i = 1` → append `1`
- `k = (1-1)%1 + 1 = 1`

**Call 4: `check(1, 1, ...)`**
- `fc = fact(0) = 1`
- `block = (1-1)/1 = 0`
- Loop skips `1`, `2`, `3` (all visited), lands on `i = 4` → append `4`

**Call 5: `check(0, ...)`** → base case → return.

## Complexity

| Metric | Value |
|---|---|
| Time | O(n²) — the `while` loop is O(n) worst case, across n recursive levels |
| Space | O(n) — for the `visit` array and recursion stack |

**Note:** This can be optimized to O(n log n) or O(n) by replacing the `boolean[]` with a `List<Integer>` (or Fenwick/BIT structure) and removing the chosen digit directly by index, instead of linearly scanning past used digits. The version above is still efficient since it avoids generating any actual permutations.

## Key Concepts Used

- **Factorial Number System (Lehmer Code)** — encodes a permutation as a sequence of choices among remaining elements
- **Recursion** — each call fixes one digit and recurses on the rest
- **0-indexing conversion** (`k-1` ... `+1`) — bridges 1-indexed problem input with 0-indexed block math
