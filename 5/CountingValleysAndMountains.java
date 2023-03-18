// 1. You are given a number n, representing the number of upstrokes / and number of downstrokes .
// 2. You are required to find the number of valleys and mountains you can create using strokes.
// Note -> At no point should we go below the sea-level. (number of downstrokes should never be more than number of upstrokes).

// This is also a catalan number.



// same h parenthesis jesa ek pair fix krege baki bache undar ya bahar kitni tarike se arrange krskte 

// f(3) = 
// /  \   -> 1 fix bache 2 
// undar 2 bahr 0    /2\0 (combinations)
// undar 0 bahr 2   /0\2  (combinations)
// undar 1 bahr 1  /1\1   (combinations)

// f(3) = f(2)* f(0) + f(1) * f(1) + f(0) * f(2)
// f(2) means undar 2 pair ke sare tarike * f(0) bahar 0 pairs ke sare tarike +
// f(1) means undar 1 pair ke sare tarike * f(1) bahr 1 pair ke sare tarike +
// f(0) means undar 0 pair ke sare tarike * f(2) bahr 2 pair ke sare tarike 

// /3\0 + /0\1 + /1\2 + /0\3 = f(4)

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int[] dp = new int[n + 1];
    dp[0] = 1;// means if we have 0 pair of downstrokes and upstrokes we have one way to create valleys and mountains just like 2^0 is 1
    dp[1] = 1; // if we have one pair than /\ one way possible 
    for(int i = 2; i < dp.length; i++){
        for(int j = 0; j < i; j++){
            dp[i] += dp[j] * dp[i - j - 1];
        }
    }
    System.out.println(dp[n]);
 }
}
