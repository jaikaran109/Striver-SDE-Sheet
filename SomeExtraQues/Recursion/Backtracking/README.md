# Backtracking – Generate All Binary Strings

## 📌 Problem Statement

Given an integer `n`, generate and print all possible binary strings of length `n`.

A binary string contains only two characters:
- `0`
- `1`

### Example

For:
```text
n = 2

Output:
00
01
10
11
```

---

## 💡 Approach

This problem is a simple introduction to Backtracking.

At every position in the string, we have exactly two choices:
- Choose 0
- Choose 1

We recursively explore both choices.

The basic pattern is:
```text
Choose
   ↓
Recursion
   ↓
Undo the choice (Backtrack)
   ↓
Choose next option
```

---

## 🌳 Decision Tree

For `n = 2`, the recursion creates this decision tree:

```text
                    ""
                  /    \
                0        1
              /  \      /  \
            00   01    10   11
```

Every path from the root to a leaf represents one complete binary string.

---

## 💻 Code

```java
import java.util.*;

class Main {

    static void generate(int n, StringBuilder ans) {

        // Base case
        if (ans.length() == n) {
            System.out.println(ans);
            return;
        }

        // Choose 0
        ans.append('0');

        // Explore this choice
        generate(n, ans);

        // Backtrack
        ans.deleteCharAt(ans.length() - 1);

        // Choose 1
        ans.append('1');

        // Explore this choice
        generate(n, ans);

        // Backtrack
        ans.deleteCharAt(ans.length() - 1);
    }

    public static void main(String[] args) {

        int n = 2;

        generate(n, new StringBuilder());
    }
}
```

---

## 🔍 Code Explanation

### 1. Recursive Function
```java
static void generate(int n, StringBuilder ans)
```
The function takes two parameters:
- `n` → required length of the binary string
- `ans` → stores the string currently being constructed

For example:
```text
ans = "01"
```
means that we have currently selected 0 and 1.

### 2. Base Case
```java
if (ans.length() == n) {
    System.out.println(ans);
    return;
}
```
When the length of `ans` becomes equal to `n`, a complete binary string has been formed.

For example:
```text
n = 2
ans = "00"
```
Since `ans.length() == 2` and `n = 2`, we print `00` and return.

### 3. Choose 0
```java
ans.append('0');
```
We choose 0 for the current position.

Initially:
```text
ans = ""
```
After choosing 0:
```text
ans = "0"
```

### 4. Explore the Choice
```java
generate(n, ans);
```
Now recursion continues with the selected 0.

For example:
```text
""
 ↓
"0"
 ↓
"00"
```
When `"00"` is formed, the base case prints it.

### 5. Backtracking
This is the most important part:
```java
ans.deleteCharAt(ans.length() - 1);
```
After completely exploring all possibilities starting with 0, we remove the last choice.

For example:
* Before backtracking: `ans = "0"`
* After `ans.deleteCharAt(ans.length() - 1);`, we get: `ans = ""`

Now we are back to the previous state and can try another choice. This is called Backtracking.

### 6. Choose 1
```java
ans.append('1');
```
Now we choose the other possibility:
```text
ans = "1"
```
Then:
```java
generate(n, ans);
```
explores all strings beginning with 1. This generates:
```text
10
11
```

---

## 🔄 Complete Dry Run for n = 2

Initially:
```text
ans = ""
```
First Choice: 0
```text
ans = "0"
```
Choose 0 again:
```text
ans = "00"
```
`ans.length() == n`, so:
```text
Print → 00
```
Backtrack:
```text
ans = "0"
```
Now choose 1:
```text
ans = "01"
```
Print:
```text
01
```
Backtrack:
```text
ans = "0"
```
After finishing all possibilities starting with 0, backtrack again:
```text
ans = ""
```
Second Choice: 1
```text
ans = "1"
```
Choose 0:
```text
ans = "10"
```
Print:
```text
10
```
Backtrack.

Choose 1:
```text
ans = "11"
```
Print:
```text
11
```
Final output:
```text
00
01
10
11
```

---

## 🧠 What Exactly Is Backtracking?

Backtracking means:
Make a choice → Explore that choice completely → Undo the choice → Try another choice.

In this code:
```java
ans.append('0');        // Choose

generate(n, ans);       // Explore

ans.deleteCharAt(...);  // Undo / Backtrack
```
Then:
```java
ans.append('1');        // Choose another option

generate(n, ans);       // Explore

ans.deleteCharAt(...);  // Undo
```
So the important pattern is:
```text
              Current State
                    |
              ┌─────┴─────┐
              ↓           ↓
          Choose 0     Choose 1

              |           |
          Recursion   Recursion

              |           |
          Backtrack   Backtrack
```

---

## 🔑 Why Do We Need Backtracking?

Suppose:
```text
ans = "0"
```
We choose 0:
```text
ans = "00"
```
After printing 00, if we don't remove the last 0, we cannot correctly create `01`. We need to return to `ans = "0"` and then choose 1.

That's why `ans.deleteCharAt(ans.length() - 1);` is necessary.

---

## 📊 Complexity Analysis

For every position, there are two choices: `0` or `1`. For `n` positions, the total number of binary strings is \(2^n\). Each string has length `n`.

### Time Complexity
- \(O(n \times 2^n)\)

### Auxiliary Space Complexity
The maximum recursion depth is `n`. The `StringBuilder` can also contain at most `n` characters. Therefore:
- \(O(n)\)

If all generated strings were stored instead of printed, the output itself would require:
- \(O(n \times 2^n)\)

---

## 📚 Key Concepts Learned
- Recursion
- Backtracking
- Decision Tree
- Base Case
- Recursive Call
- Choosing an option
- Undoing a choice
- Recursion Stack
- State Management

---

## 🔑 General Backtracking Template

Most backtracking problems follow this basic pattern:

```java
void backtrack(...) {

    if (baseCondition) {
        // Store / print answer
        return;
    }

    // Make a choice
    makeChoice();

    // Explore the choice
    backtrack(...);

    // Undo the choice
    undoChoice();

    // Try another choice
    makeAnotherChoice();

    // Explore again
    backtrack(...);

    // Undo again
    undoChoice();
}
```

The core idea is:
```text
CHOOSE
   ↓
RECURSE
   ↓
UNDO
   ↓
NEXT CHOICE
```

---

## 🎯 Key Takeaway

Backtracking = Recursion + Undoing the previous choice

The most important pattern to remember is:
```text
Choose → Explore → Backtrack → Try Next Choice
```

This same concept is used in many important DSA problems:
- N-Queens
- Permutations
- Subsets
- Combination Sum
- Palindrome Partitioning
- Generate Parentheses
- Sudoku
- Maze / Path Problems
