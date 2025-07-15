class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        int vc = 0;
        int cc = 0;
        for(char c : word.toCharArray()){
            if(Character.isLetter(c)){
                if("aeiouAEIOU".indexOf(c) != -1){
                    vc++;
                }else{
                    cc++;
                }
            }else if(!Character.isDigit(c)){
                return false;
            }
        }
        return vc >= 1 && cc >=1;
    }
}