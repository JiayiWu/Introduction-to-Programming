class solution10 {
    public void solveSudoku(char[][] board) {
        if (board==null||board.length==0){
            return;
        }
        if (check(board)){
            print(board);
        }
    }
    private boolean check(char[][] board){
        for (int i = 0;i < board.length;i++){
            for (int j = 0; j < board[0].length;j++){
                if (board[i][j]=='0'){
                    for (char tr = '1';tr<='9';tr++){
                        if (isTrue(board,i,j,tr)){
                            board[i][j]=tr;
                            if (check(board)){
                                return true;
                            }else {
                                board[i][j] = '0';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isTrue(char[][]board,int i,int j,char s){
        for (int line = 0;line<9;line++){
            if (board[line][j]==s){
                return false;
            }
        }
        for (int row = 0;row<9;row++){
            if (board[i][row]==s){
                return false;
            }
        }
        for (int line = i/3*3;i<i/3*3+3;i++){
            for (int row = j/3;j<j/3+3;j++){
                if (board[line][row]==s){
                    return false;
                }
            }
        }
        return true;
    }
    private void print(char[][] board){
        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
