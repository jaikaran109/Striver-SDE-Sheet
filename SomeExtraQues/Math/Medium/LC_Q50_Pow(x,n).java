class Solution {
    public double myPow(double x, int n) {
        long power = n;
        
        if(power < 0) {
            power = -power;
        }

        double ans = 1.0;

        while(power > 0) {
            if(power % 2 == 1) {
                ans = ans * x;
                power--;
            } else {
                x = x * x;
                power = power / 2;
            }
        }

        if(n < 0) {
            ans = 1.0 / ans;
        }

        return ans;
    }
}

// Dekho ye easy h but dry run krna ek baar
// ex - num = 2 , pow = 8;
//      -- yha 2 * 2 = 4 * 4 = 16 * 16 = 256
//      -- isme number of steps km ho ja rhe h 
// for odd tm pow me se 1 minus kr ke phle hi add kr do phir ye wala method use kro

// for negative pow - tm usko positive me convert kr ke ans calculate kro phir last me 1 ko ans se divide kr dena bcz 2^(-8) => 1 / 2^8;








// class Solution {
//     public double myPow(double x, int n) {
//         return Math.pow(x,n);
//     }
// }
