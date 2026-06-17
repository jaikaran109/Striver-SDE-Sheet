class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.length() == 0) return 0;

        int sign = 1;
        int i = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        long ans = 0;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            ans = ans * 10 + (s.charAt(i) - '0');

            if (sign == 1 && ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (sign == -1 && -ans < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * ans);
    }
}
