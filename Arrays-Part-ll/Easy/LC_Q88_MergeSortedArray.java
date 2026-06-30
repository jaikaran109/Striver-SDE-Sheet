class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;          // last valid element of nums1
        int j = n - 1;          // last element of nums2
        int k = m + n - 1;      // last position of nums1


// isme peeche se sort kr rhe h 

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}





// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int[] temp = new int[nums1.length];

//         int l = 0; 
//         int r = 0;

//         int i = 0;

//         while(l < m && r < n){
//             if(nums1[l] <= nums2[r]){
//                 temp[i]  = nums1[l];
//                 l++;
//             }else{
//                 temp[i] = nums2[r];
//                 r++;
//             }
//             i++;
//         }

//         while(l < m){
//             temp[i] = nums1[l];
//             i++;
//             l++;
//         }


//         while(r < n){
//             temp[i] = nums2[r];
//             i++;
//             r++;
//         }

//         for(int j = 0 ; j < nums1.length; j++){
//             nums1[j] = temp[j];
//         }

//     }
// }

// Time - O(m + n)
// Space - O(m + n)
