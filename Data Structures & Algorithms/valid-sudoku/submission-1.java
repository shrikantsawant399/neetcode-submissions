class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSets = new HashSet[9];
        HashSet<Character>[] columnSets = new HashSet[9];
        HashSet<Character>[] innerMatrixSets = new HashSet[9];
        int boxNo = 0;
        for(int i = 0; i < board.length; i++){
            rowSets[i] = new HashSet<>();
            columnSets[i] = new HashSet<>();
            innerMatrixSets[i] = new HashSet<>();
        }

        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[row].length; column++){
                if(board[row][column] != '.'){
                    boxNo = ((row / 3)) * 3 + (column / 3);
                    if(rowSets[row].contains(board[row][column]) || columnSets[column].contains(board[row][column]) || innerMatrixSets[boxNo].contains(board[row][column])){
                        return false;
                    }
                    rowSets[row].add(board[row][column]);
                    columnSets[column].add(board[row][column]);
                    innerMatrixSets[boxNo].add(board[row][column]);
                }
            }
        }

        return true;
    }
}
