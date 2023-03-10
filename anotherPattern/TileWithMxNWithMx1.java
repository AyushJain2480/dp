import java.io.*;
import java.util.*;

// Tiling M x n floors with M x 1 tiles 
// fill first tile vertically of M x 1 remaining n - 1
// fill first tile horizantally of M x 1 remaining n - m
// left space is x right space is let y for filling them it takes x * y but x can be filled only in one way 
// f(m , n) = f(n - 1) + f(n - m)

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
       
        
        int[] dp = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
            if(i < m){
                dp[i] = 1; // we can place it horizontally 
            }
            else if(i == m){  // we can place horizontally and vertically as well 
                dp[i] = 2;
            }
            else{
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        System.out.println(dp[n]);
    }
}
