// 1. You are given a number n.
// 2. You are required to find the value of nth catalan number.
// C0 -> 1
// C1 -> 1
// C2 -> 2
// C3 -> 5
// ..
// Cn -> C0.Cn-1 + C1.Cn-2 + .. + Cn-2.C1 + Cn-1.C0
// There is one question on leetcode unique binary search trees using dp this is exactly catalan number

// The problem you are trying to solve involves finding the number of structurally unique binary search trees with n nodes containing unique values from 1 to n.

// Interestingly, the solution to this problem is related to the Catalan numbers. The Catalan numbers represent the number of ways to arrange a certain type of object, specifically the number of ways to arrange a set of parentheses.

// The relationship between the Catalan numbers and the number of structurally unique binary search trees with n nodes is due to the fact that the Catalan numbers also represent the number of ways to arrange n+1 objects, where the first n objects represent nodes in a binary search tree and the (n+1)th object represents the root of the tree.

// Therefore, the solution you are implementing uses the formula for Catalan numbers, which involves a dynamic programming approach to calculate the values of the Catalan numbers up to a given n. This approach involves calculating each value of the Catalan number based on previously calculated values, similar to how the Fibonacci sequence is calculated.

// Overall, the connection between the Catalan numbers and the number of structurally unique binary search trees with n nodes is an interesting and useful result in mathematics and computer science.


// Explanation for the unique binary search trees

// IF we have 4 nodes consider each as root node and find its different left and right subtree possible 
// considering 1st node as a root node in 1,2,3,4
// numTree[4] = 
// considering 1st value as a root 
// now left side has 0 nodes left but right side has 3 nodes left
// numTree[1] * numTree[3] (combinations)
// recursion use hora he ki 3 node se kitne combination bnskte h vo store hoga pehle hi 
// considering 2nd value as a root 
// 1,2,3,4
// if 2 is root than in left only 1 is left and for right 3 and 4 is left 
// numTree[1] * numTree[2] (combinations) mtlb 2 node se kitne combination bnskte * 1 se 
// considering 3nd value as a root 
// 1,2,3,4
// if 3 is node left side has 1 and 2 and right side has 4 
// numTree[2] * numTree[1]
// considering last node as root node 
// numTree[3] * numTree[0]
// calcualte the sum of all the combinations.
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
