// GFG

class CheckBit {
    static boolean checkKthBit(int n, int k) {
        return (n & (1 << k)) != 0;  // jitna k ki value h utna 1 ko left shift kr do aur phir and lo
        
        // ex - n = 4 , k = 0
        // 4 - 100
        // 1 << 0 - 001 
        // and is 0 , so ans is false
    }
}



// Brute Force
// Binary me convert kro phir peeche se traverse kr ke check kro set h ya nhi 
