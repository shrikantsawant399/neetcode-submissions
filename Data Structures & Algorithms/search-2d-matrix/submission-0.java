class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = 0;
        int columnSize = matrix[0].length;
        int low = 0;
        int high = (matrix.length * columnSize) - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            row = mid / columnSize;
            column = mid % columnSize;

            if(target == matrix[row][column]){
                return true;
            }else if(target > matrix[row][column]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return false;

    }
}
