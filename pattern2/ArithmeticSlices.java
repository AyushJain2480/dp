// I think this is O(n2) and will give TLE for large inputs
// 1 <= nums.length <= 5000
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
             int diff = nums[i + 1] - nums[i];
             for(int j = i + 2; j < nums.length; j++){
                if(nums[j] - nums[j - 1] == diff){
                    count++;
                }else{
                    break;
                }
             }
        }
        return count;
    }
}

// 1 <= N <= 10^8
// meaning -> us element par khtm hone wali kitni subarrays AP he 
// 2 5 9 12 15 
// [   *       ]
// 9 par khtm hone wale kitne subarrays AP he
// 12 par khtm hone wale kitne subarrays AP he
// agar last ke 3 AP bnare he to 1 increase hoga agar nhi to 0 kyuki last ke 3 hi AP ni bnare baki kya hi dekhe
// har number p khtm hone wali sari APs kitni he vo sab ka sum krke mil jayga so the ans is summation of all the values in the array

 public int numberOfArithmeticSlices(int[] nums) {
     int ans = 0;
     int[] dp = new int[nums.length];
     // start ke 2 me 0 kyuki 3 length min honi chahiye check krne k lie hi
     for(int i = 2; i < nums.length; i++){
         if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
             dp[i] = dp[i - 1] + 1; // (i - 1 me purani vali increase hojaygi or 3 length wali ke lie + 1)
             ans += dp[i];
         }
     }
    return ans;
 }
