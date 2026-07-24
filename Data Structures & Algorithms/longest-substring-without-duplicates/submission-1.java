class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int longestSubstring = 1;
        HashMap<Character, Integer> map = new HashMap<>();

        while(right < s.length()){
            char c = s.charAt(right);
            if(map.containsKey(c) && map.get(c) >= left){
                left = map.get(c) + 1;
            }
            map.put(c, right);
            longestSubstring = Math.max(longestSubstring, right - left + 1);
            right++;
        }
        
        

        return longestSubstring;
        
    }
}
