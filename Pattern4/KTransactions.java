class Solution {
    public int maxProfit(int p, int[] prices) {
        int[][] dp = new int[p + 1][prices.length];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int max = Integer.MIN_VALUE;
                for(int k = 0; k < j; k++){
                    max = Math.max(max , dp[i - 1][k] + (prices[j] - prices[k]));
                }
                dp[i][j] = Math.max(dp[i][j - 1], max);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
