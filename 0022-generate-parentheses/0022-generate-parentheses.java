class Solution {
    public List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder("");
        solve(sb, n, 0);
        return res;
    }

    public boolean isValid(StringBuilder str){
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(') cnt++;
            else cnt--;
            if(cnt<0) return false;
        }
        return cnt == 0;
    }

    public void solve(StringBuilder str, int n, int length){
        if(length == 2*n){
            if(isValid(str)){
                res.add(str.toString());
            }
            return;
        }

        str.append('(');
        solve(str, n, length+1);
        str.deleteCharAt(str.length() - 1);



        str.append(')');
        solve(str, n, length+1);
        str.deleteCharAt(str.length() - 1);    
    }
}