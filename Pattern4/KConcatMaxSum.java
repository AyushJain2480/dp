class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int[] newArr = new int[2 * arr.length];
        int i = 0;
        boolean allNegative = true;
        for (; i < arr.length; i++) {
            if(arr[i] > 0) allNegative = false;
            newArr[i] = arr[i];
        }
        for (; i < newArr.length; i++) {
            newArr[i] = arr[i - arr.length];
        }

        if(allNegative == true){
            return 0;
        }
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        if (k == 1) {
            return (int)(maxSubArray(arr) % 1000000007);
        } else if (sum <= 0) {
            return (int)(maxSubArray(newArr) % 1000000007);
        } else {
            return (int)((maxSubArray(newArr) + ((k - 2) * sum)) % 1000000007);
        }
    }
    
    public long maxSubArray(int[] arr) {
        long maxSoFar = arr[0];
        long maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
