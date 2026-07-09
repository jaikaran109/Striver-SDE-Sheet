class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int x : asteroids){
            if(x > 0) st.push(x);
            else {
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < -x) st.pop();
                if(st.isEmpty() || st.peek() < x) st.push(x);
                if(st.peek() == -x) st.pop();
            }
        }
        int n = st.size();
        int[] arr = new int[n];
        while(!st.isEmpty()){
            arr[--n] = st.pop();
        }
        return arr;
    }
}
