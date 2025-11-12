class Solution {
    public int minEatingSpeed(int[] p, int h) {
        int lo = 1;
        int hi = Integer.MIN_VALUE;

        for(int n : p){
            hi = Math.max(hi, n);
        }

        return binarySearch(p, h, lo, hi);
    }

    public int binarySearch(int[] p, int h, int lo, int hi){
        while(lo <= hi){
            int speed = lo + (hi - lo)/2;
            if(checkTime(p, speed) <= h){
                hi = speed - 1;
            }else{
                lo = speed + 1;
            }
        }
        return lo;
    }

    public int checkTime(int[] p, int speed){
        int timeTaken = 0;
        for(int n : p){
            timeTaken += Math.ceil(n/(double)speed);
        }
        return timeTaken;
    }
}