class Solution {
    public void swap(int a, int b) {
        a = a ^ b;  // yha pe a ki value = a ^ b ho gyi
        b = a ^ b;  // yha a ^ b  means put the value of a -->> (a ^ b) ^ b  ---- to yha b ^ b = 0 ^ a = a 
        a = a ^ b;  // yha a ^ b means put the value of a -->> (a ^ b) ^ a ----- a ^ a = 0 ^ b = b

        System.out.println(a + " " + b);
    }
}
