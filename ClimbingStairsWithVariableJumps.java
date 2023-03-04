// Climbing stairs with variable jumps
// This time you want to find the number of valid paths available to reach the top at n from 0th stair.
// and jumps are not fixed also this time.
// using tabulation method

public class Main
{
    static int[] arr = {3,3,0,2,2,3};
	public static void main(String[] args) {
	   System.out.println(countPaths(6));
	}
	
	public static int countPaths(int n){
	    int[] dp = new int[n + 1];
	    dp[n] = 1; // from 6 to 6 there is only one i.e. not move
	    // i + j < dp.length so that it will not cross the array
	    for(int i = n - 1; i >= 0; i--){
	        for(int j = 1; j <= arr[i] && i + j < dp.length; j++){
	            dp[i] += dp[i + j]; // if from i you can jumps 3 index than you will add all the paths from 
	            // dp[i + 1] to 6 , dp[i + 2] to 6 , dp[i + 3] to 6.
	        }
	    }
	    return dp[0]; // that means it contains the number of valid paths available from 0 to 6
	}
}
