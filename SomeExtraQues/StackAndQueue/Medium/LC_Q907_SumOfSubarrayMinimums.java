// Ye Better code h but samjhane pe samjh nhi aayega - main idea ek range nikalo jisme vo perticular element smaller ho phir no. of elements in left and no. of ele in right and arr[i] , inko multiply kr do

// -- nhi aaya na - prefer Striver video - L9-Sumof Subarray Minimum

class Solution {
    public int sumSubarrayMins(int[] arr) {

        int mod = (int)1e9+7;

        long sum = 0;

        Stack<Integer> nse = new Stack<>();
        Stack<Integer> pse = new Stack<>();

        int[] PSE = new int[arr.length];
        int[] NSE = new int[arr.length];


        // For Previous Smaller Element
        for(int i = 0 ; i < arr.length ; i++){
            while(!pse.isEmpty() && arr[pse.peek()] >= arr[i]){
                pse.pop();
            }
            if(pse.isEmpty()) PSE[i] = -1;
            else PSE[i] = pse.peek();
            pse.push(i);
        }


        // Next Smaller Element
        for(int i = arr.length - 1 ; i >= 0 ; i--) {

            while(!nse.isEmpty() && arr[nse.peek()] > arr[i]) {
                nse.pop();
            }

            if(nse.isEmpty()) NSE[i] = arr.length;
            else NSE[i] = nse.peek();

            nse.push(i);
        }


        // Main Calculation Part
        for(int i = 0 ; i < arr.length ; i++){
            long left = i - PSE[i] ;
            long right = NSE[i] - i;

            sum = (sum + (right * left * arr[i])) % mod;
        }

        return (int)sum;
    }
}





// Cleaner code

// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int mod = (int)1e9 + 7;
//         int n = arr.length;

//         int[] PSE = new int[n];
//         int[] NSE = new int[n];

//         Stack<Integer> st = new Stack<>();

//         // PSE: previous strictly smaller
//         for(int i = 0 ; i < n ; i++) {
//             while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
//                 st.pop();
//             }

//             if(st.isEmpty()) PSE[i] = -1;
//             else PSE[i] = st.peek();

//             st.push(i);
//         }

//         st.clear();

//         // NSE: next smaller or equal
//         for(int i = n - 1 ; i >= 0 ; i--) {
//             while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
//                 st.pop();
//             }

//             if(st.isEmpty()) NSE[i] = n;
//             else NSE[i] = st.peek();

//             st.push(i);
//         }

//         long sum = 0;

//         for(int i = 0 ; i < n ; i++) {
//             long left = i - PSE[i];
//             long right = NSE[i] - i;

//             long contribution = (arr[i] * left * right) % mod;

//             sum = (sum + contribution) % mod;
//         }

//         return (int)sum;
//     }
// }





// Brute Force

// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int mod = (int)1e9 + 7;

//         long sum = 0;  // int me overflow ho rha h

//         for(int i = 0 ; i < arr.length ; i++){
//             int min = arr[i];
//             for(int j = i ; j < arr.length ; j++){
//                 min = Math.min(min,arr[j]);
//                 sum += min; 
//             }
//         }

//         return (int)(sum % mod);
//     }
// }

// Time - O(n^2)
