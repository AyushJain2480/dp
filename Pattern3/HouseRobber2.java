// same as house robber 1 but with slight difference  - house robber2 
// All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one
// so if we rob 1st house than last house mt rob kro , agar last kra to 1st mt kro dono ka max nikaldo khtm
public class Main
{
	public static void main(String[] args) {
	    int[] nums = {5,10,10,100,5,6};
		int takeFirstAvoidLastNeigh =  rob(nums , 0 , nums.length - 2);
        int takeLastAvoidFirstNeigh = rob(nums , 1 , nums.length - 1);
        System.out.println(Math.max(takeFirstAvoidLastNeigh , takeLastAvoidFirstNeigh));
	}
    
    public static int rob(int[] nums , int lo , int hi) {
        if(nums.length == 1) return nums[0];
        int inc = 0;
        int exc = 0;
        
        for(int i = lo; i <= hi; i++){
            int ninc = exc + nums[i];
            int nexc = Math.max(inc,exc);
            
            inc = ninc;
            exc = nexc;
        }
        return Math.max(inc,exc);
    } 
}
