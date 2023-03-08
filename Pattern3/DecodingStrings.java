// Total ways to decode a string | Count encodings
// very lengthy too many edge cases check notes 
// using tabulation 
// storage int[] dp = new int[s.length()]
// meaning i tak ki string ke kitne tarike he encoding ke 
// i == s.length() - 1 par puri string ke kitne tarike he encoding ke vo store hoga 
// badi problem last me left to right direction hogi 
// har bar i - 2 tak to solve hojayga difference last ke i - 1 and i hi se ayga because 26 yani 2 digit max tak split dekhna he 
// mainly there are 4 cases 
// jab last me i-1 and i pos pe "00" dono zero pde ho 
// ,             ,           pe "0(non0)" zero non zero pde ho 
//                              non0 non0 pde ho 
//                              non0 0 pde ho 

public class Main
{
	public static void main(String[] args) {
	    System.out.println(numDecodings("21123"));
	    
	}
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
	    dp[0] = 1;
	    for(int i = 1; i < dp.length; i++){
	        if(s.charAt(i) != '0'){
	            dp[i] = dp[i - 1];
	            if(s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i - 1, i + 1)) <= 26)
	               dp[i] += (i >= 2 ? dp[i - 2] : 1);
	        }
	        else{
	            if(s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i - 1, i + 1)) <= 26)
	                dp[i] = (i >= 2 ? dp[i - 2] : 1);
	            else
	                dp[i] = 0;
	        }
	    }
	    return dp[s.length() - 1];
    }
}

