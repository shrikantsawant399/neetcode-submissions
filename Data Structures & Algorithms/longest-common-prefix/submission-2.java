class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() <= i) return prefix;
                if(strs[j].charAt(i) != strs[0].charAt(i)) return prefix;
            }
            prefix = prefix + strs[0].charAt(i);
        }
        return prefix;
    }
}