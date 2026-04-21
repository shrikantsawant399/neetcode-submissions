class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1); 
            }else{
                map.put(nums[i], 1);
            }
        }

        int[] result = map.entrySet()
                  .stream()
                  .sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed())
                  .limit(k)
                  .mapToInt(Map.Entry::getKey)
                  .toArray();
        return result;          
    }
}
