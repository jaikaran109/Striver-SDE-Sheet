// GFG


// isme right se 0 set krna h isiliye shift ki position len - k

class Solution {
    int replaceBit(int n, int k) {
        String s = Integer.toBinaryString(n);

        if(k > s.length()) return n;

        int pos = s.length() - k;

        return n & ~(1 << pos);
    }
}

        // isme jb tm k times n shift kr doge phir uska NOT loge tb usko chord kr sare 1 ho jaynge phir jb tm uska and loge n ke saath to K-th 0 ho jayega
