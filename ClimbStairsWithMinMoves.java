// Climbing Stairs with minimum moves 
// climb from 0 th to nth stair in the minimum moves possible
// src ----> i1 --- x steps ---> destination
// |-------> i2 --- y steps ---> |
// |-------> i3 --- z steps ---> |
// 1 step   +   min(x, y, z)
// base case for finding total number of paths from 0 to n --> 10 se 10 chlo hi mat --> 1 path dp[n] = 1;
// base case for finding minm moves n se n chlo hi mat 0 moves dp[n] = 0;
// if we cannot reach n than we will store it as null (it is already) otherwise we store the min from x , y and z.

public class Main
{
  static int[] arr = {3,2,4,2,0,2,3,1,2,2};
	public static void main(String[] args) {
		System.out.println(minimumMoves(10));
	}
	
	public static Integer minimumMoves(int n){
	    Integer[] dp = new Integer[n + 1];
	    dp[n] = 0; // 0 moves
	    for(int i = n - 1; i >= 0; i--){
	        if(arr[i] > 0){ // if it is 0 that means no path is there so null tha vha null hi pda reh jayga
	            // let say arr[i] = 3 mean i + 1 , i + 2 , i + 3 age check krna pdega
	            int min = Integer.MAX_VALUE;
	            for(int j = 1; j < arr[i] && i + j < dp.length; j++){
	                if(dp[i + j] != null)
	                min = Math.min(dp[i + j] , min);
	            }
	            // if at i + 1 , i + 2, i + 3 null is present that means there is no path from all these 
	            // and min is not change it is as it is Integer.max so we have to store null that means it is not possible 
	            // but null is already there so find min + 1 if min is not equal to Integer.Max that means andar koi rasta tha
	            // in simple words if min == Integer.MAx matlb hum koi bhi ese raste nhi ja paye jiske age rasta ho n tak
	            if(min != Integer.MAX_VALUE){ // mtlb rasta he
	                dp[i] = min + 1;
	            }
	        }
	    }
	    return dp[0]; // dp[0] = null mila means rasta nhi mila 
	}
}
