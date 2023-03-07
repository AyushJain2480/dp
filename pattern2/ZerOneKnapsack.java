// 0/1 knapsack dp Problem (similar as target subset sum problem and there is no duplicacy so we are using 2D array)
// bag fate nhi or maxm profit bhi mil jaye 
// agar capacity vala constraint nhi hota to sara dal dete to maxm profit mil jata 
// har element ke pas 2 choices he i mean ya to vo weight bag me dale ya nhi dale 
// agar n weights hoge to 2^n subsets bnjayge 
// its like vo subset chaiye jo capacity nhi violate kare or maximum profit bhi dede
// brute force way ye hoga ki sare weights ke pas 2 choices he to pehle sare subsets nikal lo 
// usme jin subsets ka sum means unke total weight ka sum capacity se kam ho ya barabar unhe rkhlo 
// unsbka profit sum nikallo or maxm return kardo par ye 2^n time lelega
// better approach is doing dp 
// lets see tabulation approach 
// as we know there are three key points
// 1] storage and meaning 
// int[] dp = new int[n + 1][cap + 1] same like target subset 
// meaning se phle is question ko dusre tarike se bhi dekh skte he 
// {2,5,1,3,4} balls = 7
// 7 balls me maximum runs banane he {2,5,1,3,4} in players ko use karke
// 2 - 15 (1st player 2 ball pe 15 run bna rha he)
// 5 - 14 (2nd player 5 ball pe 14 run bna rha he)
// 1 - 10 (3rd player 1 ball pe 10 run bna rha he)
// 3 - 45 (4th player 3 ball pe 45 run bna rha he)
// 4 - 30 (5th player 4 ball pe 30 run bna rha he)
// toh question he ki ap kisko batting karay ki maximum runs banjay 
// same as ap kin weights ko bag me rkhe ki maxm profit ho
// there is no duplicacy ek palyer ya to khelega ya nhi ek bar hi use hoga player 
// 3 ball he to 3 hi khelega esa nhi ki 2 khel lia ya 1 like 3 weight hi bag me jayga tod ni skte ki 2 dal dia 
// tabhi 0 / 1 knapsack nam he ya to jayga 1 ya nhi 0 
// now lets try to understand the meaning 
// what the last cell dp[n][capacity] means - 7 balls me {2,5,1,3,4} inme se kin players ko khilay ki maxm run ban jaye 
// dp[3][4] means 4 bag capacity me {2,5,1} me se kya dale ki maxm profit ajay or capacity bhi dhyan me rhe mtlb jyda na ho

// what are the maxm runs or profit you can make by using the balls or weights without violate the no of balls or capacity.

// agar player batting nhi krega to pure runs pichli team ne kitne banay vo dekho 
// agar player khelega to vo kitne run banayga + bache runs pichli team ne kitne banay vo dekho 
// inme se jo maxm hoga vo (j >= val) vale case me dp[i][j] me store hoga 
// to (j < val) me kya chl rha he ? 
// val is arr[i - 1] player to khel hi ni payga to upar baki team ne jitne bnay vhi rkhlo
// jab balls 0 hogi or players he tab 0 hi run bnege ya jab balls he players nhi he to bhi 0 banege 
// isley 0 row or 0 col skip krre he unme 0 hi ayga 

public class Main
{
	public static void main(String[] args) {
		int[] weights = {2,5,1,3,4};
		int[] value = {15,14,10,45,30};
		int capacity = 7;
		System.out.println(zerOneKnapsack(weights,value,capacity));
	}
	
	public static int zerOneKnapsack(int[] weights , int[] value , int capacity){
	    int n = weights.length;
	    int[][] dp = new int[n + 1][capacity + 1];
	    
	    for(int i = 1; i < dp.length; i++){
	        for(int j = 1; j < dp[0].length; j++){
	           int val = weights[i - 1];
	           if(j < val){
	               dp[i][j] = dp[i - 1][j];
	           }
	           else{
	               dp[i][j] = Math.max(dp[i - 1][j] , dp[i - 1][j - val] + value[i - 1]);
	           }
	        }
	    }
	    return dp[n][capacity];
	}
}
