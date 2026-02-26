class Solution {
    public int cnt;

    public int totalNQueens(int n) {
        if (n == 0) return 0;

        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append('.');
            }
            board.add(row.toString());
        }
        cnt = 0;
        solve(board, 0);
        return cnt;
    }

    private boolean isValid(List<String> board, int row, int col) {
        // check column
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void solve(List<String> board, int row) {
        if (row == board.size()) {
            cnt++;
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (isValid(board, row, col)) {
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(col, 'Q');
                board.set(row, newRow.toString());

                solve(board, row + 1);

                newRow.setCharAt(col, '.');
                board.set(row, newRow.toString());
            }
        }
    }
}
