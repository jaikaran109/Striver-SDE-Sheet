class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num <= 0 || num == 2 || num % 2 != 0) return false;  // prime no. and odd numbers are not perfect
        int original = num;

        int sum = 1;

        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0){
                sum += i;
                sum += num / i;
            }
        }
        return sum == num ;
    }
}


// Brute Force
// class Solution {
//     public boolean checkPerfectNumber(int num) {
//         int sum = 0;
//         for(int i = 1 ; i < num ; i++){
//             if(num % i == 0) sum += i;
//         }
//         return sum == num;
//     }
// }
