class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}



// Brute Force
// class Solution {
//     public ListNode deleteMiddle(ListNode head) {
//         if(head.next == null) return null;
//         if(head.next.next == null){
//             head.next = null;
//             return head;
//         }
//         int nodes = 0 ;
//         ListNode temp = head;
//         while(temp != null){
//             nodes++;
//             temp = temp.next;
//         }

//         temp = head;
//         int i = 1;
//         while(i < nodes/2){
//             temp = temp.next;
//             i++;
//         }
//         temp.next = temp.next.next;
//         return head;
//     }
// }
