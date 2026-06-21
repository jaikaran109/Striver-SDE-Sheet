class Solution {
    public int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return findLength(slow,fast);
        }
        return 0;
    }
    private int findLength(Node slow , Node fast){
        int count = 1;
        slow = slow.next;
        while(slow != fast){
            count++;
            slow = slow.next;
        }
        return count;
    }
}



// class Solution {
//     public int lengthOfLoop(Node head) {
//         HashMap<Node,Integer> map = new HashMap<>();
//         Node temp = head;
//         int counter = 1;
//         while(temp != null){
//             if(map.containsKey(temp)) {
//                 return counter - map.get(temp);
//             }
//             map.put(temp,counter);
//             counter++;
//             temp = temp.next;
//         }
//         return 0;
//   }
// }
