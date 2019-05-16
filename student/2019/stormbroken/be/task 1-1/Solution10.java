package Solution;

class Solution10 {
	private char[][] board;
	public Solution10(char[][] board) {
		this.board=board;
	}
    public void solveSudoku() {
    	Solution10 s = new Solution10(board);
    	s.trace(0, 0);
    }
    public void trace(int i,int j) {
    	if(i==8&&j==9) {
    		System.out.println("计算完成");
    		for(int m = 0;m<board.length;m++) {
    			for(int n = 0;n<board[0].length;n++) {
    				System.out.print(board[m][n]+" ");
    			}
    			System.out.println("");
    		}
    		return;
    	}
    	if(j==9) {
    		i++;
    		j=0;
    	}
    	if(board[i][j]=='0') {
    		for(int k = 1;k <= 9;k++) {
    			if(judge(i,j,String.valueOf(k).charAt(0))) {
    				board[i][j] = String.valueOf(k).charAt(0);
    				trace(i, j+1);
    				board[i][j] = '0';
    			}
    		}
    	}else {
    		trace(i, j+1);
    	}
    }
    //用于判断加载是否合法
    public boolean judge(int m,int n,char str) {
    	for (int i = 0;i<board[m].length;i++) {
    		if(board[m][i]==str||board[i][n]==str) {
    			return false;
    		}
    	}
    	for(int i = 0; i <  3;i ++) {
    		for (int j = 0;j < 3;j++) {
    			if (board[m/3*3+i][n/3*3+j]==str) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    public static void main(String[] args) {
    	
    	char[][] board = {
    			 {'0','4','2','0','1','0','0','7','0'},                
    			 {'9','0','0','0','0','0','0','5','1'},
    			 {'0', '0', '0', '7', '6','0', '8', '2', '0'},                
    			 {'0', '1', '6', '2', '0', '7', '0', '4', '8'},                
    			 {'8','0', '5','0', '0','0', '3', '9','0'},                
    			 {'4','9', '0','0','3', '8','0','0','0'},                
    			 {'5', '3','1','6','7','0', '4','8', '9'},                
    			 {'7', '0', '0','4', '5','3', '0','6', '2'},                
    			 {'2','0', '0','9', '0','1', '0', '3', '5'}
							        };
    	Solution10 s = new Solution10(board);
    	s.solveSudoku();
    	}
}
