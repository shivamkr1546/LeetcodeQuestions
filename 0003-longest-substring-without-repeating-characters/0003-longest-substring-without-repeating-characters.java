class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int left = 0;
        int right = 0;
        int len = 0;

        while(right < s.length()){
            if(!st.contains(s.charAt(right))){
                st.add(s.charAt(right));
                int currLen = right - left + 1;
                len = Math.max(currLen , len);
                right++;
            }else{
                st.remove(s.charAt(left));
                left++;
            }
        }

        return len;
    }
}