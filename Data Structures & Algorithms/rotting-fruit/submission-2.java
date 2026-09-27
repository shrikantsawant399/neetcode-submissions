class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int freshFruites = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == 2){
                    int[] pos = new int[]{row, column};
                    queue.add(pos);
                }
                if(grid[row][column] == 1) freshFruites++;
            }
        }

        if(freshFruites == 0) return 0;

        while(!queue.isEmpty() && freshFruites > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();
                int row = pos[0];
                int column = pos[1];
                if(row+1 < grid.length && grid[row+1][column] == 1){
                    pos = new int[]{row+1, column};
                    queue.add(pos);
                    grid[row+1][column] = 2;
                    freshFruites--;
                }

                if(0 <= row-1 && grid[row-1][column] == 1){
                    pos = new int[]{row-1, column};
                    queue.add(pos);
                    grid[row-1][column] = 2;
                    freshFruites--;
                }

                if(column+1 < grid[0].length && grid[row][column+1] == 1){
                    pos = new int[]{row, column+1};
                    queue.add(pos);
                    grid[row][column+1] = 2;
                    freshFruites--;
                }

                if(0 <= column-1 && grid[row][column-1] == 1){
                    pos = new int[]{row, column-1};
                    queue.add(pos);
                    grid[row][column-1] = 2;
                    freshFruites--;
                }
            }

            minutes++;
        }
        return freshFruites > 0 ? -1 : minutes;
    }
}
