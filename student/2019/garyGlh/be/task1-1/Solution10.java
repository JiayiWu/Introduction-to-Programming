public class Solution10 {
    private char[][] chessboard;

    Solution10(char[][] board){
        this.chessboard=board;
    }

    public void solveSudoku(char[][] board) {
        backTrace(0,0);
    }

    public static void main(String[] args){
        char[][] soduku ={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Solution10 test = new Solution10(soduku);
        test.backTrace(0,0);
    }


    private void backTrace(int row,int col){
        //end of the board
        if(row==8&&col==9){
            print_board();
            return;
        }
        //end of a line
        if(col==9){
            row++;
            col=0;
        }
        if(chessboard[row][col]=='.'){
            for(int i=1;i<10;i++){
                if(check(row,col,i)) {
                    chessboard[row][col] = (char) (i + '0');
                    backTrace(row, col + 1);
                    chessboard[row][col] = '.';
                }
            }
        }
        else{
            backTrace(row,col+1);
        }
    }

    //check if the num can be put into chessboard[row][col]
    public boolean check(int row,int col,int num){
        //check row
        for(int i=0;i<chessboard.length;i++){
            if(chessboard[row][i]==(char)(num+'0'))
                return false;
        }
        //check col
        for(int i=0;i<chessboard.length;i++){
            if(chessboard[i][col]==(char)(num+'0'))
                return false;
        }
        //check cell
        int temp_row=row/3;
        int temp_col=col/3;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(chessboard[temp_row*3+i][temp_col*3+j]==(char)(num+'0'))
                    return false;

        return true;
    }

    public void print_board(){
        for(int i=0;i<chessboard.length;i++){
            for(int j=0;j<chessboard.length;j++){
                System.out.print(chessboard[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
