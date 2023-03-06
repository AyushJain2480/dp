// Coin change combinations
// coins array = [2,3,5]
// 2 , 3, 5 har coins infinite he aapko btana he in coins ko use karke ap 7 coins kitne tariko se chuka skte he
// combinations = 2 honge {2,2,3} and {2,5}
// permutations = 5 honge {2,2,3} , {2,3,2} , {3,2,3} ,{2,5} , {5,2}
// hume combinations btane he kitne bnskte permutations nhi 
// using tabulation
// storage and meaning 7 is the amt so dp array banao 7 + 1 ki means amt + 1
// int[] dp = new int[amt + 1];
// indexes -> 0 1 2 3 4 5 6 7
// 5 par kya bharoge ? mtlb 2,3,5 ko use krke 5 pay krne ke kitne tarike he 
// 7 par kya hoga result mtlb 2,3,5 ko use krke 7 pay krne ke kitne tarike he 
// choti problem 0 par hogi mtlb 2,3,5 ko use krke 0 pay krne ke kitne tarike he ek hi he ki kuch na lena na dena 
// its little weird but it just like that 2^0 is 1
// so dp[0] = 1
// pehle coins ka loop lagayge pehle 2 ka fir 3 ka fir 5 ka jisse combinations me pehle 2 hi ayga uske bad 3 fir 5 
// mtlb combinations hi milege permutations nhi 
// pehle  2 ka loop lgega fir dp array me j = 2 se hi bharna start krege dp[j] += dp[j - arr[0]]
// fir 3 ke lie loop lgaege fir dp array me j = 3 se bharna start krege dp[j] += dp[j - arr[1]]
// fir 5 ke lie loop lgaege fir dp array me j = 5 se bharna start krege dp[j] += dp[j - arr[2]]
// pehla loop chl rha he yha i = 0 to i = 2 tak 
// phle 2 ke lie dp array bhar rhe he usse kya bnega ki 2 coin ko use krke kitne combinations bnskte he 
// fir 3 se bharege fir kya banega ki 2 ,3 ko use krke kitne combinations bnege 
// finally 5 ke lie bharege usse bnega ki 2,3,5 ko use krke kitne combinations banege 
public class Main
{
	public static void main(String[] args) {
		int[] coins = {2,3,5};
		int amt = 7;
		System.out.println(coinCombinations(coins,amt));
	}
	
	public static int coinCombinations(int[] coins , int amt){
	    int[] dp = new int[amt + 1];
	    dp[0] = 1;
	    for(int i = 0; i < coins.length; i++){
	        for(int j = coins[i]; j < dp.length; j++){
	            dp[j] += dp[j - coins[i]];
	        }
	    }
	    return dp[amt];
	}
}
