// Review

class Solution {
    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int low, int high) {
        int count = 0;

        if (low >= high) return count;

        int mid = low + (high - low) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;
        int count = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                count += mid - left + 1;
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return count;
    }
}
// Time - O(nLogn)
// space - O(n)







// class Solution {
//     static int inversionCount(int arr[]) {
//         // Brute Force
//         int count = 0;
//         for(int i = 0 ; i < arr.length ; i++){
//             for(int j = i + 1 ; j < arr.length ; j++){
//                 if(arr[i] > arr[j]) count++;
//             }
//         }
//         return count;
//     }
// }

// // O(n^2)
