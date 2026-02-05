class Node{
    int val;
    int min;

    public Node(int v, int m){
        this.val = v;
        this.min = m;
    }
}
class MinStack {
    Stack<Node> st;

    public MinStack() {
        st = new Stack<Node>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Node(val, val));
            return;
        }

        Node minTop = st.peek();
        int currMin = minTop.min;
        
        if(val < currMin){
            st.push(new Node(val, val));
            return;
        }

        st.push(new Node(val, currMin));
    }
    
    public void pop() {
        if(st.isEmpty()) return;

        st.pop();
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        Node top = st.peek();

        return top.val;
    }
    
    public int getMin() {
        if(st.isEmpty()) return -1;
        Node top = st.peek();

        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */