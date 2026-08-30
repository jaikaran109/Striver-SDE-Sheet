class Solution {
    boolean isPalindrome(String s , int i , int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


    void helper(int idx , String str , List<String> path , List<List<String>> ans){
        if(idx == str.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = idx ; i < str.length() ; i++){
            if(isPalindrome(str,idx,i)){
                path.add(str.substring(idx,i+1));
                helper(i+1,str,path,ans);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(0,s,path,ans);
        return ans;
    }
}
