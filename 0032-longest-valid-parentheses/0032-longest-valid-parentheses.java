class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0, maxLen = 0;

        // Left to Right
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') open++;
            else close++;

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * close);
            } else if (close > open) {
                open = close = 0;
            }
        }

        // Reset counters
        open = close = 0;

        // Right to Left
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') close++;
            else open++;

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return maxLen;
    }
}
