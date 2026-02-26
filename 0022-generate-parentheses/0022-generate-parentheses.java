class Solution {
    public List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder("");
        solve(sb, n, 0, 0);   // track counts
        return res;
    }

    public boolean isValid(StringBuilder str){
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(') cnt++;
            else cnt--;
        }
        return cnt == 0;
    }

    public void solve(StringBuilder str, int n, int open, int close){
        if(str.length() == 2*n){
            res.add(str.toString());
            return;
        }

        if(open < n){
            str.append('(');
            solve(str, n, open+1, close);
            str.deleteCharAt(str.length() - 1);
        }

        if(close < open){
            str.append(')');
            solve(str, n, open, close+1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}