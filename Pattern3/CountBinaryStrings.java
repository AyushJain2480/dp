// count no of binary strings of length n with no consecutive 0's 
// another same q - > count no of binary strings of length n with no consecutive 1's
// let say n is 6 to vo sari strings nikal lo jo 0 se end hoti ho bashrte consecutive 0 na ho 
// or vo sari strings nikalo jo 1 se end hoti ho bashrte consecutive 0 na ho 
// inka sum hi total strings hogi of length n without any consecutive 0 
// dp[0][3] means count of appropriate binary strings of length 3 ending with 0
// dp[1][3] means count of appropriate binary strings of length 3 ending with 1 
// dp[0][6] badi problem count of binary strings of length 6 ending with 0 
// dp[1][6] count of binary strings of length 6 ending with 1
// dp[0][6] + dp[1][6] strings ending with 0 + strings ending with 1 = all strings with no consecutive 0
// you can use 2D dp array or two single dp array or no array with variable only
public class Main
{
	public static void main(String[] args) {
		System.out.println(binaryStringsWithNoConsecZeroes(6));
		System.out.println(same(6));
	}
	
	public static int binaryStringsWithNoConsecZeroes(int n){
	    int[][] dp = new int[2][n + 1];
	    dp[0][1] = 1;
	    dp[1][1] = 1;
	    
	    for(int j = 2; j <= n; j++){
	        dp[0][j] = dp[1][j - 1];
	        dp[1][j] = dp[0][j - 1] + dp[1][j - 1];
	    }
	    return dp[0][n] + dp[1][n];
	}
	
	public static int same(int n){
	    int oczeroes = 1;
	    int ocones = 1;
	    
	    for(int i = 2; i <= n; i++){
	        int nczeroes = ocones;
	        int ncones = oczeroes + ocones;
	        
	        ocones = ncones;
	        oczeroes = nczeroes;
	    }
	    return oczeroes + ocones;
	}
}
