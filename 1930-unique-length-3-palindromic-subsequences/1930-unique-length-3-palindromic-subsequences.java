class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) first[idx] = i;
            last[idx] = i;
        }

        int count = 0;

        for (int c = 0; c < 26; c++) {
            int L = first[c], R = last[c];
            if (L != -1 && L < R) {
                boolean[] mid = new boolean[26];
                for (int i = L + 1; i < R; i++) {
                    mid[s.charAt(i) - 'a'] = true;
                }
                for (boolean exists : mid) {
                    if (exists) count++;
                }
            }
        }

        return count;
    }
}
