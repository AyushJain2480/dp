class Solution {
    public int minInsertions(String str) {
      // minm no. of insertions and deletions are same
      // ab[b][c]ab[d]a LPS = a b [a] b a 
      // the mark ones b,c,d are not taking part in palindrome becoze there pairs are missing 
      // to make abbcabda we have to insert the same no. of pairs in str to make it palindrome 
      // that is equal to str.length() - LPS (we are calculating the missing characters)
      // a[d]b[b][c]{a}[c][b]b[d]a this is palindrome 
       return str.length() - longestPalindromeSubseq(str);
    }
    // LPS -> using LCS
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s, reverse(s));
    }
    
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = dp[0].length - 2; j >= 0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
