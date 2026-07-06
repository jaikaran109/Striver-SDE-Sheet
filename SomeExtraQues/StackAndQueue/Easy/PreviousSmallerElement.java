class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) ans.add(-1);
            else ans.add(st.peek());
            st.push(arr[i]);
        }
        return ans;
    }
}
// Time - O(n)




// Brute Force

// class Solution {
//     public static ArrayList<Integer> prevSmaller(int[] arr) {
//         ArrayList<Integer> ans = new ArrayList<>();

//         for(int i = 0 ; i < arr.length ; i++) {
//             boolean found = false;

//             for(int j = i - 1 ; j >= 0 ; j--) {
//                 if(arr[j] < arr[i]) {
//                     ans.add(arr[j]);
//                     found = true;
//                     break;
//                 }
//             }

//             if(!found) {
//                 ans.add(-1);
//             }
//         }

//         return ans;
//     }
// }
// Time - O(n^2)
