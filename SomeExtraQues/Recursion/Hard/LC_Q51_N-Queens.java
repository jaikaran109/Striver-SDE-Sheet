// Backtracking *


// For Better Understanding watch Apna College - Explaination video
// https://youtu.be/BdSJnIdR-4s?si=mW-2YwejyoLLmyfk

class Solution {

    boolean isSafe(char[][] board, int row, int col, int n) {

        // Column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q')
                return false;
        }

        // Right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    void solve(char[][] board, int row, int n,
               List<List<String>> ans) {

        // All queens placed
        if (row == n) {

            List<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }

            ans.add(list);
            return;
        }

        // Try every column
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                // Place
                board[row][col] = 'Q';

                solve(board, row + 1, n, ans);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        // Empty board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0, n, ans);

        return ans;
    }
}






// Explain 
// dekho queen 8 direction me move kr skti h -- up , down , diagonals
// to hm isSafe me vo directions hi counter kr rhe h , yha hm column wise elements fill kr rhe h to flow uper se neeche hoga 
// isiliye hm left and right diagonals check kr rhe h uper ke 
