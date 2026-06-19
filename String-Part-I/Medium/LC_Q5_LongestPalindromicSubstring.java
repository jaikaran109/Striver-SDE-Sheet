// Not Optimal

class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j < s.length() ; j++){
                if(isPalindromic(s,i,j)){
                    if ((j - i + 1) > ans.length())  ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }

    private boolean isPalindromic(String s , int i , int j){
        int l = i;
        int r = j;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
