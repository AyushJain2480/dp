class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
// If it is mendatory to sell on ith day than how will you get the maxm profit on that day only?
// <--------(past)--------- ith day(sell)
// simply you will check in the past that on which day the buying price of that share is minm and you came back in the future 
// and sell on that ith day you will get the maxm profit for that day only 
// IF you do this for each and every day you will get the maxm profit possible for that day 
// if you take the max of all these profits you will get the ans of the first Q of stock problem i.e only one transaction allowed
        
// fine but this question is about two transactions right?
// so there are 2 cases 
// the first one is same if on ith day it is mendatory to sell than you will go in the past 
// and find the min cost for buying and came back sell in the future 
// the second is if on ith day it is mendatory to buy than you will go in the future and 
// find the day on which you can sell the stock at maxm price possible and came back in the past
// and buy it
// IN left we are not storing the maxm profit possible on the ith day when you are going in the past instead we are storing the maxm profit possible till that ith day 
// let say on i1 you get 30 on i2 you get 40 on i3 you get 60 so on .. let say you are in i4th day
// so you will store in left array on 4th day what ? the maxFromMP means out of 30 ,40 ,50 and 60 
// and on i4th day also you will check let say it gains 25 on that day as i say till that day 
// so you get maxm 70 store it in left 
// IN the right we are not storing the maxm profit possible on ith day when you are going in the future you are storing the maxmProfit till that day 
// at last you are traversing left and right for ith day calculate sum and find max of all.        
        
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        int maxFromMP = 0;
        for(int i = 0; i < n; i++){
            min = Math.min(min,prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
            maxFromMP = Math.max(maxFromMP , maxProfit);
            left[i] = maxFromMP;
        }
        
        int max = Integer.MIN_VALUE;
        maxProfit = 0;
        maxFromMP = 0;
        for(int i = n - 1; i >= 0; i--){
            max = Math.max(max,prices[i]);
            maxProfit = Math.max(maxProfit , max - prices[i]);
            maxFromMP = Math.max(maxFromMP , maxProfit);
            right[i] = maxFromMP;
        }
        
        int maxSumOFLeftNRight = 0;
        for(int i = 0; i < n; i++){
            maxSumOFLeftNRight = Math.max(maxSumOFLeftNRight, left[i] + right[i]);
        }
        return maxSumOFLeftNRight;
    }
}
