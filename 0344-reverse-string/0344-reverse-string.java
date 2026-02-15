class Solution {
    public void reverseString(char[] s) {
        recur(s, 0, s.length - 1);
    }

    public void recur(char[] s, int i, int j){
        if(i >= j) return;

        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;

        recur(s, i+1, j-1);
    }
}
