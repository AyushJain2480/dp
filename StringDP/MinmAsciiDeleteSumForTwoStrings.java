// f(s1,s2) = f(c1r1,c2r2) ---->f(r1,r2) when c1 = c2
//                   |------->min(c1 + f(r1,c2r2) , c2 + f(c1r1,r2)) when c1 != c2
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        for(int i = dp.length - 1; i >= 0; i--){
            for(int j = dp[0].length - 1; j >= 0; j--){
                if(i == dp.length - 1 && j == dp[0].length - 1){
                    dp[i][j] = 0;
                }
                else if(i == dp.length - 1){
                    dp[i][j] =  s2.charAt(j) + dp[i][j + 1];
                }
                else if(j == dp[0].length - 1){
                    dp[i][j] = s1.charAt(i) + dp[i + 1][j];
                }
                else{
                    if(s1.charAt(i) == s2.charAt(j)){
                        dp[i][j] = dp[i + 1][j + 1];
                    }else{
                        dp[i][j] = Math.min(s1.charAt(i) + dp[i+1][j], s2.charAt(j) + dp[i][j + 1]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}
// i thaught it like we have to delete all those character which are not a part of longest common subsequence . Hence getting minimum number of possible deletes and hence minimum ASCII sum.
class Solution {
   public int minimumDeleteSum(String s1, String s2) {
    int lcs = getLcs(s1, s2); // get the LCS using the modified method
    int sum = 0;
    for (char c : s1.toCharArray()) {
        sum += (int) c;
    }
    for (char c : s2.toCharArray()) {
        sum += (int) c;
    }
    return sum - 2 * lcs; // calculate the minimum ASCII delete sum
}

public int getLcs(String s1, String s2) {
   int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = dp[0].length - 2; j >= 0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1] + (int) s1.charAt(i);
                }else{
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
}
}
