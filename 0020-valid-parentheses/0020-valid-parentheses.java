class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        String str = "({[";

        for(int i=0; i<s.length(); i++){
            if(str.indexOf(s.charAt(i)) != -1){
                st.push(s.charAt(i));
            }else{
                if(st.isEmpty()) return false;
                if(st.peek() == '(' && s.charAt(i) == ')'
                    || st.peek() == '{' && s.charAt(i) == '}'
                    || st.peek() == '[' && s.charAt(i) == ']'){
                        st.pop();
                    }else{
                        return false;
                    }
            }
        }

        return st.isEmpty() ? true : false;
    }
}