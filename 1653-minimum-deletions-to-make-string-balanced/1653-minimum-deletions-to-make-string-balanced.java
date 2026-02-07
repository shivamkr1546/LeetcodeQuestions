class Solution {
    public int minimumDeletions(String s) {
        int cnt = 0;
        int res = 0;

        for(char c : s.toCharArray()){
            if(c == 'b'){
                cnt++;
            }
            else{
                if(cnt > 0){
                    res++;
                    cnt--;
                }
            }
        }

        return res;
    }
}