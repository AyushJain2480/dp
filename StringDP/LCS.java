class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    
    public int longestCommonSubsequence(String s1, String s2) {
        return lcs(s1, s2, 0, 0);
    }
    
    private int lcs(String s1, String s2, int i, int j) {
        if(i == s1.length() || j == s2.length()) {
            return 0;
        }
        String key = i + "," + j;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int result;
        if(s1.charAt(i) == s2.charAt(j)) {
            result = 1 + lcs(s1, s2, i+1, j+1);
        } else {
            int val1 = lcs(s1, s2, i+1, j);
            int val2 = lcs(s1, s2, i, j+1);
            result = Math.max(val1, val2);
        }
        map.put(key, result);
        return result;
    }
}
