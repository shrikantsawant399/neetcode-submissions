class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            if(nums[left] == val){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            }else{
                left++;
            }
        }
        return left;
    }
}