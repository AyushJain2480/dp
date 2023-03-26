class Solution {
    // k litre pani dalo top me or btao rth row me cth col par jo glass he 
    // usme kitna pani hoga
    public double champagneTower(int k, int r, int c) {
       double[][] dp = new double[100][100];
        
       dp[0][0] = k; // topmost glass me humne itna water dala
        
       for(int i = 0; i < 99; i++){
           for(int j = 0; j <= i; j++){
               if(dp[i][j] > 1.0){ // jha overflow he bs vhi usko full krdo or left right me adha adha bhrdo
                   double spare = dp[i][j] - 1.0;
                   dp[i][j] = 1.0;
                   double half = spare/2.0;
                   dp[i + 1][j] += half;
                   dp[i + 1][j + 1] += half;
               }
           }
       }
        return dp[r][c];
    }
}
