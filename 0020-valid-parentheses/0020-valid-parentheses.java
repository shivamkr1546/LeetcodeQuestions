class Solution {
    public boolean isValid(String a) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<a.length(); i++){
            char c = a.charAt(i);
            if(c == '[' || c == '{' || c == '('){
                s.push(c);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if(s.peek() == '(' && c == ')' 
                 || s.peek() == '{' && c == '}'
                 || s.peek() == '[' && c == ']'){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}