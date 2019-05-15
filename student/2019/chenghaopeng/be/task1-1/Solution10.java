class Solution10 {
    private int[][] sudoku;
    private int[][][] used;
    private Boolean check(int x, int y, int n) {
        return used[0][x/3*3+y/3][n] == 0 && used[1][x][n] == 0 && used[2][y][n] == 0;
    }
    private void dfs(int cnt, int x, int y) {
        if(cnt == 81) {
            for(int i=0; i<9; ++i) {
                for(int j=0; j<9; ++j) {
                    System.out.print(Integer.toString(sudoku[i][j]) + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        if(sudoku[x][y] == 0) {
            for(int i=1; i<=9; ++i) {
                if(check(x, y, i)) {
                    sudoku[x][y] = i;
                    used[0][x/3*3+y/3][i] = 1;
                    used[1][x][i] = 1;
                    used[2][y][i] = 1;
                    dfs(cnt + 1, x, y);
                    sudoku[x][y] = 0;
                    used[0][x/3*3+y/3][i] = 0;
                    used[1][x][i] = 0;
                    used[2][y][i] = 0;
                }
            }
            return;
        }
        for(int j=y+1; j<9; ++j) {
            if(sudoku[x][j] == 0) {
                dfs(cnt, x, j);
                return;
            }
        }
        for(int i=x+1; i<9; ++i) {
            for(int j=0; j<9; ++j) {
                if(sudoku[i][j] == 0) {
                    dfs(cnt, i, j);
                    return;
                }
            }
        }
    }
    public void solveSudoku(char[][] board) {
        sudoku = new int[9][9];
        for(int i=0; i<9; ++i) {
            for(int j=0; j<9; ++j) {
                sudoku[i][j] = board[i][j] - '0';
            }
        }
        used = new int[3][9][10];
        for(int k=0; k<9; ++k) {
            for(int i=k/3*3; i<k/3*3+3; ++i) {
                for(int j=k%3*3; j<k%3*3+3; ++j) {
                    if(sudoku[i][j] > 0) {
                        used[0][k][sudoku[i][j]] = 1;
                    }
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<9; ++i) {
            for(int j=0; j<9; ++j) {
                if(sudoku[i][j] > 0) {
                    used[1][i][sudoku[i][j]] = 1;
                    used[2][j][sudoku[i][j]] = 1;
                    cnt++;
                }
            }
        }
        dfs(cnt, 0, 0);
    }
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        solution10.solveSudoku(new char[][]{
            {'0', '2', '0', '6', '9', '0', '0', '5', '4'},
            {'0', '8', '5', '2', '0', '0', '0', '1', '9'},
            {'9', '6', '1', '0', '0', '5', '0', '0', '0'},
            {'0', '0', '0', '0', '1', '6', '0', '0', '0'},
            {'0', '4', '8', '3', '0', '2', '0', '0', '1'},
            {'0', '0', '9', '0', '0', '0', '7', '0', '2'},
            {'0', '0', '3', '0', '0', '9', '0', '0', '8'},
            {'0', '5', '0', '0', '0', '0', '0', '9', '0'},
            {'0', '0', '0', '4', '0', '0', '0', '0', '7'}
        });
    }
}