// Optimal Code Missing - 





// Brute Force

class Solution {
    public long subArrayRanges(int[] arr) {

        long sum = 0;  

        for(int i = 0 ; i < arr.length ; i++){
            int min = arr[i];
            long max = arr[i];
            for(int j = i ; j < arr.length ; j++){
                min = Math.min(min,arr[j]);
                max = Math.max(max,arr[j]);

                sum += (max - min); 
            }
        }

        return sum;
    }
}
