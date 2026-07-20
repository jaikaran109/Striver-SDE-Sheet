class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] lastseen = {-1,-1,-1};
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            lastseen[ch - 'a'] = i;
            if(lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1){
                count += 1 + Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2]));
            }
        }
        return count;
    }
}




// class Solution {
//     public int numberOfSubstrings(String s) {
//         int count = 0;
//         for(int i = 0 ; i < s.length() ; i++){
//             int[] hash = new int[3];
//             for(int j = i ; j < s.length() ; j++){
//                 hash[s.charAt(j) - 'a'] = 1;
//                 if(hash[0]+hash[1]+hash[2] == 3){
//                     count++;
//                 }

//                         // OR - Use this

//                 // if(hash[0]+hash[1]+hash[2] == 3){
//                 //     count += n - j;   -- agr substring mil gya to uske aage ke to sare valid hi rhenge hi
//                 //      break;
//                 // }
//             }
//         }
//         return count;
//     }
// }

// // Time - O(n^2)
// // Space - O(1)
