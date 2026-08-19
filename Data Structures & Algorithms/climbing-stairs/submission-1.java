class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return exploreCombinations(n, memo);
    }

    public int exploreCombinations(int n, Map<Integer, Integer> memo){
        if(memo.containsKey(n)) return memo.get(n);
        if(n == 0) return 1;
        if(n < 0) return 0;

        memo.put(n, exploreCombinations(n-1, memo) + exploreCombinations(n-2, memo));
        return memo.get(n);
    }
}
