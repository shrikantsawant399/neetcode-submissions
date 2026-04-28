class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target)
                return 0;
            return -1;    
        }
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right)/2;
        while(left != mid || right != mid){
            if(target == nums[mid])
                return mid;
            if(target == nums[left])
                return left;
            if(target == nums[right])
                return right;
            if(mid > target){
                right = mid - 1;
                mid = (left + right)/2;
            }else{
                left = mid + 1;
                mid = (left + right)/2;
            }
        }
        return -1;
    }
}
