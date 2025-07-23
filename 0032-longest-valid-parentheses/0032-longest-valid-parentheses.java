class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int lastInvalid = -1;  // to track the last unmatched ')'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);  // store index
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();  // matched with previous '('
                    if (!stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    } else {
                        maxLen = Math.max(maxLen, i - lastInvalid);
                    }
                } else {
                    lastInvalid = i;  // unmatched ')'
                }
            }
        }

        return maxLen;
    }
}
