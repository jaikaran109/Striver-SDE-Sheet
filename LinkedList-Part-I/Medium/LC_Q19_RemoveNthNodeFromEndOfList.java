class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        if(count == n) {
            return head.next;
        }
        int x = count - n - 1;
        temp = head;
        for(int i = 0 ; i < x ; i++) {    
           temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }
}
