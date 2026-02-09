class Solution {
    public String resultingString(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(!st.isEmpty() && (Math.abs(st.peek() - c) == 1 || Math.abs(st.peek() - c) == 25)){
                st.pop();
            }else{
                st.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}