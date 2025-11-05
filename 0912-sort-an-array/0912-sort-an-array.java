class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quicksort(int[] nums, int si, int ei){
        if(si>=ei){
            return;
        }

        int pIdx = partition(nums, si, ei);
        quicksort(nums,si, pIdx-1);
        quicksort(nums,pIdx+1, ei);
    }

    public static int partition(int[] nums, int si, int ei){
        int pivot = nums[ei];
        int i = si - 1;
        for(int j=si; j<ei; j++){
            if(nums[j]<pivot){
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        nums[ei] = nums[i];
        nums[i] = temp;
        return i;
    }
}