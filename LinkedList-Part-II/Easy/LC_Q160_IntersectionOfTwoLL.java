public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode A = headA;
        ListNode B = headB;

        while( A != B){                 // ek point aisa aayega jb dono null point krega agr kuch common na  ho to 
            if(A == null) A = headB;     // vrna common aayega to while loop break ho jayega and first node return ho jayega
            else A = A.next;

            if(B == null) B = headA;
            else B = B.next;
        }

        return A;
    }
}


// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         HashSet<ListNode> set = new HashSet<>();
//         while(headA != null){
//             set.add(headA);
//             headA = headA.next;
//         }


//         while(headB != null){
//             if(set.contains(headB)) return headB;
//             headB = headB.next;
//         }
//         return null;
//     }
// }




// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode tempA = headA;
//         while(tempA != null){
//             ListNode tempB = headB;
//             while(tempB != null){
//                 if(tempA == tempB) return tempA;
//                 tempB = tempB.next;
//             }
//             tempA = tempA.next;
//         }
//         return null;
//     }
// }
