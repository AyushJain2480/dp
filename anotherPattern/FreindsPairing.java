// Har friend ke pas 2 option he ya to vo single rahe ya kisi ke sath pair hojay
// f(n) -> n logo ko kitne tarike se single rkha ja skta he ya / pair up kia jaskta he
// tree bnake dekho variable calls dikhegi par hume count chahiye to variable calls 
// ni lgani pdegi manlo 5 bar f(4) lgegi count nikalne k lie to 5 * f(4) krdo
// f(6) = f(5) + 5 * f(4)
// f(n) = f(n - 1) + (n - 1) * f(n - 2)
// agar friend single rehna chahta he to 1 bache kitne  n - 1
// agar pair hona chahta he to kitne ways (n - 1) 2 pair hogy bche kitne n - 2

class Solution
{
    public long countFriendsPairings(int n) 
    { 
        long mod = (long)Math.pow(10,9) + 7;
        if(n == 1) return 1;
        if(n == 2) return 2;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + (i - 1) * dp[i - 2]) % mod;
        }
        return dp[n] % 1000000007;
    }
}    
 
