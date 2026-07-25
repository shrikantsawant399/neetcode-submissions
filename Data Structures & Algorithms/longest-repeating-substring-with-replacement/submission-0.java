class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxFrequency = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int window = 0;
        
        while(right < s.length()){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(c));
            while(right - left + 1 - maxFrequency > k){
                c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                left++;
            }
            window = Math.max(window, right - left + 1);
            right++;
        }

        return window;
        
    }
}
