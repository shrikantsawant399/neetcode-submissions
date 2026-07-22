class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int maxCount = 1;
        int count = 1;

        for(int num : nums){
            set.add(num);
        }
        
        for(int num : set){
            if(set.contains(num - 1))
                continue;
            int counter = 1;    
            while(set.contains(num+counter)){
                count++;
                counter++;
            }
            counter = 1;
            maxCount = Math.max(count, maxCount);
            count = 1;  
        }
        return maxCount;
    }
}
