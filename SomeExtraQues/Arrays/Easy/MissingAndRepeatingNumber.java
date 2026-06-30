class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        Arrays.sort(arr);

        int len = arr.length;

        long expectedSum = 1L * len * (len + 1) / 2;
        long sum = 0;

        int repeat = 0;

        for (int i = 0; i < len; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                repeat = arr[i];
            }

            sum += arr[i];
        }

        long missing = expectedSum - (sum - repeat);

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeat);
        ans.add((int) missing);

        return ans;
    }
}



// Brute Force
//  i = 0 --- n ;
//  nested j = 0 --- n - 1;
// if arr[j] == i ; count++;
// if count == 2 ; repeat = i ; outside j loop
// if count == 0 ; missing = i ; outside j loop

//  O(n^2);



// Better
// i = 0 --- n;
// create a hasharray of n + 1
// count occurence of all ele in there  index
// jiska 2 hoga vo repeating , 0 vo missing

// o(n)  nd space O(n)
