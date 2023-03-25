// count of AP SS (>= 3)
// 1] Hashmapon ka array bnao
// 2] cd vs count of AP ss ending at that point (>=2)
// 3] (>=2) map me rkhege && (>=3) ans me add krte jayge
// 4] -2^31   2^31 - 1 (inka cd = 2.2^31 - 1)
//     cd agar Integer ki range ke bahar ja rha he agar to skip kro use
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        
        HashMap<Integer,Integer> maps[] = new HashMap[nums.length];
        
        // initialize all the hashmaps because by default all the hashmaps are null
        for(int i = 0; i < nums.length; i++){
            maps[i] = new HashMap<>();
        }
        
        for(int i = 1; i < maps.length; i++){
            for(int j = 0; j < i; j++){
              
                long cd = (long)nums[i] - (long)nums[j];
              
                if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE){
                    continue;
                }
                
                // check kro kya vo cd vha j ke map me phle se pda he agar ha to uski value lelo 
                // ni to 0 lelo
                
                int apsEndingOnJ = maps[j].getOrDefault((int)cd,0);
                
                int apsEndingOnI = maps[i].getOrDefault((int)cd,0);
                
                ans += apsEndingOnJ; // ans me to j hi vala ayga (same yha agar J par nhi hogi same cd to 0 lelega)
                // vese to j + 1 bharte map i me pr agar i me phle se pda ho to vo bhi add krna pdega j + i + 1
                
                // see agar I par nhi hogi to 0 lelega 
                maps[i].put((int)cd , apsEndingOnJ + apsEndingOnI + 1);
            }
        }
        return ans;
    }
}
