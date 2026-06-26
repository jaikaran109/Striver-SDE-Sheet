// Optimal Approach
class Solution {
    public void setZeroes(int[][] matrix) {
        // if there is an 0 in any column or row then we can convert the whole row and col soo if you find a 0 then marks its row and column -- keep a tarck of row and col

        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(rows[i] || cols[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}




// // Brute Force
// class Solution {
//     public void setZeroes(int[][] arr) {
//         // if you found any 0 then mark the entire column and row -1 and when traversal of matrix is completed then travers once again and mark all the -1's 0

//         for(int i = 0 ; i < arr.length ; i++){
//             for(int j = 0 ; j < arr[0].length ; j++){
//                 if(arr[i][j] == 0){
//                     markNeg(arr,i,j);
//                 }
//             }
//         }

//         for(int i = 0 ; i < arr.length ; i++){
//             for(int j = 0 ; j < arr[0].length ; j++){
//                 if(arr[i][j] == -1){
//                     arr[i][j] = 0;
//                 }
//             }
//         }
//     }
//     static void markNeg(int[][] nums , int i , int j){
//         for(int k = 0 ; k < nums[0].length ; k++){
//             if (nums[i][k] != 0) {
//                 nums[i][k] = -1;
//             }
//         }
//         for(int k = 0 ; k < nums.length ; k++){
//             if (nums[k][j] != 0) {
//                 nums[k][j] = -1;
//             }
//         }
//     }
// }
