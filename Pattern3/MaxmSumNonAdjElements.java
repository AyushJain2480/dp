// Maximum Sum Non Adjacent Elements | Greedy Approach
// 5, 10, 10, 100, 5, 6
// pattern 3 is inclusion/ exclusion 
// Total subsets hoge 2 ^ 6 Adjacent nhi choose krne he ab inme se jo subsets bache unme se maxm sum vala jo subset he vhi maxm sum return krna he
// 1st approach he ki subsets nikal lo unme se dekhte betho 
// ya ye bhi mat kro agar pichli bar yes kha tha to is bar no kehna he (no Adjacent)
// pichli bar no kha tha to is bar yes bhi kehdo ya is bar no bhi kehdo Adjacent to nhi honge na 
// see pehli approach 2D table array se hogi fir space optimise krege using variables only 
// ek or bat ye recursive se bhi hojaygi problm fir memoize bhi karskte 

// let see using 2D dp array 
// storage and meaning 
// 0   1    2
// 5 - 10 - 10 subsets (not Adjacent) ending at 10 unme sabse jyda sum kya he vo yha store hoga dp[0][2] me (10 lena he)
// 5 - 10 - 10 subsets (not Adjacent) not ending at 10 unme se sabse jyada sum kya he vo yha store hoga dp[1][2] (10 ni lena he)
// inc means 10 ko lena hi hoga exc means 10 ko le hi ni sakte 

// overall analysis of this problem (For tree structure or tble check notes)

// greedy ka base 
// greedy me aksar ap kuch raste explore nahi karte he to vo kuch raste kyu na explore kare ye uski reasoning he 
// Is bar vala Include karna chahte ho purane exclude pe hi hoskta he
// Is bar exclude karna chahte ho purane exclude par bhi hoskta he purane inc par bhi 
// dono me se rkhe kis ko --> jo behtar he kyuki dono ka future same he to jiska present better he use rkho 

// question same he house robber 1 jesa usme bhi Adjacent nhi lut skte ghar or fir jin tarike se lut skte unme maxm profit batana he

public class Main
{
	public static void main(String[] args) {
	    int[] nums = {5,10,10,100,5,6};
		System.out.println(maxmNonAdjProfit(nums));
	}
	
	public static int maxmNonAdjProfit(int[] nums){
	    int inc = 0;
	    int exc = 0;
	    
	    for(int i = 0; i < nums.length; i++){
	        int ninc = exc + nums[i];
	        int nexc = Math.max(exc,inc);
	        
	        inc = ninc;
	        exc = nexc;
	    }
	    return Math.max(inc,exc);
	}
}
