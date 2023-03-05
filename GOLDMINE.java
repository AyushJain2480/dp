// Goldmine (Find maximum gold)
// left se right dig karna he or max gold return karna jaha se milega usse fark ni pdta bs max gold nikalna he mine se
// 1] storage and meaning us cell se dig karna start kare right ki taraf to maxm kitna gold milega vo store karege
// 2] direction --> last col se dig karna start karege right ki taraf to right me or kuch he hi ni to gold us col cell me kitna 
// he vhi milega to choti problem hui ye 
// or badi problem bilkul left me hogi to right to left jayge par ek dikkat he pura niche se right to left jayge to boht se cell 
// calculate nhi hue hoge pehle or hume unki value chahiye to galat hojayga to hum pehle pura last col fill karege 
// fir us ki help se pura last 2nd col bharege fir uski help se pura last 3rd col fill karege from bottom to up 
// esa karte karte pura 0th col fill karege bottom to top 
// humara ans store hoga 0th array me jo maximum value he vo kyuki vo left side he extreme vha 0 se dig par maxm gold milega 
// 1 pe bhi maxm gold in that row har row ka maxm starting col me milega but hume unsab ka maximum chahiye 
// 3] Travel and solve
// 4 part me tod lenge last col , first row , last row, rest
// tabulation better h becoz java me memoization se StackOverflowError ata he

public class Main
{
	public static void main(String[] args) {
		int[][] arr = {
		    {0,1,4,2,8,2},
		    {4,3,6,5,0,4},
		    {1,2,4,1,4,6},
		    {2,0,7,3,2,2},
		    {3,1,5,9,2,4},
		    {2,7,0,8,5,1}
		};
		System.out.println(maxGold(arr));
	}
	
	public static int maxGold(int[][] arr){
	    int n = arr.length;
	    int m = arr[0].length;
	    int[][] dp = new int[n][m];
	    
	    for(int j = m - 1; j >= 0; j--){
	        for(int i = n - 1; i >= 0; i--){
    	        // last col
    	        if(j == n - 1){
    	            dp[i][j] = arr[i][j];
    	        }
    	        // first row
    	        else if(i == 0){
    	            dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1],dp[i + 1][j + 1]);
    	        }
    	        // last row
    	        else if(i == n - 1){
    	            dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1],dp[i - 1][j + 1]);
    	        }
    	        // rest
    	        else{
    	            dp[i][j] = arr[i][j] + Math.max(Math.max(dp[i][j + 1],dp[i - 1][j + 1]) , dp[i + 1][j + 1]);
    	        }
	        }
	    }
	    
	    int max = dp[0][0];
	    for(int i = 1; i < n; i++){
	        max = Math.max(dp[i][0] , max);
	    }
	    return max;
	}
}
