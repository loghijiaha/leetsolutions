class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> mp = List.of("", "", "abc", "def","ghi","jkl","mno", "pqrs", "tuv", "wxyz");
    
        List<String> ans = new ArrayList<>();

        dfs(0, mp, digits, "", ans);

        return ans;

    }

    void dfs(int i, List<String> mp ,String dig, String tmp , List<String> ans){

        if( i  == dig.length()){
            if(!tmp.isEmpty()) ans.add(tmp);
            return;
        }

        for(char c : mp.get(dig.charAt(i)-'0').toCharArray()){
            dfs(i+1, mp, dig, new String(tmp + c), ans);
        }
    }
}