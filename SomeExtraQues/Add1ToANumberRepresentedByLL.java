class Solution {

    public Node addOne(Node head) {
        int carry = addCarry(head);

        if (carry > 0) {
            Node newHead = new Node(carry);
            newHead.next = head;
            head = newHead;
        }

        return head;
    }
    
    private int addCarry(Node head) {
        if (head == null) {
            return 1; 
        }

        int carry = addCarry(head.next);

        int sum = head.data + carry;
        head.data = sum % 10;

        return sum / 10;
    }

}



// Brute Force
// class Solution {
//     public Node addOne(Node head) {
//         Node prev = null;
//         Node curr = head;

//         while (curr != null) {
//             Node next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }

//         Node temp = prev;
//         int carry = 1;

//         while (temp != null) {
//             int sum = temp.data + carry;
//             temp.data = sum % 10;
//             carry = sum / 10;

//             if (carry == 0) break;

//             if (temp.next == null) {
//                 temp.next = new Node(0);
//             }

//             temp = temp.next;
//         }

//         curr = prev;
//         prev = null;

//         while (curr != null) {
//             Node next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }

//         return prev;
//     }
// }
