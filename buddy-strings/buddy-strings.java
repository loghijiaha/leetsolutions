
class Solution {
    public boolean buddyStrings(String s, String goal) {
        int ns = s.length();
        int ng = goal.length();
        
        if (ns != ng) {
            return false;
        }
        
        if (s.equals(goal)) {
            int[] farr = new int[26];
            for (char ch : s.toCharArray()) {
                farr[ch - 'a']++;
                if (farr[ch - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }
        
        ArrayList<Integer>ans=new ArrayList<>();
        //int count = 0;
        for (int i = 0; i < ns; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
               ans.add(i);
                if (ans.size()> 2) {
                    return false;
                }
            }
        }
        
        return ans.size() == 2 && s.charAt(ans.get(0)) == goal.charAt(ans.get(1)) && s.charAt(ans.get(1)) == goal.charAt(ans.get(0));
    }
}