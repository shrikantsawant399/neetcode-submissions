class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        boolean[][] pacific = new boolean[rows][columns];
        boolean[][] atlantic = new boolean[rows][columns];

        for(int col = 0; col < columns; col++){
            explore(heights, 0, col, pacific);
        }

        for(int row = 0; row < rows; row++){
            explore(heights, row, 0, pacific);
        }

        for(int col = 0; col < columns; col++){
            explore(heights, rows-1, col, atlantic);
        }

        for(int row = 0; row < rows; row++){
            explore(heights, row, columns-1, atlantic);
        }

        List<List<Integer>> results = new ArrayList<>();

        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                if(pacific[row][column] && atlantic[row][column]){
                    results.add(new ArrayList<>(List.of(row, column)));
                }
            }
        }

        return results;
    }

    private void explore(int[][] heights, int row, int column, boolean[][] reachable){
        if(reachable[row][column]) return;

        reachable[row][column] = true;

        if(row+1 < heights.length && heights[row+1][column] >= heights[row][column]){
            explore(heights, row+1, column, reachable);
        }

        if(0 <= row-1 && heights[row-1][column] >= heights[row][column]){
            explore(heights, row-1, column, reachable);
        }
        
        if(column+1 < heights[0].length && heights[row][column+1] >= heights[row][column]){
            explore(heights, row, column+1, reachable);
        }

        if(0 <= column-1 && heights[row][column-1] >= heights[row][column]){
            explore(heights, row, column-1, reachable);
        }
    }
}
