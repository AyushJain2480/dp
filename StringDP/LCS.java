class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    
    public int longestCommonSubsequence(String s1, String s2) {
        return lcs(s1, s2, 0, 0);
    }
    
    private int lcs(String s1, String s2, int i, int j) {
        if(i == s1.length() || j == s2.length()) {
            return 0;
        }
        String key = i + "," + j;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int result;
        if(s1.charAt(i) == s2.charAt(j)) {
            result = 1 + lcs(s1, s2, i+1, j+1);
        } else {
            int val1 = lcs(s1, s2, i+1, j);
            int val2 = lcs(s1, s2, i, j+1);
            result = Math.max(val1, val2);
        }
        map.put(key, result);
        return result;
    }
}


// tabulation top down 
class Solution {
   
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
