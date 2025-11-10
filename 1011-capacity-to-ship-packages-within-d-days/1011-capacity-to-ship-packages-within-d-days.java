class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int h = 0;
        for(int w : weights){
            l = Math.max(l , w);
            h += w;
        }        
        return binarySearch(weights, days, l, h);
    }

    public int binarySearch(int[] weights, int days, int l, int h){
        int ans = -1;
        while(l<=h){
            int cap = l + (h - l)/2;
            if(check(weights, cap) <= days){
                ans = cap;
                h = cap - 1;
            }else{
                l = cap + 1;
            }
        }
        return ans;
    }

    public int check(int[] weights, int cap){
        int dayCnt = 1;
        int load = 0;
        for(int i=0; i<weights.length; i++){
            if(weights[i] + load > cap){
                dayCnt++;
                load = 0;
            }
            load += weights[i];
        }
        return dayCnt;
    }
}