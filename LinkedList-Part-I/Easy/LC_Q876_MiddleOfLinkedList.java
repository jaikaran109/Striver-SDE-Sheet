// Optimal
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}





// Brute Force
// class Solution {
//     public ListNode middleNode(ListNode head) {
//         int nodes = 0;
//         ListNode temp = head;
//         while(temp != null){
//             nodes++;
//             temp = temp.next;
//         }

//         int i = 0;
//         temp = head;
//         while(i < nodes / 2){
//             temp = temp.next;
//             i++;
//         }
//         return temp;
//     }
// }
