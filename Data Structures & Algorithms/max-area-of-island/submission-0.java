class Solution {
   public int maxAreaOfIsland(int[][] grid) {
       int maxArea = 0;
       Set<String> isVisited = new HashSet<>();
       for(int row = 0; row < grid.length; row++){
           for(int column = 0; column < grid[0].length; column++){
               maxArea = Math.max(explore(grid, row, column, isVisited), maxArea);
           }
       }
       return maxArea;
   }


   public int explore(int[][] grid, int row, int column, Set<String> isVisited){
      boolean rowBounds = 0 <= row && row < grid.length;
      boolean columnBounds = 0 <= column && column < grid[0].length;
      if(!rowBounds || !columnBounds) return 0;

      if(grid[row][column] == 0) return 0;

      String pos = row + "," + column;
      if(isVisited.contains(pos)) return 0;
      isVisited.add(pos);

      return explore(grid, row + 1, column, isVisited) + explore(grid, row - 1, column, isVisited) + explore(grid, row, column + 1, isVisited) + explore(grid, row, column - 1, isVisited) + 1;
   }
}
