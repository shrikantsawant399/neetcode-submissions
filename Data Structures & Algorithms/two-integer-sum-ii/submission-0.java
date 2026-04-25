class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        for(int i = 0; i < numbers.length; i++){
            if(left == right) break;
            int sum = numbers[left] + numbers[right];
            if(sum == target)
                return new int[] {left+1, right+1};
            if(sum < target) left++;
            if(sum > target) right--;    
        }
         return new int[] {};
    }
}
