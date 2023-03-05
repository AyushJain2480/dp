// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

// In particular, dp[n] is set to 0 because if the person has already reached the top of the stairs, the cost
// of climbing is 0. Meanwhile, dp[n - 1] is set to cost[n - 1] because if the person starts at the second-to-last 
// stair and climbs to the last stair, the cost is simply cost[n - 1].

// By initializing the array dp with a length of n + 1, we are able to store the minimum cost of climbing from each 
// index, including the top of the stairs (i.e., dp[n] = 0) and the second-to-last stair (i.e., dp[n - 1] = cost[n - 1]).

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[n] = 0; // if you are at the top the cost is 0
        dp[n - 1] = cost[n - 1];
        
        for(int i = n - 2; i >= 0; --i){
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }
}

     
