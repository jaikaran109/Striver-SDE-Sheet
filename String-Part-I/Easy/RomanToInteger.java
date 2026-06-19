class Solution {
    public int romanToInt(String s) {

        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {

            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                ans += map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i + 1))
                     - map.get(s.charAt(i));
                i++;
            }
        }

        if (s.length() > 0 &&
            map.get(s.charAt(s.length() - 1))
            <= map.get(s.charAt(Math.max(0, s.length() - 2)))) {

            ans += map.get(s.charAt(s.length() - 1));
        }

        return ans;
    }
}




// class Solution {
//     public int romanToInt(String s) {

//         HashMap<Character, Integer> map = new HashMap<>();

//         map.put('I', 1);
//         map.put('V', 5);
//         map.put('X', 10);
//         map.put('L', 50);
//         map.put('C', 100);
//         map.put('D', 500);
//         map.put('M', 1000);

//         int ans = 0;

//         for (int i = 0; i < s.length() - 1; i++) {

//             int curr = map.get(s.charAt(i));
//             int next = map.get(s.charAt(i + 1));

//             if (curr < next) {
//                 ans -= curr;
//             } else {
//                 ans += curr;
//             }
//         }

//         ans += map.get(s.charAt(s.length() - 1));

//         return ans;
//     }
// }
