class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder t1 = new StringBuilder();

        int i=0;
        int j=0;
        while(i<s.length()){
            if (s.charAt(i) != '#') {
                s1.append(s.charAt(i));
            } else {
                if (s1.length() > 0) {
                    s1.deleteCharAt(s1.length() - 1);
                }
            }
            i++;
        }

        while(j<t.length()){
            if (t.charAt(j) != '#') {
                t1.append(t.charAt(j));
            } else if (t1.length() > 0) {
                t1.deleteCharAt(t1.length() - 1);
            }
            j++;
        }

        return s1.toString().equals(t1.toString());

    }
}