// we are using here Left half right half strategy
// 8 = (1* + 7*) vs (2* + 6*) vs (3* + 5*) vs (4* + 4*) vs (org price of 8)
// mid of 8 is 4 so we will not go beyond mid upto 4 only in this case
// maxm is the ans 


// we can solve this problem with cut strategy also 
// a --> original price 
// a* --> tod tad ke maxm kitni price me becha
// 8 = (1 + 7*) vs (2 + 6*) vs (3 + 5*) vs (4 + 4*) vs (5 + 3*) vs (6 + 4*) vs (7 + 1*) vs 8

class Solution{
    public int cutRod(int price[], int n) {
        int[] np = new int[price.length + 1];
        // 1 length rod price will be now at index 1 before it is at 0th index
        for(int i = 0; i < price.length; i++){
            np[i + 1] = price[i];
        }
        
        int[] dp = new int[np.length];
        dp[0] = 0; // 0 length rod obv price is 0
        dp[1] = np[1]; // 1 length rod obv the original price is ans
        
        for(int i = 2; i < dp.length; i++){
            dp[i] = np[i]; // storing org price of 8
            
            int li = 1;
            int ri = i - 1;
            while(li <= ri){
                if(dp[li] + dp[ri] > dp[i]){
                    dp[i] = dp[li] + dp[ri];
                }
                li++;
                ri--;
            }
        }
        return dp[dp.length - 1];
    }
}
