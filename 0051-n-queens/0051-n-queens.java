class Solution {
    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        
        List<String> board = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringBuilder row = new StringBuilder();
            for(int j=0; j<n; j++){
                row.append('.');
            }
            board.add(row.toString());
        }

        solve(board, 0);
        return res;
    }

    public void solve(List<String> board, int row){
        if(row == board.size()){
            res.add(new ArrayList<>(board));
            return;
        }

        for(int i=0; i<board.size(); i++){
            if(isValid(board, row, i)){
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(i, 'Q');
                board.set(row, newRow.toString());

                solve(board, row+1);

                newRow.setCharAt(i, '.');
                board.set(row, newRow.toString());
            }
        }
    }

    public boolean isValid(List<String> board, int row, int col){
        //check for up
        for(int i=row-1; i>=0; i--){
            if(board.get(i).charAt(col) == 'Q') return false;
        }

        //check for right up diag
        for(int i=row-1, j=col-1; i>=0 && j>=0;  i--, j--){
            if(board.get(i).charAt(j) == 'Q') return false;
        }

        for(int i=row-1, j=col+1; i>=0 && j<board.size();  i--, j++){
            if(board.get(i).charAt(j) == 'Q') return false;
        }

        return true;
    }
}