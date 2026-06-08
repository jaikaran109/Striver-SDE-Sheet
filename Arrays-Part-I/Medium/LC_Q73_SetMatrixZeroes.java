class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0) {
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





// Brute Force
// class Solution {
//     public void setZeroes(int[][] matrix) {
//         List<int[]> points = new ArrayList<>();
//         for(int i = 0 ; i < matrix.length ; i++){
//             for(int j = 0 ; j < matrix[i].length ; j++){
//                 if(matrix[i][j] == 0){
//                     points.add(new int[]{i, j});
//                 }
//             }
//         }

//         for(int i = 0 ; i < points.size() ; i++){
//             makeZeroes(matrix,points.get(i)[0],points.get(i)[1]);
//         }
//     }

//     static int[][] makeZeroes(int[][] arr , int i , int j){
//         int k = 0;
//         while(k < arr.length){
//             arr[k][j] = 0;
//             k++;
//         }

//         k = 0 ;
//         while(k < arr[i].length){
//             arr[i][k] = 0;
//             k++;
//         }
//         return arr;
//     }
// }

// Time Complexity = O(n^3)
