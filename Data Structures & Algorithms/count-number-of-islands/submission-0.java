class Solution {
    public int numIslands(char[][] grid) {
       Set<String> isVisited = new HashSet<>();
        int islandCount = 0;
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(exploreIslandsByDFSUsingRecursion(grid, row, column, isVisited)) islandCount += 1;
            }
        }
        return islandCount; 
    }

    public boolean exploreIslandsByDFSUsingRecursion(char[][] grid, int row, int column, Set<String> isVisited){
        boolean rowInbounds = 0 <= row && row < grid.length;
        boolean columnInbounds = 0 <= column && column < grid[0].length;
        if(!rowInbounds || !columnInbounds) return false;

        if(grid[row][column] == '0') return false;
        String pos = row + "," + column;
        if(isVisited.contains(pos)) return false;
        isVisited.add(pos);

        exploreIslandsByDFSUsingRecursion(grid, row + 1, column, isVisited);
        exploreIslandsByDFSUsingRecursion(grid, row - 1, column, isVisited);
        exploreIslandsByDFSUsingRecursion(grid, row, column + 1, isVisited);
        exploreIslandsByDFSUsingRecursion(grid, row, column - 1, isVisited);
        return true;
    }
}
