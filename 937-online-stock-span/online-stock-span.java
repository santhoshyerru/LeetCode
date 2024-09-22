class StockSpanner {
    Stack<Integer> st;
    List<Integer> li;
    public StockSpanner() {
        st = new Stack<>();
        li = new ArrayList<>();
    }
    
    public int next(int price) {
        li.add(price);
        while(!st.isEmpty() && li.get(st.peek())<=price){
            st.pop();
        }
        int PGI = st.isEmpty()?-1:st.peek();
        st.push(li.size()-1);
        return (li.size()-1-PGI);
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */