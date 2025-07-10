class Solution {
    public int arrangeCoins(int n) {
        long lo = 0;
        long hi = n;
        while(lo<=hi){
            long mid = lo + (hi - lo)/2;
            long coinUsed = mid*(mid+1)/2;
            if(coinUsed == n){
                return (int)mid;
            }
            if(n < coinUsed){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return (int)hi;
    }
}