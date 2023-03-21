
https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/3321141/Easy-Java-Solution-With-Explanation

//  c----d
// /      \
// b       e
// \      /
//  a____f 

// abcdef 
// ik    j
// k will move from b to e and set third vertex of triangle 

// abf - triangle + 
// ab - left side (from i to k) + 
// bcdef - right side (from k to j)

// vs

// acf - triangle + 
// abc - left side +
// cdef - right side

// vs

// adf - triangle + 
// abcd - left side + 
// def - right side

// vs

// aef - triangle + 
// abcde - left side + 
// ef - right side

// minm of all these combinations will be stored
class Solution {
    public int minScoreTriangulation(int[] arr) {
      int[][] dp = new int[arr.length][arr.length];
		
		for(int g = 0; g < dp.length; g++){
		    for(int i = 0, j = g; j < dp[0].length; i++,j++){
		        if(g == 0){
		            dp[i][j] = 0; // single point a, b , c
		        }
		        else if(g == 1){
		            dp[i][j] = 0; // two point, single line a----b , b----c no triangle 
		        }
		        else if(g == 2){ // three size (abc) means one triangle so product of abc is stored
		            dp[i][j] = arr[i] * arr[i + 1] * arr[j]; 
		        }
		        else{
		            int min = Integer.MAX_VALUE;
		            for(int k = i+1; k <= j-1; k++){
		                int tri = arr[i] * arr[j] * arr[k];
		                int left = dp[i][k];
		                int right = dp[k][j];
		                int total = tri + left + right;
		                if(total < min){
		                    min = total;
		                }
		            }
		            dp[i][j] = min;
		        }
		    }
		}
		return dp[0][dp[0].length - 1];
    }
}
