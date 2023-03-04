// Climbing stairs 
// In one move you are allowed to move 1 stairs, 2 stairs or 3 stairs
// one question can be to print the paths via which you climb the top 
// but here the question is how many ways you can reach the 0th stair from nth stair like it is same as 
// finding number of valid paths to reach the top
public class Main
{
	public static void main(String[] args) {
	   // int ans = countPaths(10);
	   // System.out.println(ans);
	   
	   //int ans = memoizedCountPaths(10 , new int[11]);
	   //System.out.println(ans);
	}
	
	public static int countPaths(int n){
	    if(n == 0){ // valid base case you have reached the 0th stair and there is only one way you can reach 0 to 0 dont move
	        return 1;
	    }else if(n < 0){ // not valid case you have reached the basement and from there if you move further than also 
	    // you will only reach the inner basements or if you think to stop there than also it is not possible to reach from basement to 0 
	        return 0;
	    } 
	    System.out.println("funcall" + n);
	    int nm1 = countPaths(n - 1); // give me num of valid paths from n - 1 to 0
	    int nm2 = countPaths(n - 2); // give me num of valid paths from n - 2 to 0
	    int nm3 = countPaths(n - 3); // give me num of valid paths from n - 3 to 0
	    int cp = nm1 + nm2 + nm3; // total num of valid paths available to reach the 0th stair
	    return cp;
	}
	
	// you can use the qb array as global in that case you don't need to pass it inside the function 
	// using memoization to reduce the number of function calls if we know that from  4 to 0 we have 4 paths
	// than why calculating it again and again it is not good.
	public static int memoizedCountPaths(int n , int[] qb){
	    if(n == 0){
	        return 1;
	    }else if(n < 0){
	        return 0;
	    }
	    // same if it is present in the qb arrayy return it no need to call it again to find the no of paths
	    if(qb[n] != 0){
	        return qb[n];
	    }
	    System.out.println("funcall" + n);
	    int nm1 = memoizedCountPaths(n - 1, qb);
	    int nm2 = memoizedCountPaths(n - 2, qb);
	    int nm3 = memoizedCountPaths(n - 3, qb);
	    int cp = nm1 + nm2 + nm3;
	    qb[n] = cp; // store it before returning
	    return cp;
	}
	
	// using tabulation method 
	// 1] Storage and meaning (storing 10 - 0 paths in 10th index so it requires the array 1 greater than n)
	// 2] Direction (<> choti problem kis side he 0 - 0 choti problem he 10 - 0 to nikalna he) left to right
	// 3] travel and  solve
	
	// n se 0 ke paths chahiye 3 call lgao n - 1 (ek kdam piche) n - 2(do kadam piche) n - 3 (3 kadam piche)
	// if (n goes -ve that means there is no path available so return 0)
	public int tabulation(int n){
	    if(n < 0) return 0;
	    if(n == 0 || n == 1) return 1;
	    if(n == 2) return 2;
	    int qb = new int[n + 1];
	    qb[0] = 1;
	    qb[1] = 1;
	    qb[2] = 2;
	    for(int i = 3; i < dp.length; i++){
	        qb[i] = qb[i - 1] + qb[i - 2] + qb[i - 3];
	    }
	    return dp[n];
	}
	
	// just for learning
	for(int i = 0; i < dp.length; i++){
		if(i == 1){
		    qb[i] = qb[i - 1];
		}else if(i == 2){
		    qb[i] = qb[i - 1] + qb[i - 2];
		}else{
	            qb[i] = qb[i - 1] + qb[i - 2] + qb[i - 3];
		}
	}
} 
