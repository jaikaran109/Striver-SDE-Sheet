class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode temp = head;
        int count = 1;

        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        temp.next = head;               // make it cyclic

        k = k % count;
        int steps = count - k;

        ListNode newTail = head;
        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
