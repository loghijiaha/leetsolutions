class Solution {
    Set<Integer> vow = Set.of(0,4,8,14,20);
    public int maxVowels(String s, int k) {
        int max = 0;

        for(int i =0; i<k ;i++){
            max+= isVow(s.charAt(i)) ? 1 : 0;
        }
        int tmp = max;
        for(int i=0; i< s.length()-k;i++){
            tmp += isVow(s.charAt(i+k)) ? 1 : 0;
            tmp -= isVow(s.charAt(i)) ? 1 : 0;
            max = Math.max(max, tmp);
        }
        return max;
    }

    boolean isVow(char i){
        return vow.contains(i-'a');
    }
}