class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;

        // Dhyaan do jitne bhi numbers 2 ki power me hote h unme bss ek hi 1 hota h baki sare 0 hote h 
        // ab tm n - 1 se and loge to sare opposite rhenge tb AND 0 aayega

        // ex :- n = 16
        // 16 - 10000
        // 15 - 01111
        // AND - 00000 => ans 0


        // ex:- n = 17
        // 17 - 10001
        // 16 - 10000
        // AND - 10000 != 0 false

        // jb tm kisi aur number ka AND loge n - 1 ke saath to vo hrdm not equal to 0 hoga

    }
}
