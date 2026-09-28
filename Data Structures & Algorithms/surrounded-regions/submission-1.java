class Solution {
    int rows = 0;
    int columns = 0;
    public void solve(char[][] board) {
        rows = board.length;
        columns = board[0].length;
        boolean[][] nonSurroundable = new boolean[rows][columns];
        for(int row = 0; row < rows; row++){
            if(board[row][0] == 'O')
                exploreBoard(board, row, 0, nonSurroundable);
        }

        for(int col = 0; col < columns; col++){
            if(board[0][col] == 'O')
                exploreBoard(board, 0, col, nonSurroundable);
        }

        for(int row = 0; row < rows; row++){
            if(board[row][columns - 1] == 'O')
                exploreBoard(board, row, columns - 1, nonSurroundable);
        }

        for(int col = 0; col < columns; col++){
            if(board[rows - 1][col] == 'O')
                exploreBoard(board, rows - 1, col, nonSurroundable);
        }

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns; col++){
                if(!nonSurroundable[row][col] && board[row][col] == 'O')
                    board[row][col] = 'X';
            }
        }
    }

    public void exploreBoard(char[][] board, int row, int col, boolean[][] nonSurroundable){
        if(nonSurroundable[row][col]) return;

        nonSurroundable[row][col] = true;

        if(row+1 < rows && board[row+1][col] == 'O')
            exploreBoard(board, row+1, col, nonSurroundable);

        if(0 <= row-1 && board[row-1][col] == 'O')
            exploreBoard(board, row-1, col, nonSurroundable);

        if(col+1 < columns && board[row][col+1] == 'O')
            exploreBoard(board, row, col+1, nonSurroundable);

        if(0 <= col-1 && board[row][col-1] == 'O')
            exploreBoard(board, row, col-1, nonSurroundable);            
    }
}
