// 1. You are given a number N, which represents the number of sides in a polygon.
// 2. You have to find the total number of ways in which the given polygon can be triangulated.

// Ek triangle banlo pehle uske ek base side kitne points he * uske dusre base side kitne points he 

// /_\5 * /_\2
// ek base side 5 points he mtlb 5 points ko kitne tarike se triangulate kia ja skta he
// ek base side 2 points he mtlb 2 points ko kitne tarike se triangulate kia ja skte he 
// for rectangle
// /\3*/\2 + /\2*/\3
// when you calculate for 4 size polygon rectangle no of ways it can be triangulataed is C2 ways
// for hexagon 
// /\5*/\2 + /\4*/\3 + /\3 * /\4 + /\2 * /\5
// when you calculate this value it is equal to C4 for 6 size polygon hexagon 
// so we can conclude that for n size polygon the no of ways it can be triangulated is Cn-2 ways


import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n){
	    n = n - 2;
	    
	    int[] dp = new int[n + 1];
	    dp[0] = 1;
	    dp[1] = 1;
	    
	    for(int i = 2; i <= n; i++){
	        for(int j = 0; j < i; j++){
	            dp[i] += dp[j] * dp[i - j - 1];
	        }
	    }
		return dp[n];
	 }
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}
