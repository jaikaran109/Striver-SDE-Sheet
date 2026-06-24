// Optimal - Log(m + n)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row1 = 0;
        int row2 = matrix.length - 1;
        int n = matrix[0].length - 1;

        int row = -1;

        while(row1 <= row2){
            int mid = row1 + (row2 - row1) / 2;
            if(target >= matrix[mid][0] && target <= matrix[mid][n]) {
                row = mid;
                break;
            }
            else if(matrix[mid][0] > target) row2 = mid - 1;
            else row1 = mid + 1;
        }

        if(row == -1) return false;

        int col1 = 0 , col2 = matrix[row].length - 1;
        while(col1 <= col2){
            int mid = col1 + (col2 - col1) / 2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] < target) col1 = mid + 1;
            else col2 = mid - 1;
        }
        return false;
    }
}







// nLog(n) - Better


// class Solution {
//     public boolean searchMatrix(int[][] nums, int target) {
//         for(int i = 0 ; i < nums.length ; i++){
//             int low = 0;
//             int high = nums[i].length - 1;
//             while(low <= high){
//                 int mid = low + (high - low)/2;
//                 if(nums[i][mid] == target) return true;
//                 else if(nums[i][mid] > target) high = mid - 1;
//                 else low = mid + 1;
//             }
//         }
//         return false;
//     }
// }



                                                        //   OR




// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int l = 0;
//         int r = matrix.length - 1;

//         while (l <= r) {

//             if (matrix[r][0] > target) {
//                 r--;
//             } else if (matrix[r][matrix[r].length - 1] >= target) {

//                 int left = 0, right = matrix[r].length - 1;
//                 while (left <= right) {
//                     int mid = left + (right - left) / 2;

//                     if (matrix[r][mid] == target) return true;
//                     else if (matrix[r][mid] > target) right = mid - 1;
//                     else left = mid + 1;
//                 }
//                 return false;
//             }

//             if (matrix[l][matrix[l].length - 1] < target) {
//                 l++;
//             } else if (matrix[l][0] <= target) {

//                 int left = 0, right = matrix[l].length - 1;
//                 while (left <= right) {
//                     int mid = left + (right - left) / 2;

//                     if (matrix[l][mid] == target) return true;
//                     else if (matrix[l][mid] > target) right = mid - 1;
//                     else left = mid + 1;
//                 }
//                 return false;
//             }
//         }

//         return false;
//     }
// }






// Brute Force

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         for(int i = 0;i<matrix.length;i++){
//             for(int j = 0;j<matrix[i].length;j++){
//                 if (target == matrix[i][j]){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }
