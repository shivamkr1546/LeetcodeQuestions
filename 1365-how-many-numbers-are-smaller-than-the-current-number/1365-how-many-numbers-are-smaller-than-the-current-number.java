class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.putIfAbsent(sorted[i],i);
        }

        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = map.get(nums[i]);
        }

        return res;
    }
}