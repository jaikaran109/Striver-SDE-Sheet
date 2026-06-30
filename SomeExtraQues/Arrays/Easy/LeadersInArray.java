class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();

        int max = arr[arr.length - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }

        Collections.reverse(list);
        return list;
    }
}




// Brute Force
// i = 0 - n
// j = i - n
// check if a[j] > a[i] false break;
// else add
