class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int l = 0;
        int r = c.length - 1;
        String vowels = "aeiouAEIOU";
        while(l<=r){
            while (l < r && vowels.indexOf(c[l]) == -1) {
                l++;
            }

            while (l < r && vowels.indexOf(c[r]) == -1) {
                r--;
            }

            char  temp = c[l];
            c[l] = c[r];
            c[r] = temp;

            l++;
            r--;
        }

        return new String(c);
    }
}