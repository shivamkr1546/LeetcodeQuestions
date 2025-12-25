class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1 = String.join("", word1);
        String str2 = String.join("", word2);

        if(str1.length() != str2.length()) return false;
        int i = 0;
        int j = 0;

        while(i<str1.length() && j<str2.length()){
            if(str1.charAt(i) != str2.charAt(j)) return false;
            i++;
            j++;
        }

        return true;
    }
}