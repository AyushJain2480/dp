// agar sare elements ka sum odd he let say 17 or hume 2 subsets me divide karna he vo bhi equal to possible hi ni he
// kyuki manlo kuch elements jo ek subset me he kuch sum 8 sum bna rhe he or kuch manlo 9 bna die to vo to ek odd bnayga 
// or ek even to equal hoge hi ni
// dusra case agar even ho sum let say 24 to ek case he ki kuch elements 12 bnayge sum or baki bhi 12 bnayge 
// [a1,a2,a3,a4] --> 12 [b1,b2,b3] ---> 12 so like target should be half of the sum of all the elements in the array 
// for odd return false for even find target and than do similar to subset sum with target
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        return sumSubsets(nums, target);
    }
    
    // hum check karre he puri array me ki let say sum is 24 we are checking ki kya kuch elements 12 sum bna rhe he
    // socho agar ha bna rhe he to bache hue elements milke bhi to 12 hi bnayge 
    // [1,5,11,5] inka sum he 22 to half mtlb 11 kya 11 kuch elements bna rhe he han [5,5,1] to bache hue bhi 11 bnayge 
    // as sum is 22 [11].
    public boolean sumSubsets(int[] arr , int target){
	    int n = arr.length;
	    boolean[][] dp = new boolean[n + 1][target + 1];
	    
	    for(int i = 0; i < dp.length; i++){
	        for(int j = 0; j < dp[0].length; j++){
	            if(i == 0 && j == 0){
	                dp[i][j] = true;
	            }
	            else if(i == 0){
	                dp[i][j] = false;
	            }
	            else if(j == 0){
	                dp[i][j] = true;
	            }
	            else{
	                int val = arr[i - 1];
	                if(j < val){
	                    dp[i][j] = dp[i - 1][j];
	                }else{
	                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - val]);
	                }
	            }
	        }
	    }
	    return dp[n][target];
	}
}
