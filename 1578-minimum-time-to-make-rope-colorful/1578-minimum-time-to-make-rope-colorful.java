class Solution {
    public int minCost(String colors, int[] neededTime) {
        int l = 0;
        int res = 0;
        char[] c = colors.toCharArray();
        for(int r=1; r<c.length; r++){
            if(c[l] == c[r]){
                if(neededTime[l] < neededTime[r]){
                    res += neededTime[l];
                    l = r;
                }
                else res += neededTime[r];
            }else{
                l = r;
            }
        }
        return res;
    }
}