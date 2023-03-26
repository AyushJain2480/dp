// taking x = 2 and y = 3
// dp1[i] = Maxm sum of x sized subarray till ith index
// storing 2 length maxm subarray sum till ith index
// fill dp1 from left to right

// dp2[i] = Maxm sum of y sized subarray form ith index to last index
// storing 3 length maxm subarray sum from ith index to last
// fill dp2 from right to left

// case 1
// x size subarray (in left) | y size subarray (in right) - ans1

//                 i
//         0   1   2      3  4   5   6   7   8
// nums = [3 , 8 , 1   |, 3, 2 , 1 , 8 , 9 , 0] x = 2 , y = 3
// dp1  = [3 ,11 ,[11] |,11, 11, 11, 11, 17,17]
// dp2  = [18,18 ,18   |,[18],18,18, 17, 9 , 0]

// at index 2 in dp1 - (stored maxm x sized subarrsum possible till index2) i.e 11 how ? check in nums till index 2 
// there is only one x(2) size subarray [3,8] and its sum is 11.

//  at index 3 in dp2 - (stored maxm y sized subarrsum possible from index 3 to last) i.e 18 how ? check in nums from index 3 
//  there is one maxm y(3) size subarray [1,8,9] and its sum is 18.

// I hope m able to show you the non overlapping arrays [3, 8] and [1,8,9] sum of both the arrays are 29
// so just like this we will move our i and find the x size subarr in the left part and y size right subarr in the right part 
// cal sum of all the non overlapping subarrays but don't forget to consider the second case below in which you have to take 
// y size subarr in the left side and x size subarr in the right side and at last return the maxSum.


// case 2 
// y size subarray (in left) | x size subarray (in right) - ans2

// final ans -> max(ans1 , ans2)

// Upvote if You find this helpful :)


class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int x, int y) {
        return Math.max(solution(nums,x,y) , solution(nums,y,x));
    }
    
    public int solution(int[] nums ,int x , int y){
         int n = nums.length;

        // Compute dp1 array
        int[] dp1 = new int[n];
        int currxsubarrsum = 0;
        
        for (int i = 0; i < n; i++) {
            if(i < x){
                currxsubarrsum += nums[i];
                dp1[i] = currxsubarrsum;
            }else{
                // [[i-x]       ][i]---> maintain x size window while moving forward
                // add ith element and remove (i - x)th element from the window
                currxsubarrsum += nums[i] - nums[i - x];
                dp1[i] = Math.max(dp1[i - 1] , currxsubarrsum);
            }
        }

        // Compute dp2 array
        int[] dp2 = new int[n];
        int currysubarrsum = 0;
        
        for (int i = n - 1; i >= 0; i--) {
           if(i >= n - y){
               currysubarrsum += nums[i];
               dp2[i] = currysubarrsum;
           }else{
               // maintain y size window while moving backward <----[i][        [i+y]]
               // add ith element and remove (i + y)th element from the window
               currysubarrsum += nums[i] - nums[i + y];
               dp2[i] = Math.max(dp2[i + 1] , currysubarrsum);
           }
        }

        // Compute the maximum sum of non-overlapping subarrays
        int maxSum = 0;
        for (int i = x - 1; i < n - y; i++) {
            maxSum = Math.max(maxSum, dp1[i] + dp2[i + 1]);
        }
        return maxSum;
    }
}
