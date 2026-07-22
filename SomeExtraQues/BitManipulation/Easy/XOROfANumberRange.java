// GFG - Striver


class Solution {
    public static int findXOR(int l, int r) {
        return xorTillN(r) ^ xorTillN(l - 1);
    }

    private static int xorTillN(int n) {
        if(n % 4 == 0) return n;
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n + 1;
        return 0;
    }
}




// class Solution {
//     public static int findXOR(int l, int r) {
//         int ans = 0;
//         for(int i = l ; i <= r ; i++){
//             ans ^= i;
//         }
//         return ans ;
//     }
// }
