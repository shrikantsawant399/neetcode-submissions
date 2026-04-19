class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> setOfUniqueNumbers = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            setOfUniqueNumbers.add(nums[i]);
        }

        return (setOfUniqueNumbers.size() < nums.length) ? true : false;
    }
}