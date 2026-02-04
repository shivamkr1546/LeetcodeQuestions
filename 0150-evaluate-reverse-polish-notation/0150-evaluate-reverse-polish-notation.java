class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        String str = "+-*/";
        int num = 0;
        for(int i=0; i<tokens.length; i++){
            if(str.indexOf(tokens[i]) == -1){
                st.push(Integer.parseInt(tokens[i]));
            }else{
                String s = tokens[i];
                if(s.equals("+")){
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a+b);
                }else if(s.equals("-")){
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a-b);
                }else if(s.equals("*")){
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a*b);
                }else{
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a/b);
                }
            }
        }
        return st.peek();
    }
}