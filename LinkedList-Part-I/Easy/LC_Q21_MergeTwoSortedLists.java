class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode l3 = ans;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l3.next = l1;
                l1 = l1.next;
            }
            else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if(l2 != null){
            l3.next = l2;
        }
        if(l1 != null){
            l3.next = l1;
        }
        return ans.next;
    }
}



// Brute Force
// Add both linkedlists in Arraylist then sort it then make another LL
