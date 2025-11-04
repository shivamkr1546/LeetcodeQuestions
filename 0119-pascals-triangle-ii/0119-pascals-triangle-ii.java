class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));

        for(int i=1; i<=rowIndex; i++){
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            List<Integer> prevRow = res.get(i - 1);
            for(int j=1; j<i; j++){
                newRow.add(prevRow.get(j) + prevRow.get(j-1));
            }
            newRow.add(1);
            res.add(newRow);
        }

        return res.get(rowIndex);
    }
}