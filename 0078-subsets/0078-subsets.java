class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(0, temp, nums);
        return ans;
    }

    public void solve(int idx, List<Integer> temp, int[] nums){
        if(idx == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        solve(idx+1, temp, nums);
        temp.remove(temp.size() - 1);
        solve(idx+1, temp, nums);
    }
}