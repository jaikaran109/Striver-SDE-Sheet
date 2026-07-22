class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;

        boolean isPositive = true;  // check krne ke liye number negative h ya positive

        if(dividend < 0 && divisor > 0) isPositive = false;
        if(dividend > 0 && divisor < 0) isPositive = false;

        long n = Math.abs((long) dividend); // abs lenge dono number ka 
        long d = Math.abs((long) divisor);

        long ans = 0;

        while(n >= d) {
            int count = 0;

            while(n >= (d << (count + 1))) {  // ye basically d^count+1(pow) hai 
                count++;
            }

            ans += (1L << count);
            n = n - (d << count); // n me se minus kr denge jo max power tk ja skta h and aise hi krte rhenge jb tk remaining number dividend se chota nhi ho jata
        }

        if(isPositive == false) ans = -ans;

        if(ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;  // agr ans int ke range se bhr ja rha ho to max or min return kr denge
        if(ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ans;
    }
}


// suppose dividend = 10 
// divisor = 3
// to counter se check krenge ki 3 ki power max kitni ho skti h jisse vo range me rhe dividend ke
// count = 3 
// minus = 10 - 9 = 1
// ab 1 , 3 se chota h to return kra denge
