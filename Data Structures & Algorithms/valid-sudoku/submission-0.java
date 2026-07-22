class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        HashSet<Character>[] sets = new HashSet[9];
        int boxNo = 0;
        for(int i = 0; i < board.length; i++){
            sets[i] = new HashSet<>();
        }

        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[row].length; column++){
                if(board[row][column] != '.'){
                    boxNo = ((row / 3)) * 3 + (column / 3);
                    if(set.contains(board[row][column]) || sets[boxNo].contains(board[row][column])){
                        return false;
                    }
                    set.add(board[row][column]);
                    sets[boxNo].add(board[row][column]);
                }
            }
            set.clear();
        }


        for(int column = 0; column < board[0].length; column++){
            for(int row = 0; row < board.length; row++){
                if(board[row][column] != '.'){
                    if(set.contains(board[row][column])){
                        return false;
                    }
                    set.add(board[row][column]);
                }
            }
            set.clear();
        }

        return true;
    }
}
