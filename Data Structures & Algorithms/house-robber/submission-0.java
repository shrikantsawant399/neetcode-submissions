class Solution {
    public int rob(int[] nums) {
        return robHouse(0, nums, new HashMap<>());
    }

    public int robHouse(int i, int[] nums, Map<Integer, Integer> memo){
        if(memo.containsKey(i)) return memo.get(i);
        if (i >= nums.length) return 0;

        int money = Math.max(robHouse(i+1, nums, memo), nums[i] + robHouse(i+2, nums, memo));
        memo.put(i, money);

        return money;
    }
}
