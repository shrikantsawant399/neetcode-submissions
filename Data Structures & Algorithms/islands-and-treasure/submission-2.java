class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Set<String> isVisited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == 0){
                    queue.add(row + "," + column);
                    isVisited.add(row + "," + column);
                }
            }
        }

        while(!queue.isEmpty()){
            String pos = queue.poll();
            int row = Integer.parseInt(pos.split(",")[0]);
            int column = Integer.parseInt(pos.split(",")[1]);
            int value = grid[row][column];

            pos = (row+1) + "," + column;
            if(row + 1 < grid.length && grid[row + 1][column] != -1 && !isVisited.contains(pos)){
                grid[row+1][column] = value + 1;
                queue.add(pos);
                isVisited.add(pos);
            }

            pos = (row-1) + "," + column;
            if(0 <= row - 1 && grid[row - 1][column] != -1 && !isVisited.contains(pos)){
                grid[row-1][column] = value + 1;
                queue.add(pos);
                isVisited.add(pos);
            }
                
            pos = row + "," + (column+1);
            if(column + 1 < grid[0].length && grid[row][column + 1] != -1 && !isVisited.contains(pos)){
                grid[row][column+1] = value + 1;
                queue.add(pos);
                isVisited.add(pos);
            }

            pos = row + "," + (column-1);
            if(0 <= column - 1 && grid[row][column - 1] != -1 && !isVisited.contains(pos)){
                grid[row][column-1] = value + 1;
                queue.add(pos);
                isVisited.add(pos);
            }

        }
    }
}
