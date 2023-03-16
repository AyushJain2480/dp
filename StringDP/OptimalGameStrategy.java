// using the gap strategy 
// Sometimes you do things, sometime things happen to you when you do things you have to do your best 
// when things happen to you assume the worst
import java.io.*;
import java.util.*;

public class Main {

	public static void optimalStrategy(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];
		
		for(int g = 0; g < arr.length; g++){
		    for(int i = 0, j = g; j < arr.length; i++,j++){
		        if(g == 0){
		            dp[i][j] = arr[j];
		        }
		        else if(g == 1){
		            dp[i][j] = Math.max(arr[i],arr[j]);
		        }
		        else{
		            int val1 = arr[i] + Math.min(dp[i + 2][j] , dp[i + 1][j - 1]);
		            int val2 = arr[j] + Math.min(dp[i][j - 2] , dp[i + 1][j - 1]);
		            int val = Math.max(val1,val2);
		            dp[i][j] = val;
		        }
		    }
		}
		System.out.println(dp[0][dp[0].length - 1]);
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scn.nextInt();
		}
		optimalStrategy(a);
	}

}
