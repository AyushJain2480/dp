// unbounded knapsack 
// yha elements ki duplicacy he kitni bhi bar use karskte ho to 1D array me kam hojayga
// coin change permutation me batana tha kitni permutation he pay krne ki 
// coin change combination me batana tha kitni combination he pay krne ki 
// yha batana he maxm paise kitne banege as far as this question is concerned both combination and permutation
// will give the same result 
// maxm kitne paise bane to permutation ya combination se fark nhi padta par print me pdta he 

public class Main
{
	public static void main(String[] args) {
	      int[] weights = {2,5,1,3,4};
	      int[] values = {15,14,10,45,30};
	      int capacity = 7;
	      System.out.println(unboundedKnapsackUsingPermutations(weights, values, capacity));
	      System.out.println(unboundedKnapsackUsingCombination(weights,values,capacity));
	}
	
	public static int unboundedKnapsackUsingCombination(int[] weights, int[] values, int capacity){
	    int[] dp = new int[capacity + 1];
	    
	    for(int i = 0; i < weights.length; i++){
	        for(int j = weights[i]; j < dp.length; j++){
	            dp[j] = Math.max(dp[j] , dp[j - weights[i]] + values[i]);
	        }
	    }
	    return dp[capacity];
	}
	
	public static int unboundedKnapsackUsingPermutations(int[] weights, int[] values, int capacity){
	    int[] dp = new int[capacity + 1];
	    
	    for(int i = 1; i < dp.length; i++){
	        int max = 0;
	        for(int j = 0; j < weights.length; j++){
	            if(weights[j] <= i){
	                max = Math.max(dp[i - weights[j]] + values[j] , max);
	            }
	        }
	        dp[i] = max;
	    }
	    
	    return dp[capacity];
	}
}
