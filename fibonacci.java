public class Main
{
	public static void main(String[] args) {
	   // fibonacci(10);
	   int ans =   memoizedfibonacci(10 , new int[11]); // for finding nth fibonacci you need n + 1th size of array to store the elements
	    // that are already calculated it will reduce the number of function calls 
	   System.out.println("ans is" + ans);
	}
	
	public static int fibonacii(int n){
	    if(n == 0 || n == 1){ // base case for stop recursion
	        return n;
	    }
	    System.out.println("funcall" + n);
	    int fibnm1 = fibonacii(n - 1);
	    int fibnm2 = fibonacii(n - 2);
	    int fibn = fibnm1 + fibnm2;
	    return fibn;
	}
	
	// you can also create a qb array as global so you dont need to pass it in the function call 
	public static int memoizedfibonacci(int n , int[] qb){
	    if(n == 0 || n == 1){ // base case for stop recursion
	        return n;
	    }
	    // if it is already present in the array stop calling the function for calculating it again
	    if(qb[n] != 0){
	        return qb[n];
	    }
	    System.out.println("funcall" + n);
	    int fibnm1 = memoizedfibonacci(n - 1 , qb);
	    int fibnm2 = memoizedfibonacci(n - 2 , qb);
	    int fibn = fibnm1 + fibnm2;
	    // before returing the fibn store it in the array so that when we come at this again we dont need to calculate it again
	    qb[n] = fibn;
	    return fibn;
	}
}
