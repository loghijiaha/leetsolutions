class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        return wordbreak(s, 0, set, new Boolean[s.length()]);
    }
    
    private boolean wordbreak(String s, int i, HashSet<String> set, Boolean[] memo) {
        if (i == s.length()) return true;
        
        if (memo[i] != null) {
            return memo[i];
        }
        
        for (int j = i+1; j <= s.length(); j++) {
            String sub = s.substring(i, j);
            if (set.contains(sub) && wordbreak(s, j, set, memo)) {
                memo[i] = true;
                return true;
            }
        }
        memo[i] = false;
        return false;
    }
}