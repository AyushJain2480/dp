// coin change permutation
// coins = {2,3,5} amt = 7 total permutations are 5 as we see in coin change combinations there are 2 combinations
// but 5 permutations are possible 
// is bar har spot par sare possible coin ka asar lete jayge to permutations bn jaygi 
// coin vala loop undar hoga combinations me coin vala loop bahar tha 
public class Main
{
	public static void main(String[] args) {
	    int[] coins = {2,3,5};
	    int amt = 7;
	    System.out.println(coinChangePermutations(coins, amt));
	}
	
	public static int coinChangePermutations(int[] coins , int amt){
	    int[] dp = new int[amt + 1];
	    dp[0] = 1;
	    for(int j = 1; j < dp.length; j++){
	        for(int i = 0; i < coins.length; i++){
	            if(coins[i] <= j){
	                dp[j] += dp[j - coins[i]];
	            }
	        }
	    }
	    return dp[amt];
	}
}
