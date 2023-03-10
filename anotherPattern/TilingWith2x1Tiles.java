import java.io.*;
import java.util.*;

// if you fill the first tile vertically the left unfilled floor to add tiles are n - 1
// if you fill the first tile horizontally the left unfilled floor to add tiles are n - 2 and one block 2 x 1 
// that takes 1 so overall takes n - 2
// so the ans is f(n) = f(n - 1) + f(n - 2)
public class Main {

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       
       int n = sc.nextInt();
       int[] dp = new int[n + 1];
       
       dp[1] = 1;
       dp[2] = 2;
       for(int i = 3; i <= n; i++){
           dp[i] = dp[i - 1] + dp[i - 2];
       }
       System.out.println(dp[n]);
    }
}
