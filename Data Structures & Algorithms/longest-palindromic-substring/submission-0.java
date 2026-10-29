class Solution {
    public String longestPalindrome(String s) {
        int bestStart = 0;
        int maxLength = 1;
        for(int i = 0; i < s.length(); i++){
            Palindrome oddLength = expandAroundCenter(s, i, i);
            Palindrome evenLength = expandAroundCenter(s, i, i+1);

            if(oddLength.length > maxLength){
                bestStart = oddLength.start;
                maxLength = oddLength.length;
            }

            if(evenLength.length > maxLength){
                bestStart = evenLength.start;
                maxLength = evenLength.length;
            }
        }
        return s.substring(bestStart, bestStart + maxLength);
    }

    private Palindrome expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return new Palindrome(left + 1, right - left - 1);
    }

    class Palindrome{
        int start;
        int length;

        public Palindrome(int start, int length){
            this.start = start;
            this.length = length;
        }
    }
}


