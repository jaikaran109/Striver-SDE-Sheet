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
