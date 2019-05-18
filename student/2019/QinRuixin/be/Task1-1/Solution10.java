package Task1_1;

public class Solution10 {
    public void solveSudoku(char[][] board) {
        boolean[][] block = new boolean[9][10];
        boolean[][] row = new boolean[9][10];
        boolean[][] column = new boolean[9][10];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '0') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    column[j][num] = true;
                    block[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }

        bfs(board, block, row, column, 0, 0);
    }

    private boolean bfs(char[][] board, boolean[][] block, boolean[][] row, boolean[][] column, int i, int j) {
        while (board[i][j] != '0') {
            j++;
            if (j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }

        for (int k = 1; k <= 9; k++) {
            if (!block[i / 3 * 3 + j / 3][k] && !row[i][k] && !column[j][k]) {
                board[i][j] = (char) ('0' + k);
                block[i / 3 * 3 + j / 3][k] = true;
                row[i][k] = true;
                column[j][k] = true;
                if (bfs(board, block, row, column, i, j)) {
                    return true;
                } else {
                    block[i / 3 * 3 + j / 3][k] = false;
                    row[i][k] = false;
                    column[j][k] = false;
                    board[i][j] = '0';
                }
            }
        }
        return false;
    }
}