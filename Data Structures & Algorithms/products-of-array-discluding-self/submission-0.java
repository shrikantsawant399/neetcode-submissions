class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProduct = new int[n];
        int[] suffProduct = new int[n];
        int[] result = new int[n];

        preProduct[0] = 1;
        for(int i = 1; i < nums.length; i++){
            preProduct[i] = preProduct[i-1] * nums[i-1];
        }

        suffProduct[n-1] = 1;
        for(int i = n-2; i >= 0; i-- ){
            suffProduct[i] = suffProduct[i+1] * nums[i+1];
        }

        for(int i = 0; i < nums.length; i++){
            result[i] = preProduct[i] * suffProduct[i];
        }

        return result;
    }
}  