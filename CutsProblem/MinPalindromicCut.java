// O(n3)
class Solution {
    public int minCut(String s) {
    	boolean[][] dp = new boolean[s.length()][s.length()];
		
		for(int g = 0; g < dp.length; g++){
		    for(int i = 0,j = g; j < dp.length; i++,j++){
		        if(g == 0){
		            dp[i][j] = true;
		        }
		        else if(g == 1){
		            if(s.charAt(i) == s.charAt(j)){
		                dp[i][j] = true;
		            }
		        }
		        else{
		            if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true){
		                dp[i][j] = true;
		            }else{
		                dp[i][j] = false;
		            }
		        }
		    }
		}
		
		int[][] strg = new int[s.length()][s.length()];
		
		for(int g = 0; g < strg.length; g++){
		    for(int i = 0,j = g; j < strg.length; i++,j++){
		        if(g == 0){
		            strg[i][j] = 0;
		        }
		        else if(g == 1){
		            if(s.charAt(i) == s.charAt(j)){
		                strg[i][j] = 0;
		            }else{
		                strg[i][j] = 1;
		            }
		        }
		        else{
		            // if it is a pal dont do anything if not than find cuts to make it pal
		            if(dp[i][j] == true){
		                strg[i][j] = 0;
		            }else{
		                int min = Integer.MAX_VALUE;
		                 for(int k = i; k < j; k++){
		                     int left = strg[i][k];
		                     int right = strg[k + 1][j];
		                     int total = left + right + 1;
		                     if(total < min){
		                         min = total;
		                     }
		                 }
		                 strg[i][j] = min;
		            }
		        }
		    }
		}
		return strg[0][s.length() - 1];
    }
}


// O(n2)
