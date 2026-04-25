class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = s.length()-1;

        for(int i = 0; i < s.length(); i++){
            if(left == right)
                break; 
            if(s.charAt(left) != (s.charAt(right)))
                return false;
            left++;
            right--;    
        }

        return true;
    }
}
