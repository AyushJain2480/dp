// Jis current stone par khade ho vha se dekho ki kis stone par pohcha jaskta he 
// jis ke upar pohcha ja skta he unke samne update kr aao ki itne jump leke tumhare 
// pas pohch skte he let say k jump leke vha pohch skte to vha jake set me 
// k , k + 1 , k - 1 add krdo ki ye valid jumps he tumhare lie 
// agar ye krte krte last stone pohch jao to true return krdo 
class Solution {
    public boolean canCross(int[] stones) {
        
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        
        for(int stone : stones){
            map.put(stone , new HashSet<Integer>());
        }
        
        map.get(0).add(1);
    
        for(int i = 0; i < stones.length; i++){           
            Set<Integer> jumps = map.get(stones[i]);
            for(int jmp : jumps){
                if(stones[i] + jmp == stones[stones.length - 1]){
                    return true;
                }
                if(map.containsKey(stones[i] + jmp)){
                    if(jmp - 1 > 0){
                        map.get(stones[i] + jmp).add(jmp - 1);   
                    }
                    map.get(stones[i] + jmp).add(jmp);
                    map.get(stones[i] + jmp).add(jmp + 1);
                }
            }
            
        }
       return false;
    }
} 
