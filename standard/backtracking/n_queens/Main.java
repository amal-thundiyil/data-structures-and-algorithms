import java.util.*;
import java.lang.Math;

class Solution {
    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(board, 0);
        return res;
    }
    
    void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(boardToList(board));
            return;
        }
        
        for (int col = 0; col < board.length; ++col) {
              if (!isValid(board, row, col)) {
                  continue;
             }
             board[row][col] = 'Q';
             backtrack(board, row + 1);
             board[row][col] = '.';
        }
        return;
    }
    
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < n; ++i ) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    
    private List<String> boardToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}