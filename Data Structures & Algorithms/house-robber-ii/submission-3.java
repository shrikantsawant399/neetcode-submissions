class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robHouseCir(1, nums, nums.length - 1, new HashMap<>()), robHouseCir(0, nums, nums.length - 2, new HashMap<>()));
    }

    public int robHouseCir(int i, int[] nums, int end, Map<Integer, Integer> memo){
        if(i > end) return 0;
        if(memo.containsKey(i)) return memo.get(i);

        int money = Math.max(robHouseCir(i+1, nums, end, memo), nums[i] + robHouseCir(i+2, nums, end, memo));
        memo.put(i, money);
        return money;
    }
}
