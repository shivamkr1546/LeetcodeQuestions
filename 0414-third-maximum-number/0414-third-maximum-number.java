class Solution {
    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer smax = null;
        Integer tmax = null;

        for (int n : nums) {
            Integer num = n;
            if (num.equals(max) || num.equals(smax) || num.equals(tmax)) {
                continue;
            }

            if (max == null || num > max) {
                tmax = smax;
                smax = max;
                max = num;
            } else if (smax == null || num > smax) {
                tmax = smax;
                smax = num;
            } else if (tmax == null || num > tmax) {
                tmax = num;
            }
        }

        return tmax != null ? tmax : max;
    }
}
