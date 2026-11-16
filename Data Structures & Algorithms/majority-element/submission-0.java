class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int majorityElement = nums[0];
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i], 1);
            int newCount = map.get(nums[i]) + 1;
            map.put(nums[i], newCount);
        }

        for(int num : map.keySet()){
            int val = map.get(num);
            if(val > n/2 && val > map.get(majorityElement))
                majorityElement = num;

        }
        return majorityElement;
    }
}