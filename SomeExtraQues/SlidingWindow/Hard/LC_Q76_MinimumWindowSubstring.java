// Pehle r ko expand karte hain jab tak current window me t ke saare
// required characters cover na ho jayein.
//
// hash[] batata hai ki kisi character ki aur kitni requirement bachi hai.
// Agar hash[s.charAt(r)] > 0 hai, matlab current character required tha,
// isliye count increase karte hain.
//
// Jab count == t.length() ho jata hai, current window valid hai.
// Ab l ko aage badha kar window ko shrink karte hain aur minimum length update karte hain.
//
// Left character remove karte waqt uski hash value increase karte hain.
// Agar increase karne ke baad hash value > 0 ho gayi, matlab wo character
// ab window me insufficient ho gaya, isliye count decrease karte hain.
//
// Jaise hi count < t.length() hota hai, inner while stop ho jata hai.
// Phir r aage badhta hai aur window dobara expand hoti hai.


class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        int l = 0 , r = 0 , n = s.length() , m = t.length() , sIndex = -1 , minLen = Integer.MAX_VALUE , count = 0;
        for(int i = 0 ; i < m ; i++){
            hash[t.charAt(i)]++;
        }

        while(r < n){
            if(hash[s.charAt(r)] > 0) count++;
            hash[s.charAt(r)]--;
            while(count == t.length()){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) count--;
                l++;
            }
            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex,sIndex+minLen);
    }
}



// class Solution {
//     public String minWindow(String s, String t) {

//         int minLen = Integer.MAX_VALUE;
//         int sIndex = -1;
//         int m = s.length();
//         int n = t.length();

//         for(int i = 0 ; i < m ; i++){
//             int[] hash = new int[256];
//             int count = 0;
//             for(int j = 0 ; j < n ; j++){
//                 hash[t.charAt(j)]++;
//             }

//             for(int j = i ; j < m ; j++){
//                 if(hash[s.charAt(j)] > 0) count++;
//                 hash[s.charAt(j)]--;

//                 if(count == n) {
//                     if(j - i + 1 < minLen) {
//                        minLen = j - i + 1;
//                        sIndex = i;
//                     }
//                     break;
//                 }
//             }
//         }
//         if(sIndex == -1) return "";
//         return s.substring(sIndex,minLen+sIndex);
//     }
// }
