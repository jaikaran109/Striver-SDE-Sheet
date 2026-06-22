
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < lists.length ; i++){
            ListNode temp = lists[i];
            while(temp != null){
                list.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for(int i = 0 ; i < list.size() ; i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return dummy.next;
    }
}
