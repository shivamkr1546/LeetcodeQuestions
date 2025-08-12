class Solution {
    public int binarySearch(int[] piles, int h, int min, int max){
        int res = -1;
        while(min<=max){
            int mid = min + (max - min)/2;
            if(countK(piles, mid) <= h){
                res = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return res;
    }

    public int countK(int[] piles, int mid){
        int hrs = 0;
        for(int i=0; i<piles.length; i++){
            hrs += Math.ceil(piles[i]/(double)mid);
        }
        return hrs;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int ele: piles){
            max = Math.max(max, ele);
        }

        return binarySearch(piles, h, min, max);
    }
}