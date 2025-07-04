class Solution {
    public void backtrack(List<String> result, String str, int open, int close, int max){
        if(str.length() == max*2){
            result.add(str);
            return;
        }

        if(open < max){
            backtrack(result, str+"(", open+1, close, max);
        }

        if(close < open){
            backtrack(result, str+")", open, close+1, max);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
}