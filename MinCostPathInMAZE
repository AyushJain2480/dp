// Minimum cost path in 2DMatrix or maze 
// using tabulation here 
// Let say you want to go to delhi from chandigarh and there are 3 paths so you have to find the min cost path 
// ek dp array bnayge same size jo given cost array ki he 
// 1] storage (done) and meaning dp[i][j] me kya rkha hoga ? yaha se destination jane ke jitne bhi raste he 
// unme se sabse cheap rasta jo hoga vo pada hoga 
// 2] Direction (choti problem kaha hogi vo dekho) destination se destination jane ki cost min hogi kyuki sirf vhi cost lgegi
// to ye choti problem he par src se destination jane ki cost sabse jyada he to badi problem hui
// to direction choti problem se badi problem ki taraf hogi mtlb bottom to top
// 3] Travel and solve
// we will divide this dp array into 4 parts 
// 1] when you are in last cell the cost is same jo arr ke last me padi he
// 2] when you are in last row sirf age ja skte ho (us cell ki cost + age vale cell se destination ki cost)
// 3] when you are in last col sirf niche ja skte ho (us cell ki cost + niche vale cell se destination ki cost)
// 4] rest of the array jisme niche or aage dono jagah ja skte ho 
//   (us cell ki cost + min(niche vale cell se dest ki cost, age vale cell se dest ki cost))
// at last ans dp[0][0] me miljayga
public class Main
{
	public static void main(String[] args) {
	    int[][] arr = {
	        {2,4,8,1,6,4,2},
	        {6,0,9,5,3,8,5},
	        {1,4,3,4,0,6,5},
	        {6,4,7,2,4,6,1},
	        {1,0,3,7,1,2,7},
	        {1,5,3,2,3,0,9},
	        {2,2,5,1,9,8,2}
	    };
		System.out.println(minCostPath(arr));
	}
	public static int minCostPath(int[][] arr){
	    int n = arr.length;
	    int m = arr[0].length;
	    int[][] dp = new int[n][m];
	    for(int i = n - 1; i >= 0; i--){
	        for(int j = m - 1; j >= 0; j--){
	            // if you are in last cell
	            if(i == n - 1 && j == m - 1){
	                dp[i][j] = arr[i][j];
	            }
	            // if you are in last row only
	            else if(i == n - 1){
	                dp[i][j] = arr[i][j] + dp[i][j + 1]; //  ---> 
	            }
	            // if you are in last col only
	            else if(j == m - 1){
	                dp[i][j] = arr[i][j] + dp[i + 1][j];
	            }
	            // rest of the array
	            else{
	                dp[i][j] = arr[i][j] + Math.min(dp[i + 1][j] , dp[i][j + 1]);
	            }
	        }
	    }
	    return dp[0][0];
	}
}
