// 1. You are given a number n, representing the number of opening brackets ( and closing brackets )
// 2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
// e.g.
// for 1, answer is 1 -> ()
// for 2, answer is 2 -> ()(), (())
// for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))

// same as catalan number
// f(2) = f(1) * f(0) + f(0) * f(1)
// () ek bracket bnaya bacha ek bracket
// (1)0 ab vo andar askta he ek case me 
// (0)1 ek case me bracket bahar askta he 
// (())0
// ()() 
// total 2 possible arrangements using 2 pairs of brackets 
// f(1) means in how many ways 1 pair could be organise
// f(0) means in how many ways 0 pair could be organise

// f(4) = 
// (3)0 ek bna lia bche 3 ya to undar bahar 0 
// (2)1 undar = 2 bahar = 1
// (1)2 undar = 1 bahar = 2
// (0)3 undar = 0 bahar = 3

// f(3) * f(0) + f(2) * f(1) + f(1) * f(2) + f(0) * f(3)
// f(3) = (2)0 + (1)1 + (0)2
// f(4) = (3)0 + (2)1 + (1)2 + (0)3
// as we can see this is catalan number 
// pehle question me root fix kiya tha uske left or right variations nikale the mtlb subtrees 
// yha ek piar fix kiya or uske undar or bahar ke variations nikale
import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int[] dp = new int[n + 1];
    
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i < dp.length; i++){
        for(int j = 0; j < i; j++){
            dp[i] += dp[j] * dp[i - j - 1];
        }
    }
    System.out.println(dp[n]);
 }

}
