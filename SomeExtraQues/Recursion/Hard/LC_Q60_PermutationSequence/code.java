class Solution {
    int fact(int n){
        if(n <= 1) return 1;
        return n * fact(n-1); 
    }

    void check(int n , int k , StringBuilder sb , boolean[] visit){
        if(n == 0) return;
        int fc = fact(n - 1);
        int block = (k-1)/fc;
        int i = 1 ; 
        while(block > 0 || visit[i]){
            if(!visit[i]) block--;
            i++;
        }
        sb.append(i);
        visit[i] = true;
        k = (k-1) % fc + 1;
        check(n-1,k,sb,visit);
    }

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n+1];
        check(n,k,sb,visited);
        return sb.toString();
    }

}



// Brute Force
// class Solution {

//     public String getPermutation(int n, int k) {

//         StringBuilder sb = new StringBuilder();

//         for (int i = 1; i <= n; i++) {
//             sb.append((char)(i + '0'));
//         }

//         List<String> ans = new ArrayList<>();

//         permute(sb.toString(), "", ans);

//         return ans.get(k - 1);
//     }

//     private void permute(String str, String temp, List<String> ans) {

//         if (str.length() == 0) {
//             ans.add(temp);
//             return;
//         }

//         for (int i = 0; i < str.length(); i++) {

//             char ch = str.charAt(i);

//             // isme jo current character h usko skip kr do aur baki pe phirse operate kro
//             String rest = str.substring(0, i) + str.substring(i + 1);

//             permute(rest, temp + ch, ans);
//         }
//     }
// }
