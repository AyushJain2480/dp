// 1 , 4 , 9 , 16 , 25
// n = 12 -> 1 + 1 + 1 + 1 + 1 + 1 +1 + 1 + 1 + 1 + 1 + 1 (12 perfect squares)
// 4 + 4 + 4 (3 ps)
// 9  + 9 exc
// 16 exc 
// ans if min 3

// n = 13 
// 4 + 4 + 4 + 1(4 ps)
// 4 + 9 (2ps)
// (13ps)
// 9 + 1 + 1 + 1 + 1 (5ps)
// 4 + 1 + ---
// min is 2
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j < n; j++){
               if(i - j * j < 0) break;
               min = Math.min(min , dp[i - j * j]);    
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}



