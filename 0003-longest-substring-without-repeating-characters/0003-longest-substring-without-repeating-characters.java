class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        for(int i=0; i<s.length(); i++){
            Set<Character> st = new HashSet<>();

            for(int j=i; j<s.length(); j++){
                char c = s.charAt(j);
                if(st.contains(c)) break;

                st.add(c);
                max = Math.max(max, j-i+1);
            }
        }

        return max;
    }
}