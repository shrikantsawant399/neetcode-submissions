class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        int islandCount = 0;
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == '1' && !isVisited[row][column]){
                    queue.add(new int[]{row, column});
                    isVisited[row][column] = true;
                    exploreIsland(queue, grid, isVisited);
                    islandCount++;
                }
            }
        }

        return islandCount; 
    }

    public void exploreIsland(Queue<int[]> queue, char[][] grid, boolean[][] isVisited){
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int row = pos[0];
            int column = pos[1];

            if(row+1 < grid.length && grid[row+1][column] == '1' && !isVisited[row+1][column]){
                queue.add(new int[]{row+1, column});
                isVisited[row+1][column] = true;
            }

            if(0 <= row-1 && grid[row-1][column] == '1' && !isVisited[row-1][column]){
                queue.add(new int[]{row-1, column});
                isVisited[row-1][column] = true;
            }

            if(column+1 < grid[0].length && grid[row][column+1] == '1' && !isVisited[row][column+1]){
                queue.add(new int[]{row, column+1});
                isVisited[row][column+1] = true;
            }

            if(0 <= column-1 && grid[row][column-1] == '1' && !isVisited[row][column-1]){
                queue.add(new int[]{row, column-1});
                isVisited[row][column-1] = true;
            }

        }
    }
}
