class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        
        for (int row = 1; row < numRows; row++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            
            List<Integer> prevRow = result.get(row - 1);
            for (int col = 1; col < row; col++) {
                newRow.add(prevRow.get(col - 1) + prevRow.get(col));
            }
            
            newRow.add(1);
            result.add(newRow);
        }
        
        return result;
    }
}