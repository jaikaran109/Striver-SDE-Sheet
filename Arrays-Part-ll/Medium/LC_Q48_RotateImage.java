// Optimal
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}

// TC - N/2 * N/2 + N / 2
// Space - Nothing




// Brute Force
// class Solution {
//     public void rotate(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         int[][] ans = new int[m][n];

//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 ans[j][n - i - 1] = matrix[i][j];
//             }
//         }

//         for(int i = 0 ; i < m ; i++){
//             for(int j = 0 ; j < n ; j++){
//                 matrix[i][j] = ans[i][j];
//             }
//         }
//     }
// }

// TC - O(n^2)
// Space - O(n^2)
