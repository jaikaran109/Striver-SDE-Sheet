class Solution {
    public int findKRotation(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] > arr[high]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}


// class Solution {
//     public int findKRotation(int arr[]) {
//         for(int i = 0 ; i < arr.length - 1 ; i++){
//             if(arr[i] > arr[i+1]) return i+1;
//         }
//         return 0;
//     }
// }
