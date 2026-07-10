// Review
// use recursion for sorting - it reduce space from O(n) to O(1)


class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        
        Collections.sort(list);
        
        for(int i = 0 ; i < list.size() ; i++){
            st.push(list.get(i));
        }
        
    }
}
