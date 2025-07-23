class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int prevIdx = s.pop();
                ans[prevIdx] = i - prevIdx;
            }
            s.push(i);
        }

        return ans;
    }
}