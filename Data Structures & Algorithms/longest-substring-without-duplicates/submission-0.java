class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int left = 0;
        int right = 1;
        int longestSubstring = 1;
        
        while(right < s.length()){
            if(s.substring(left, right).contains(String.valueOf(s.charAt(right)))){
                left++;
            }else{
                longestSubstring = Math.max(longestSubstring, right - left + 1);
                right++;
            };
        }

        return longestSubstring;
        
    }
}
