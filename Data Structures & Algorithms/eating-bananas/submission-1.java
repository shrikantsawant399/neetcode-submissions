class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        for(int pile: piles){
            maxSpeed = Math.max(maxSpeed, pile);
        }
        double hoursTaken = 0;
        int ans = 0;

        while(minSpeed <= maxSpeed){
            int mid = minSpeed + (maxSpeed - minSpeed)/2;
            for(int pile: piles){
                hoursTaken += Math.ceil((double) pile/mid);
            }
            
            if(hoursTaken <= (double)h){
                ans = mid;
                maxSpeed = mid - 1;
            }else{
                minSpeed = mid + 1;
            }
            hoursTaken = 0;
        }

        return ans;
    }
}
