
class Solution {
    public Node segregate(Node head) {
        if(head == null || head.next == null) return head;
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);
        
        
        Node zeroHead = zero;
        Node oneHead = one;
        Node twoHead = two;
        
        
        Node temp = head;
        
        while(temp != null){
            if(temp.data == 0){
                zeroHead.next = temp;
                zeroHead = zeroHead.next;
            }else if(temp.data == 1){
                oneHead.next = temp;
                oneHead = oneHead.next;
            }else{
                twoHead.next = temp;
                twoHead = twoHead.next;
            }
            temp = temp.next;
        }
        
        zeroHead.next = null;
        oneHead.next = null;
        twoHead.next = null;
        if(one.next != null){
            zeroHead.next = one.next;
        }
        if(one.next == null && two.next != null){
            zeroHead.next = two.next;
        }
        if(two.next != null){
            oneHead.next = two.next;
        }
        return zero.next;
    }
}




// class Solution {
//     public Node segregate(Node head) {
//         int count0 = 0;
//         int count1 = 0;
//         int count2 = 0;
        
//         Node temp = head;
//         while(temp != null){
//             if(temp.data == 0) count0++;
//             else if(temp.data == 1) count1++;
//             else count2++;
//             temp = temp.next;
//         }
//         temp = head;
//         for(int i = 0 ; i < count0 ; i++){
//             temp.data= 0;
//             temp = temp.next;
//         }
//         for(int i = 0 ; i < count1 ; i++){
//             temp.data = 1;
//             temp = temp.next;
//         }
//         for(int i = 0 ; i < count2 ; i++){
//             temp.data = 2;
//             temp = temp.next;
//         }
//         return head;
//     }
// }
