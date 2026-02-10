class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        int i = 0;
        int j = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            } else {
                st1.push(s.charAt(i));
            }
            i++;
        }

        while (j < t.length()) {
            if (t.charAt(j) == '#') {
                if (!st2.isEmpty()) {
                    st2.pop();
                }
            } else {
                st2.push(t.charAt(j));
            }
            j++;
        }

        if (st1.size() != st2.size()) return false;

        while (!st1.isEmpty()) {
            if (!st1.pop().equals(st2.pop())) return false;
        }

        return true;
    }
}
