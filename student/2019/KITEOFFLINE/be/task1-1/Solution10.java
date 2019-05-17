
public class Solution10 {
    public void solveSuduko(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '0') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    // blockIndex = i / 3 * 3 + j / 3，取整
                    block[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board, row, col, block, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        while (board[i][j] != '0') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }
        for (int num = 1; num <= 9; num++) {
            int blockIndex = i / 3 * 3 + j / 3;
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                board[i][j] = (char) ('0' + num);
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
                if (dfs(board, row, col, block, i, j)) {
                    return true;
                } else {
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                    board[i][j] = '0';
                }
            }
        }
        return false;
    }
    private void printBoard(char[][] board){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '0', '0', '7', '0', '0', '0', '0'},
                {'6', '0', '0', '1', '9', '5', '0', '0', '0'},
                {'0', '9', '8', '0', '0', '0', '0', '6', '0'},
                {'8', '0', '0', '0', '6', '0', '0', '0', '3'},
                {'4', '0', '0', '8', '0', '3', '0', '0', '1'},
                {'7', '0', '0', '0', '2', '0', '0', '0', '6'},
                {'0', '6', '0', '0', '0', '0', '2', '8', '0'},
                {'0', '0', '0', '4', '1', '9', '0', '0', '5'},
                {'0', '0', '0', '0', '8', '0', '0', '7', '9'}
        };
        Solution10 so = new Solution10();
        so.solveSuduko(board);
        so.printBoard(board);
    }*/
}
