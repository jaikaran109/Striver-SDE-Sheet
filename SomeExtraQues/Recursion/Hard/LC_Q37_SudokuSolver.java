// Backtracking


// For theory - Striver
// for code - apna College


class Solution {

    public boolean isSafe(char[][] grid , int row , int col , int num){

        // valid hai ki nhi check kro

        // across row and col
        for(int i = 0 ; i < grid.length ; i++){
            if(grid[i][col] == (char)(num + '0')){
                return false;
            }
            if(grid[row][i] == (char)(num + '0')){
                return false;
            }
        }


        // in internal grid
        
        int startingRow = (row / 3) * 3;
        int startingCol = (col / 3) * 3;
        

        for(int i = startingRow ; i < startingRow + 3 ; i++){
            for(int j = startingCol ; j < startingCol + 3 ; j++){
                if(grid[i][j] == (char)(num + '0')){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean helper(char[][] b , int row , int col){

        if(row == b.length) return true;

        int nrow = 0;
        int ncol = 0;

        if(col != b.length-1){
            nrow = row;
            ncol = col + 1;
        }else{
            nrow = row + 1;
            ncol = 0;
        }

        if (b[row][col] != '.') {
            return helper(b, nrow, ncol);
        }

        // Empty place mil gya

        for (int i = 1; i <= 9; i++) {
            if (isSafe(b, row, col, i)) {
                b[row][col] = (char)(i + '0');
                if (helper(b, nrow, ncol)) {
                    return true;
                }
                b[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}
