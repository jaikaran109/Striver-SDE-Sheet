// Optimal

// isme hm element ke saath ye store kr rhe h ki usse kitne elements aise the jo usse chote the 
// in example1 : after all opterations array look like :-
//  [{100,1} , {80,1},{75,4},{85,6}  -- isme 80 and 75 wala nhi hoga kyuki vo 85 me cover ho ja rha h
// main logic - previous smaller element



class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            span += st.peek()[1];
            st.pop();
        }
        st.push(new int[]{price, span});
        return span;
    }
}



/* // Brute Force
// Time - O(no. of days)
// Space - O(no. of calls)
class StockSpanner {
    ArrayList<Integer> arr ;
    public StockSpanner() { 
        arr = new ArrayList<>();
    }
    
    public int next(int price) {
        arr.add(price);
        int count = 1;
        for(int i = arr.size() - 2 ; i >= 0 ; i--){
            if(arr.get(i) <= price) count++;
            else break;
        } 

        return count ;
    }
}
// ye brute force h , isme tmne ek global arraylist assign kiya h and usme spanner me values add ho rhi h and next() func me comparision */
