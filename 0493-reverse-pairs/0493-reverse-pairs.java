class Solution {
    public int mergeSort(int[] nums, int st, int en){
        int cnt = 0;
        if(st >= en) return cnt;

        int mid = st + (en - st)/2;
        cnt += mergeSort(nums, st, mid);
        cnt += mergeSort(nums, mid+1, en);
        cnt += countPairs(nums, st, mid, en);
        merge(nums, st, mid, en);
        return cnt;
    }

    public void merge(int[] nums, int st, int mid, int en){
        int[] temp = new int[en-st+1];
        int i = st;
        int j = mid + 1;
        int k = 0;

        while(i<=mid && j<=en){
            if(nums[i] < nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(i<=mid) temp[k++] = nums[i++];
        while(j<=en) temp[k++] = nums[j++];

        for(int x=0; x<temp.length; x++){
            nums[x+st] = temp[x];
        }
    }

    public int countPairs(int[] nums, int st, int mid, int en){
        int cnt = 0;
        int r = mid+1;
        for(int i=st; i<=mid; i++){
            while (r <= en && (long) nums[i] > 2L * (long) nums[r]) {
                r++;
            }
            cnt += r - (mid+1);
        }
        return cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}