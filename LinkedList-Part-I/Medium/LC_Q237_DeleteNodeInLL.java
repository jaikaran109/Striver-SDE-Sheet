class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;  // copy the next Node data
        node.next = node.next.next;  // delete the next Node
    }
}


// Copy the value of the next node into the current node
// and bypass the next node.
// This effectively deletes the given node without needing
// access to the previous node or head of the linked list.
