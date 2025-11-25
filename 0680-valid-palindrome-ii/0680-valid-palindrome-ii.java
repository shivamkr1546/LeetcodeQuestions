class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return isPalin(s.substring(0,l) + s.substring(l+1)) || isPalin(s.substring(0,r) + s.substring(r+1));
            }
            l++;
            r--;
        }

        return true;
    }

    private boolean isPalin(String s){
        int l = 0, r = s.length() - 1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}