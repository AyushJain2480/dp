// har point se check karege kitna bada square bana sakte he 
// tabulation dp arr banao arr size ka
// last row or last col me max 1 size ka square bna skte he kyuki last row me niche ni extend krskte
// or last col me aage ni extend karskte 
// direction choti  se badi ki taraf sabse chota square last col me bnega max 1 size ka 
// or possibly first me max square bnskta he bnega we dont know 
// hume tin direction me dekhna pdega square ka size bda krne k lie vertical horizontal and diagonal 
// agar tino ek sath same distance se bdege to hi square bnega to tino ka min nikalna he 
// or 1 add krna he agar 0 he arr me to 0 hi dalo dp me because no square can be formed from that point 
// but if there 1 is present than there are chances of increase the size of the square so check in all the 
// 3 directions take min add + 1 and find max of all the dp[i][j] at last for finding area take the max * max 
// and return it.
class Solution {
    public int maximalSquare(char[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int[][] dp = new int[r][c];
        int max = 0;
        
        for(int i = r - 1; i >= 0; i--){
            for(int j = c - 1; j >= 0; j--){
                if(i == r - 1 || j == c - 1){
                    if(arr[i][j] == '0'){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = 1;
                    }
                }
                else{
                    if(arr[i][j] == '0'){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i][j + 1] , dp[i + 1][j]),dp[i + 1][j + 1]) + 1;  
                    }
                }
                 max = Math.max(max , dp[i][j]); 
            }
        }
        return max * max;
    }
}
