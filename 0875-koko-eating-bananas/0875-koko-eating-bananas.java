class Solution {
    public int minEatingSpeed(int[] piles, int t) {
        int l = 1;
        int h = Integer.MIN_VALUE;

        for(int p : piles){
            h = Math.max(h, p);
        }

        return binarySearch(piles, t, l, h);
    }

    public int binarySearch(int[] piles, int t, int l, int h){
        int ans = -1;
        while(l<=h){
            int speed = l + (h-l)/2;
            if(timeTaken(piles, speed) <= t){
                ans = speed;
                h = speed - 1;
            }else{
                l = speed + 1;
            }
        }
        return ans;
    }

    public int timeTaken(int[] piles, int speed){
        int time = 0;
        for(int i=0; i<piles.length; i++){
            time += Math.ceil(piles[i]/(double)speed);
        }
        return time;
    }
}