
// TLE 
class Solution {
    public int superEggDrop(int k, int n) {
         int[][] dp = new int[k + 1][n + 1];
        
         for(int i = 1; i <= k; i++){
             for(int j = 1; j <= n; j++){
                 if(i == 1){
                     dp[i][j] = j;
                 }
                 else if(j == 1){
                     dp[i][j] = 1;
                 }
                 else{
                     int min = Integer.MAX_VALUE;
                     for(int m = j - 1, p = 0; m >= 0; p++ , m--){
                         int v1 = dp[i][m]; // egg survive
                         int v2 = dp[i - 1][p]; // egg breaks
                         int val = Math.max(v1,v2);
                         min = Math.min(min,val);
                     }
                     dp[i][j] = min + 1;
                 }
             }
         }
        return dp[k][n];
    }
}



class Solution 
{
    public int superEggDrop(int n, int k) 
	{
	    int[][] dp=new int[n+1][k+1];
        
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=k;j++){
                
	            if(i==1){
	                dp[i][j]=j;
	                continue;
	            }
	            if (j==1){
	                dp[i][j]=1;
	                continue;
	            }

	            int start=1;
	            int end=j;
	            int ans=Integer.MAX_VALUE;
                
	            while(start<end){
	                int mid=start+(end-start)/2;

	                int left=dp[i-1][mid-1];
	                int right=dp[i][j-mid];
                    
	                ans=Math.min(Math.max(left,right),ans);
                    
	                if (left==right){
	                    break;
	                }
	                if(left<right){
	                    start=mid+1;
                    }
	                else{
	                    end=mid;
	                }
                }
	            dp[i][j]=ans+1;
	        }
	    }
	    return dp[n][k];
	}
}
