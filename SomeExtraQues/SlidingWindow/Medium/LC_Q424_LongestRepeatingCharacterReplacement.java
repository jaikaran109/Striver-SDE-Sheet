class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int maxFreq = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            while ((r - l + 1) - maxFreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
            r++;
        }
        return maxLen;
    }
}



// // Brute Force - Dry run for understanding 
// class Solution {
//     public int characterReplacement(String s, int k) {
//         int maxLen = 0;
//         for(int i = 0 ; i < s.length() ; i++){
//             int[] hash = new int[26];
//             int maxfreq = 0;
//             for(int j = i ; j < s.length() ;  j++){
//                 hash[s.charAt(j) - 'A']++;
//                 maxfreq = Math.max(maxfreq,hash[s.charAt(j) - 'A']);
//                 int changes = (j - i + 1) - maxfreq;
//                 if(changes <= k){
//                     maxLen = Math.max(j - i + 1 , maxLen);
//                 }else{
//                     break;
//                 }
//             }
//         }
//         return maxLen;
//     }
// }
