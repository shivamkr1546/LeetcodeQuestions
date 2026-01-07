class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();

        long sum = 0;
        long max = 0;
        int dup = 0;

        // first window
        for (int i = 0; i < k; i++) {
            int x = nums[i];
            int freq = mp.getOrDefault(x, 0);
            if (freq == 1) dup++;        // only 1 → 2 matters
            mp.put(x, freq + 1);
            sum += x;
        }

        if (dup == 0) max = sum;

        // slide window
        for (int i = k; i < n; i++) {
            int add = nums[i];
            int remove = nums[i - k];

            // add
            int addFreq = mp.getOrDefault(add, 0);
            if (addFreq == 1) dup++;
            mp.put(add, addFreq + 1);
            sum += add;

            // remove
            int remFreq = mp.get(remove);
            if (remFreq == 2) dup--;    // only 2 → 1 matters
            if (remFreq == 1) {
                mp.remove(remove);
            } else {
                mp.put(remove, remFreq - 1);
            }
            sum -= remove;

            if (dup == 0) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
