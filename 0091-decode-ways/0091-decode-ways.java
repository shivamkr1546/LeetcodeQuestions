class Solution {
    int[] dp;

    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return recur(0, s);
    }

    public int recur(int i, String s) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;

        if (dp[i] != -1) return dp[i];

        int ways = recur(i + 1, s);

        if (i + 1 < s.length()) {
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (num <= 26) {
                ways += recur(i + 2, s);
            }
        }

        dp[i] = ways;
        return ways;
    }
}
