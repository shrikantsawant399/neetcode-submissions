class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int maxProfit = 0;
        int left = 0;
        int right = 1;

        while(left < prices.length - 1){
            if(prices[left] < prices[right]){
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            }
            if(right == (prices.length - 1)){
                ++left;
                right = left+1;
            }else{
                right++;
            }

        }
        return maxProfit;
    }
}
