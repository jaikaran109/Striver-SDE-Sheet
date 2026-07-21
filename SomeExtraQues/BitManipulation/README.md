# Single Number III — Bit Manipulation Approach

## Problem Statement

Given an integer array `nums`, exactly two elements appear only once, while every other element appears exactly twice.

Return the two elements that appear only once.

The answer can be returned in any order.

### Example

```text
Input: nums = [1, 2, 1, 3, 2, 5]

Output: [3, 5]
```

### Constraints

```text
2 <= nums.length <= 3 * 10⁴
-2³¹ <= nums[i] <= 2³¹ - 1
```

Each integer in `nums` appears exactly twice except for two integers, which appear only once.

---

## Approach: XOR and Bit Manipulation

We know the following XOR properties:

```text
x ^ x = 0
x ^ 0 = x
x ^ y = y ^ x
```

Therefore, when two equal numbers are XORed, they cancel each other.

For example:

```text
2 ^ 2 = 0
5 ^ 5 = 0
```

Suppose the two unique numbers are `a` and `b`.

If we XOR all the elements of the array, all duplicate numbers cancel out, and we are left with:

```text
xor = a ^ b
```

However, this gives us the XOR of the two unique numbers, not the individual numbers.

To separate them, we find a bit position where `a` and `b` are different.

---

## Step 1: XOR All Elements

Consider:

```text
nums = [1, 2, 1, 3, 2, 5]
```

XOR of all elements:

```text
xor = 1 ^ 2 ^ 1 ^ 3 ^ 2 ^ 5
```

Rearranging the equal elements:

```text
xor = (1 ^ 1) ^ (2 ^ 2) ^ (3 ^ 5)
```

Duplicates cancel:

```text
xor = 0 ^ 0 ^ (3 ^ 5)
xor = 3 ^ 5
```

Binary representation:

```text
3 = 011
5 = 101
--------
    110
```

Therefore:

```text
xor = 6
```

The final XOR represents:

```text
xor = firstUnique ^ secondUnique
```

---

## Step 2: Find the Rightmost Set Bit

We use:

```java
int rightmostSetBit = xor & -xor;
```

This expression isolates the rightmost set bit of `xor`.

For our example:

```text
xor = 6
```

Binary representation:

```text
6 = 0110
```

The rightmost set bit is:

```text
0010
```

Therefore:

```text
rightmostSetBit = 2
```

### Why do we need this bit?

A set bit in `a ^ b` means that `a` and `b` have different bits at that position.

For example:

```text
3 = 011
5 = 101
--------
    110
```

At bit index `1`:

```text
3 has bit 1
5 has bit 0
```

Therefore, this bit can be used to place the two unique numbers into different groups.

---

## How `xor & -xor` Works

Suppose:

```text
xor = 6
```

Using a four-bit representation:

```text
6 = 0110
```

To calculate `-6`, Java uses two's complement.

### Invert all bits

```text
0110
1001
```

### Add `1`

```text
1001
   1
----
1010
```

Therefore:

```text
-6 = 1010
```

Now perform AND:

```text
 xor = 0110
-xor = 1010
------------
       0010
```

Only the rightmost set bit remains.

---

## Step 3: Divide Numbers into Two Groups

We divide every number into one of two groups using:

```java
(num & rightmostSetBit) != 0
```

### First group

Numbers whose selected bit is set:

```text
(num & rightmostSetBit) != 0
```

### Second group

Numbers whose selected bit is not set:

```text
(num & rightmostSetBit) == 0
```

The two unique numbers will always enter different groups because they have different values at the selected bit position.

Duplicate numbers will always enter the same group because both occurrences have the same binary representation.

After XORing the elements of each group, duplicate numbers cancel, leaving one unique number in each group.

---

## Complete Dry Run

Given:

```text
nums = [1, 2, 1, 3, 2, 5]
```

After XORing all elements:

```text
xor = 6
```

Rightmost set bit:

```text
rightmostSetBit = 6 & -6
rightmostSetBit = 2
```

Binary mask:

```text
2 = 010
```

Initially:

```text
first = 0
second = 0
```

---

### Element `1`

```text
1    = 001
mask = 010
------------
       000
```

The selected bit is not set, so `1` enters the second group.

```text
second = 0 ^ 1
second = 1
```

Current values:

```text
first = 0
second = 1
```

---

### Element `2`

```text
2    = 010
mask = 010
------------
       010
```

The result is non-zero, so `2` enters the first group.

```text
first = 0 ^ 2
first = 2
```

Current values:

```text
first = 2
second = 1
```

---

### Element `1` Again

```text
1 & 2 = 0
```

It enters the second group again.

```text
second = 1 ^ 1
second = 0
```

Both occurrences of `1` cancel each other.

Current values:

```text
first = 2
second = 0
```

---

### Element `3`

```text
3    = 011
mask = 010
------------
       010
```

It enters the first group.

```text
first = 2 ^ 3
first = 1
```

Current values:

```text
first = 1
second = 0
```

---

### Element `2` Again

```text
2 & 2 != 0
```

It enters the first group again.

```text
first = 1 ^ 2
first = 3
```

Both occurrences of `2` cancel each other.

Current values:

```text
first = 3
second = 0
```

---

### Element `5`

```text
5    = 101
mask = 010
------------
       000
```

It enters the second group.

```text
second = 0 ^ 5
second = 5
```

Final values:

```text
first = 3
second = 5
```

Therefore:

```text
Answer = [3, 5]
```

---

## Group Representation

Using the mask:

```text
010
```

### Group 1: Selected bit is set

```text
2 = 010
3 = 011
2 = 010
```

XOR:

```text
2 ^ 3 ^ 2
```

Rearranging:

```text
(2 ^ 2) ^ 3
```

```text
0 ^ 3 = 3
```

The first unique number is:

```text
3
```

### Group 2: Selected bit is not set

```text
1 = 001
1 = 001
5 = 101
```

XOR:

```text
1 ^ 1 ^ 5
```

```text
0 ^ 5 = 5
```

The second unique number is:

```text
5
```

---

## Why Do Duplicate Numbers Cancel?

Both occurrences of a duplicate number have the same binary representation.

For example:

```text
2 = 010
2 = 010
```

When checked using the same mask:

```text
010 & 010 = 010
010 & 010 = 010
```

Both occurrences enter the same group.

Inside that group:

```text
2 ^ 2 = 0
```

Therefore, every duplicate number gets cancelled.

The two unique numbers enter different groups because the chosen bit is different for them.

---

## Java Solution

```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        // Step 1: XOR all elements
        for (int num : nums) {
            xor = xor ^ num;
        }

        // Step 2: Isolate the rightmost set bit
        int rightmostSetBit = xor & -xor;

        int first = 0;
        int second = 0;

        // Step 3: Divide elements into two groups
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) {
                first = first ^ num;
            } else {
                second = second ^ num;
            }
        }

        return new int[]{first, second};
    }
}
```

---

## Line-by-Line Explanation

```java
int xor = 0;
```

Stores the XOR of all elements.

```java
for (int num : nums) {
    xor = xor ^ num;
}
```

All duplicate elements cancel, leaving:

```text
xor = firstUnique ^ secondUnique
```

```java
int rightmostSetBit = xor & -xor;
```

Isolates one bit where the two unique numbers are different.

```java
int first = 0;
int second = 0;
```

Stores the XOR result of the two groups.

```java
if ((num & rightmostSetBit) != 0)
```

Checks whether the selected bit is set in the current number.

```java
first = first ^ num;
```

XORs the numbers belonging to the first group.

```java
second = second ^ num;
```

XORs the numbers belonging to the second group.

```java
return new int[]{first, second};
```

Returns the two unique numbers.

---

## Complexity Analysis

### Time Complexity

```text
O(n)
```

The array is traversed twice:

```text
O(n) + O(n) = O(2n) = O(n)
```

### Space Complexity

```text
O(1)
```

Only a few integer variables are used. No extra array, set, or hash map is required.

---

## Key Observations

1. XOR of two equal numbers is `0`.

```text
x ^ x = 0
```

2. XOR with zero returns the same number.

```text
x ^ 0 = x
```

3. After XORing the complete array:

```text
xor = unique1 ^ unique2
```

4. A set bit in the XOR result represents a position where the two unique numbers are different.

5. The expression below isolates the rightmost set bit:

```java
xor & -xor
```

6. Duplicate numbers always enter the same group and cancel each other.

7. The two unique numbers enter different groups and remain as the final answers.

---

## Algorithm Summary

```text
1. XOR all elements of the array.
2. The result will be unique1 ^ unique2.
3. Find the rightmost set bit of this XOR.
4. Divide all numbers into two groups using this bit.
5. XOR the elements inside both groups.
6. Duplicate numbers cancel.
7. One unique number remains in each group.
```

---

## Related Problem

**LeetCode 260 — Single Number III**

### Tags

```text
Array
Bit Manipulation
XOR
```
