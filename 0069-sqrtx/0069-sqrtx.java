class Solution {
    public int mySqrt(int x) {
        int l = 1;
        int h = x;
        int ans = 0;
        while(l<=h){
            int mid = l + (h - l)/2;
            if(x == (long)mid * (long)mid){
                return mid;
            }else if(((long)mid * (long)mid) > x){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return h;
    }
}