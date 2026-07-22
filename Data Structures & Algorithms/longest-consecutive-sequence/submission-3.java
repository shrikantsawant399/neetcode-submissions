class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int maxCount = 1;
        int count = 1;

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        for(int num : nums){
            if(set.contains(num - 1))
                continue;
            int counter = 1;    
            while(set.contains(num+counter)){
                count++;
                counter++;
            }
            counter = 1;
            if(maxCount < count) maxCount = count;
            count = 1;  
        }
        return maxCount;
    }
}
