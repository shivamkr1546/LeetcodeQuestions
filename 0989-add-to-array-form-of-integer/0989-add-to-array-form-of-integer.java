class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = nums.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += nums[i];
                i--;
            }
            res.addFirst(k % 10);
            k /= 10;
        }

        return res;
    }
}
