class Solution {
    public int[] maxSumOfThreeSubarrays(int[] arr, int k) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] pSum = new int[n];
        
        for(int i = 0; i < n; i++){
            if(i == 0){
                pSum[i] = arr[i];
            }else{
                pSum[i] = pSum[i - 1] + arr[i];
            }
        }
        
        int currksubarrsum = 0;
        for(int i = 0; i < n; i++){
            if(i < k){
               currksubarrsum += arr[i];
               left[i] = currksubarrsum;
            }else{
               // [[i-k]       ][i] --> add ith remove (i-k)th
               currksubarrsum += arr[i] - arr[i - k];
               left[i] = Math.max(left[i - 1],currksubarrsum);
            }
        }
        
        currksubarrsum = 0;
        for(int i = n - 1; i >= 0; i--){
            if(i >= n - k){
                currksubarrsum += arr[i];
                right[i] = currksubarrsum;
            }else{
                // <---[i][      [i + k]]
                currksubarrsum += arr[i] - arr[i + k];
                right[i] = Math.max(right[i + 1],currksubarrsum);
            }
        }
        
        int maxSum = 0;
        int startPointOFMiddleSubarr = -1;
        int startPointOFLeftSubarr = -1;
        int endPointOFRightSubarr = -1;
        int lmaxsubarrsum = 0;
        int rmaxsubarrsum = 0;
        // starting point of middle subarr varies from k to n - 2k
        for(int i = k; i <= n - 2 * k; i++){
            if(left[i - 1] + right[i + k] + (pSum[i + k - 1] - pSum[i - 1]) > maxSum){
                maxSum = left[i - 1] + right[i + k] + pSum[i + k - 1] - pSum[i - 1];
                lmaxsubarrsum = left[i - 1];
                rmaxsubarrsum = right[i + k];
                startPointOFMiddleSubarr = i; // jha maxm mila hoga sum vha vala i hi start point hoga midle array ka
            }
        }
        
        // we want leftarr starting point 0 se loop chalayge or vo pehla k size ka array jiska sum lmaxsubarrsum ke equal hoga
        
        for(int i = k - 1; i < startPointOFMiddleSubarr; i++){
            if(pSum[i] - (i - k < 0 ? 0 : pSum[i - k]) == lmaxsubarrsum){
                startPointOFLeftSubarr = i - k + 1;
                break;
            }
        }
        
        for(int i = startPointOFMiddleSubarr + (2 * k) - 1; i < n; i++){
            if(pSum[i] - pSum[i - k] == rmaxsubarrsum){
                endPointOFRightSubarr = i - k + 1;
                break;
            }
        }
        System.out.println(maxSum);
        
        int[] ans = new int[3];
        ans[0] = startPointOFLeftSubarr;
        ans[1] = startPointOFMiddleSubarr;
        ans[2] = startPointOFRightSubarr;
        return ans;
    }
}
