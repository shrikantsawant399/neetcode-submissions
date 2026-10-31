class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            result = getPalindromeSubstringCount(s, i, i, result);
            result = getPalindromeSubstringCount(s, i, i+1, result);
        }
        return result;
    }

    private int getPalindromeSubstringCount(String s, int left, int right, int result){
        while(left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            result++;
        }
        return result;
    }
}
