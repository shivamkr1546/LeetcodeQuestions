class Solution {
    public void helper(String s, int index, List<String> temp, List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<s.length(); i++){
            String substr = s.substring(index, i + 1);
            if (isPalindrome(substr)) {
                temp.add(substr);
                helper(s, i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str){
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(s, 0, temp, result);
        return result;
    }
}