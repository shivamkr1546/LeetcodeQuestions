import java.util.Stack;

class MinStack {

    private long mini;
    private Stack<Long> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()) {
            st.push(0L);
            mini = val;
        } else {
            long diff = val - mini;
            st.push(diff);
            if (diff < 0) {   // new minimum
                mini = val;
            }
        }
    }
    
    public void pop() {
        if (st.isEmpty()) return;

        long diff = st.pop();

        if (diff < 0) {
            mini = mini - diff;   // restore previous min
        }
    }
    
    public int top() {
        long diff = st.peek();

        if (diff >= 0) {
            return (int)(mini + diff);
        } else {
            return (int)mini;
        }
    }
    
    public int getMin() {
        return (int)mini;
    }
}
