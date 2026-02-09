class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int st = 0;
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') cnt++;
            else cnt--;
            if(cnt == 0){
                sb.append(s.substring(st+1, i));
                st = i+1;
            }
        }

        return new String(sb);
    }
}