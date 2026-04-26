class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        int left;
        int right;
        int target = 0;

        for(int i = 0; i <= nums.length-3; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            left = i + 1;
            right = nums.length - 1;
            target = nums[i] * -1;
            while(left < right){
                if(target == (nums[left] + nums[right])){
                    list.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    left++; right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                } else if(target > (nums[left] + nums[right])) { 
                    left++; 
                } else {
                    right--;
                }
            }
        }

        return list;
    }
}
