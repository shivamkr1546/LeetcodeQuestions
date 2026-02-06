class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        String str = "({[";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(str.indexOf(c) != -1){
                st.push(c);
            }else{
                if(st.isEmpty()) return false;
                if(st.peek() == '(' && c == ')'
                 || st.peek() == '[' && c == ']'
                 || st.peek() == '{' && c == '}'){
                    st.pop();
                 }else{
                    return false;
                 }
            }
        }

        return st.isEmpty() ? true : false;
    }
}