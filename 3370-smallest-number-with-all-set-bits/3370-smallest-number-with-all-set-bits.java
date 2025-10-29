class Solution {
    public int smallestNumber(int n) {
        if(n==1) return 1;
        for(int i=0; i<n; i++){
            if((int)Math.pow(2, i) > n){
                int res = (int)Math.pow(2, i);
                return res - 1;
            }
        }
        return -1;
    }
}