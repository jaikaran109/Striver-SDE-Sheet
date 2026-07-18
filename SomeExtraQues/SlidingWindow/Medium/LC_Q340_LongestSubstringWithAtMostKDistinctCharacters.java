// Optimal -- same type ka ques phle solve kiya h - LC904 Find basket wala
class Solution {
    public int kDistinctChar(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0 , r = 0 , ans = 0;

        while(r < s.length()) {
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size() > k){
                map.put(s.charAt(l),map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }
            int len = r - l + 1;
            ans = Math.max(len,ans);
            r++;
        }
        return ans;
    }
}




// ye Brute force h 

// class Solution {
//     public int kDistinctChar(String s, int k) {

//         int ans = 0;

//         for (int i = 0; i < s.length(); i++) {

//             HashMap<Character, Integer> map = new HashMap<>();

//             for (int j = i; j < s.length(); j++) {

//                 char ch = s.charAt(j);
//                 map.put(ch, map.getOrDefault(ch, 0) + 1);

//                 if (map.size() > k) {
//                     break;
//                 }

//                 int len = j - i + 1;
//                 ans = Math.max(ans, len);
//             }
//         }

//         return ans;
//     }
// }
