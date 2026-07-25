class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int left = 0;
        int window = s1.length();
        int right = left + window - 1;
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26]; 

        for(int i = 0; i < window; i++){
            s1Arr[s1.charAt(i) - 'a'] = s1Arr[s1.charAt(i) - 'a'] + 1;
            s2Arr[s2.charAt(i) - 'a'] = s2Arr[s2.charAt(i) - 'a'] + 1;
        }
        if(Arrays.equals(s1Arr, s2Arr)){
            return true;
        }

        while(right < s2.length() - 1){
            right++;
            s2Arr[s2.charAt(right) - 'a'] = s2Arr[s2.charAt(right) - 'a'] + 1;
            s2Arr[s2.charAt(left) - 'a'] = s2Arr[s2.charAt(left) - 'a'] - 1;
            left++;
            if(Arrays.equals(s1Arr, s2Arr)){
                return true;
            }
        }
        return false;
    }
}
