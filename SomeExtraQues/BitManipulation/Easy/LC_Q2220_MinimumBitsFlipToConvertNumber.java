class Solution {
    public int minBitFlips(int start, int goal) {
        int x = goal ^ start;
        int count = 0;
        while(x > 0){
            x = x & (x-1);
            count++;
        }
        return count;
    }
}

// Dhyaan dena yha 
// n = 10 , goal = 7
// 10 - 1010
// 7 - 0111
// ab tm iska XOR loge agr to tmko vo hi bits 1 milengi jo different hongi aur agr tm unn bits ko flip kr do to ans aa jayega

// x = goal ^ n - 1101
// ab inko count kr lo 



// 10 - 1010 isme agr tm 3 flips kro to 7 mil ja rha h 
