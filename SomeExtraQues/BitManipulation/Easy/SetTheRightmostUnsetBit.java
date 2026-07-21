// GFG

class Solution {
    public int setBit(int n) {
        return n | (n + 1);
        
        // isme rightmost unset ko set krna h to hm n + 1 kr denge phir uske sath OR lenge
        // n = 15   ----> = 01111
        // n + 1 = 16 --> = 10000
        // phir jb OR loge to unset wala set ho jayega 
        
        // n = 1  ---> 1
        // n + 1 = 2 --> 10
        // OR ==> 11 -- isme 1 ko tm 01 ki tarah treat kroge 
        
        // kyuki 32 bit me agr 1 ko likho to 0000...30times then 1 means ==>> 000...26times...01
        // aur 2 ko 00000....10
    }
}
