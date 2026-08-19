class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> memo = new HashMap<>();
        return Math.min(exploreCombinations(cost, 0, memo), exploreCombinations(cost, 1, memo));
    }

    public int exploreCombinations(int[] cost, int n, Map<Integer, Integer> memo){
        if(memo.containsKey(n)) return memo.get(n);
        if(n == cost.length - 1) return cost[n];
        if(n > cost.length - 1) return 0;

        int result = cost[n] + Math.min(exploreCombinations(cost, n+1, memo), exploreCombinations(cost, n+2, memo));
        memo.put(n, result);
        return result;
    }
}
