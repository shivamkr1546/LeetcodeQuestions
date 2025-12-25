class Solution {
    public int compress(char[] chars) {
        int idxAns = 0;
        int idx = 0;
        while(idx<chars.length){
            char currChar = chars[idx];
            int cnt = 0;
            while(idx<chars.length && chars[idx] == currChar){
                idx++;
                cnt++;
            }

            chars[idxAns++] = currChar;
            if(cnt!=1){
                for(char c : Integer.toString(cnt).toCharArray()){
                    chars[idxAns++] = c;
                }
            }
        }

        return idxAns;
    }
}