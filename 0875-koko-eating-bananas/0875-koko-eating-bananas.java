class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;

        int ans = 0;

        for(int i=0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }

        while(min<=max){
            int mid = min + (max - min)/2;
            if(calcTime(mid, piles) <= h){
                ans = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return ans;
    }

    public int calcTime(int s, int[] piles){
        int h = 0;
        for(int i=0; i<piles.length; i++){
            h += Math.ceil(piles[i] / (double)s);
        }
        return h;
    }
}