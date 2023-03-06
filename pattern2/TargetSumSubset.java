// Target Sum subsets Dynammic Programming
// subsets continuous nhi hote like subarrays 
// n distinct numbers in an array has 2^n subsets 
// [4,2] has 2^2 = 4 subsets [4],[2],[4,2],[] --> Note empty subset is a part of each subset 
// using tabulation
// 1] storage and meaning 
// if given array is [4,2,7,1,3] and target is 10
// we have to find if there is any subset whose sum is equal to 10 if yes return true else false
// int n = arr.length no of rows n + 1 hogi or no of colns = target + 1
// Har element ke pas 2 choices hogi ki vo subset me ay ya nhi aye

// cricket analogy se samjte he 
// ya to player khel payga ya nahi agar khelega to bache run pehle vale players bana payga dekhega agar vo bna payge 
// to true hojayga ki ha possible he ki vo player khelega or bache run pichle vale bna hi lenge 
// dusra case ki vo player ni khelega is case me sare runs pehle vale players ko banane pdege agar vo bna lenge to true hoga 
// in dono case me se koi bhi true hojay agar to true hojyga mtlb agar player khelega or bache runs pehle vale players bana lenge 
// to vhi se pta chl gya na ki target runs ban jayge aagar ye case false hojata he to player khege ki ok ek kam karte me m nhi khelta 
// hu kya tum sare runs bna loge is case me agar true hojay to bhi bdia agar dono false he mtlb ki vo player khega pehle vale sare 
// players se ki sb nikamme he hum sb target nhi bna skte choro.

// 0th col pura true hoga 0 subsets sbme rehta he
// 0th row me 0th col ko chorke sab false honge kyuki 0 se 0 bnskta he baki nhi 
// or baki rest of the array me j < val (val = arr[i - 1]) tak upar vala rhega mtlb player nhi khela 
// baki players khel pay to true nhi to false j >= val me player khela to dp[i - 1][j - val] val piche bache run bna payge vo check kro


public class Main
{
	public static void main(String[] args) {
		int[] arr = {4,2,7,1,3,3};
	    
	  for (int i = 0; i <= 50; i++) {
      int target = i;
      boolean ans = sumSubsets(arr, target);
      System.out.println(ans ? "yes" : "no");
    } 
	}
	public static boolean sumSubsets(int[] arr , int target){
	    int n = arr.length;
	    boolean[][] dp = new boolean[n + 1][target + 1];
	    
	    for(int i = 0; i < dp.length; i++){
	        for(int j = 0; j < dp[0].length; j++){
	            if(i == 0 && j == 0){
	                dp[i][j] = true;
	            }
	            else if(i == 0){
	                dp[i][j] = false;
	            }
	            else if(j == 0){
	                dp[i][j] = true;
	            }
	            else{
	                int val = arr[i - 1];
	                if(j < val){
	                    dp[i][j] = dp[i - 1][j];
	                }else{
	                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - val] ? true : false);
	                }
	            }
	        }
	    }
	    return dp[n][target];
	}
}
