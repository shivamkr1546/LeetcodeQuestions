class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> ans = new HashSet<>();

        for(int i=0; i<arr.length; i++){
            Set<Integer> st = new HashSet<>();
            for(int j=i+1; j<arr.length; j++){
                int third = -(arr[i] + arr[j]);
                if(st.contains(third)){
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                st.add(arr[j]);
            }  
        }

        return new ArrayList(ans);
    }
}