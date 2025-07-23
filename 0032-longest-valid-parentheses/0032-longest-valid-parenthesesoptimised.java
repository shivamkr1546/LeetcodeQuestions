class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // base index
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i); // push index of '('
            } else {
                stack.pop(); // try to match with '('

                if (stack.isEmpty()) {
                    stack.push(i); // unmatched ')', reset base
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek()); // valid substring
                }
            }
        }

        return maxLen;
    }
}