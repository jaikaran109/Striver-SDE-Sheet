// GFG Ques

class myStack {

    Stack<Integer> st;
    int n ;
    public myStack(int n) {
        // Define Data Structures
        st = new Stack<>();
        this.n = n;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return st.isEmpty();
    }

    public boolean isFull() {
        // check if the stack is full
        return st.size() == n;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        st.push(x);
        for(int i = 0 ; i < st.size() - 1 ; i++){
            st.push(st.pop());
        }
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(st.isEmpty()) return;
        st.pop();
    }

    public int peek() {
        // Returns the top element of the stack
        if(st.isEmpty()) return -1;
        return st.peek();
    }
}
