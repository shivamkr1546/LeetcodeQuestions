class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int val : piles){
            min = Math.min(val, min);
            max = Math.max(val, max);
        }

        while(min<=max){
            int mid = min + (max - min)/2;
            if(check(piles, mid) <= h){
                ans = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return ans;
    }

    public int check(int[] piles, int s){
        int h = 0;
        for(int i=0; i<piles.length; i++){
            h += Math.ceil(piles[i] / (double)s);
        }
        return h;
    }
}