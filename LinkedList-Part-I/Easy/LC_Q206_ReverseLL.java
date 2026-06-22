// Optimal
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}



// Recursive
// class Solution {
//     public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null) return head; // for 0 or 1 nodes

//        ListNode newHead = reverseList(head.next);
//        ListNode front = head.next;
//        front.next = head;
//        head.next = null;
//        return newHead;
//     }
// }





// Brute Force
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         Stack<Integer> st = new Stack<>();
//         ListNode temp = head;
//         while(temp != null){
//             st.push(temp.val);
//             temp = temp.next;
//         }

//         ListNode dummy = new ListNode(-1);
//         temp = dummy;
//         while(!st.isEmpty()){
//             temp.next = new ListNode(st.pop());
//             temp = temp.next;
//         }
//         return dummy.next;
//     }
// }
