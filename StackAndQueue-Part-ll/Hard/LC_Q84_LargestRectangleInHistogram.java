// Not Optimal


class Solution {
    public int largestRectangleArea(int[] arr) {
        
        int n = arr.length;
        
        int[] PSE = new int[n];
        int[] NSE = new int[n];

        Stack<Integer> st = new Stack<>();

        // PSE: previous strictly smaller
        for(int i = 0 ; i < n ; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) PSE[i] = -1;
            else PSE[i] = st.peek();

            st.push(i);
        }

        st.clear();

        // NSE: next smaller or equal
        for(int i = n - 1 ; i >= 0 ; i--) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) NSE[i] = n;
            else NSE[i] = st.peek();

            st.push(i);
        }




        // Area
        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){
            maxArea = Math.max(maxArea,arr[i] * (NSE[i] - PSE[i] - 1 ));
        }
        return maxArea;
    }
}


// Isme sare elements ka previous and next smaller element store kr rhe h aur manually sare index pe jakr area calc kr rhe h aur maxArea ko update kr rhe h

Time - O(4n)
