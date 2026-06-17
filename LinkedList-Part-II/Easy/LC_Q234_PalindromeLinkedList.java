class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        

        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = fast;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        while(prev != null){
            if(head.val != prev.val)  return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}




// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         List<Integer> list = new ArrayList<>();
//         while(head != null){
//             list.add(head.val);
//             head = head.next;
//         }
//         int l = 0;
//         int r = list.size() - 1;
//         while(l < r){
//             if(list.get(l) != list.get(r)) return false;
//             l++;
//             r--;
//         }
//         return true;
//     }
// }



// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         if (head == null || head.next == null) return true;
//         ListNode temp = head;
//         int count = 0;
//         while(temp != null){
//             count++;
//             temp = temp.next;
//         }
        
//         Stack<Integer> st = new Stack<>();
//         temp = head;
//         for(int i = 0 ; i < count/2 ; i++){
//             st.push(temp.val);
//             temp = temp.next;
//         }
//         if (count % 2 != 0) {
//             temp = temp.next;
//         }
//         while(temp != null){
//             if(st.pop() != temp.val) return false;
//             temp = temp.next;
//         }
//         return true;
//     }
// }
