class Solution {
    public int findComplement(int num) {
        int len = (int)(Math.log(num) / Math.log(2)) + 1;  // jo number h uski Binary Representation ki length kitni hogi
        int mask = (1 << len) - 1;  // -1 krne se jo 1 hoga vo 0 ho jayega and baki 1 , neeche example me dekho
        return num ^ mask; // jb tm kisi number ke binary form ko sare 1's ke saath xor loge to vo flip ho jati h
    }
}

// ex - num = 5
// 5 - 101
// binary me length nikalo aur + 1 kro to 3 aayega , kyuki 2.343 ko int me krne pe 2 aa rha h and + 1 --->> Len = 3
// ab mask me tm 1 ko 3 bits left shift kr rhe ho --->> 1000
// ab Dhyan do jb tm -1 krte ho to binary --->> 0111 ye ho jayegi
// ab yha 5 - 101 and mask me sare 3 places pe 111 h ab tm XOR loge to same bits 0 ho jayenge and diff wale 1 , Ho gya na Flip
