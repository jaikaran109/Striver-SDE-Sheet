// Strivers code

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int max = 0;
        
        // map me char aur uska last occured index rakhenge aur compare krte rho phir 
        HashMap<Character, Integer> map = new HashMap<>();


        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);

            if(map.containsKey(ch)) {
                l = Math.max(l, map.get(ch) + 1);  // agr contain kr rha h to max value do kyuki L peeche to check krega nhi
            }

            map.put(ch, i); // updated index ke saath character append kro

            int len = i - l + 1;
            max = Math.max(max, len);
        }

        return max;
    }
}


// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int maxLen = 0;

//         for(int i = 0 ; i < s.length() ; i++){

//             StringBuilder str = new StringBuilder();
//             int len = 0;

//             for(int j = i ; j < s.length() ; j++){
//                 if(str.indexOf(String.valueOf(s.charAt(j))) != -1) {
//                     break;
//                 }

//                 str.append(s.charAt(j));
//                 len++;
//                 maxLen = Math.max(maxLen,len);
//             }
//         }


//     // same code h bss check array ke help se kr rha

//     //  int ans = 0;
//     //    for (int i = 0; i < str.length(); i++) {
//     //        int[] hash = new int[256];  -- all arrays initialized with 0
//     //        for (int j = i; j < str.length(); j++) {
//     //            if (hash[str.charAt(j)] == 1) break;  
//     //            int len = j - i + 1;
//     //            ans = Math.max(ans, len);
//     //            hash[str.charAt(j)] = 1;
//     //        }
//     //    }

//         return maxLen;
//     }
// }
