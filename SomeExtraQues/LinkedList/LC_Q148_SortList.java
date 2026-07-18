// Optimal - Merge Sort, but I haven't learned recursion yet, so I'm not doing it right now.


class Solution {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        ArrayList<Integer> list = new ArrayList<>();
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(list);

        temp = dummy;
        for(int i = 0 ; i < list.size() ; i++){
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return dummy.next;
    }
}
