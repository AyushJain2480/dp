
// thodi tough he par lets see the cases 
// n = 0 , 0 team hi ni he 
// k = 0 , 0 player hi ni he
// k = 1 , 1 (sabko ek hi team me daldo)
// n < k , 0 ((3) 4 team me bat hi ni sakte)
// n = k , 1(4 ko 4 team me batne k lie sb ek ek team me jayga)
// else formula 
// f(n,k) = k * f(n-1,k) + f(n-1,k-1)
// [1-2]{2} [12]{1}
//    \      /
//     123[2]
//  123[2] means 3 players ko 2 team me batna he to 3 bolega 12 se ki tum hi 2 team bnalo 
// ya 3 bolega 12 se tum 2 team bnalo 
// [1-2] 3 bolega yaha already 2 team he to khi bhi lg jao 
// [13-2] ,[1-23] or [12] yha to ek hi team he to 3 hi dusri team bnayga same contribution [12-3]
// total 3 ways thoda esa hi he explanation pura notes m pdo

import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k) {
        if(n == 0 || k == 0 || n < k){
            return 0;
        }
        
        long[][] dp = new long[k + 1][n + 1];
        
        for(int t = 1; t < dp.length; t++){
            for(int p = 1; p < dp[0].length; p++){
                if(p < t){
                    dp[t][p] = 0;
                }
                else if(p == t){
                    dp[t][p] = 1;
                }
                else{
                    dp[t][p] = dp[t - 1][p - 1] + dp[t][p - 1] * t;
                }
            }
        }
        return dp[k][n];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}
