/*Definition for singly Linked List
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}
*/
class Solution {
    public ListNode flattenLinkedList(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        while(head != null){

            ListNode down = head;

            while(down != null){
                list.add(down.val);
                down = down.child;
            }

            head = head.next;
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for(int x : list){
            temp.child = new ListNode(x);
            temp = temp.child;
        }

        return dummy.child;
    }
}
