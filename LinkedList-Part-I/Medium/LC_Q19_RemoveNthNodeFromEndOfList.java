// Isme dhyaan do jb tm fast ko phle hi utne steps move  kr de rhe ho to vo head se utne steps aage h phir tm edge cases check kr rhe ho ki 
// agr vo last node pe h to first element dlt hoga , etc etc
// ab tm slow ko head pe point kro aur jb fast last node pe hoga to slow wala usse utna hi peeche rhega jitni n ki value thi


// eg , head = [1,2,3,4,5], n = 2
// move fast till i < 2 ;
// fast points = 3
// ab slow head pe point kro aur fast.next jb tk null na ho tb tk aage bdhao
// Now - fast = 5 , slow = 3
// ab slow.next = slow.next.next;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        ListNode fast = head;

        for(int i = 0 ; i < n ; i++){
            fast = fast.next;
        }


        if(fast == null) return head.next;
        

        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}





// Ye to dekh ke samjh aa rha h
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode temp = head;
//         int count = 0;
//         while(temp != null){
//             count++;
//             temp = temp.next;
//         }
//         if(count == n) {
//             return head.next;
//         }
//         int x = count - n - 1;
//         temp = head;
//         for(int i = 0 ; i < x ; i++) {    
//            temp = temp.next;
//         }
//         if (temp.next != null) {
//             temp.next = temp.next.next;
//         }

//         return head;
//     }
// }
