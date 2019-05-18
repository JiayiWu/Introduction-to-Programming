import java.util.*;

/**
 * Solution10
 */
public class Solution10 {
  int deep = 0;
  public void solveSudoku(char[][] board){
    int[][] field = initialize(board);
    long start = System.currentTimeMillis();
    loop(field);
    long end = System.currentTimeMillis();
    System.out.println("time: " + (end-start) + "ms");
    System.out.println("result: ");
    print(field);
    System.out.println("deep: " + deep);
  }
  public boolean loop(int[][] field){
    deep++;
    if(countBlank(field) == 0)
      return true;
    for(int i=0 ; i<9 ; i++)
      for(int j=0 ; j<9 ; j++)
        if(isBlank(field, i, j)){
          for(int num=1 ; num<=9 ; num++){
            if(isAvalible(field, i, j, num)){
              // System.out.println("before");
              // print(field);
              // int[][] temp = deepClone(field);
              field[i][j] = num;
              // fillUnique(field);
              if(loop(field))
                return true;
              field[i][j] = 0;
              // System.out.println("after");
              // print(field);
            }
          }
          return false;
        }
    return true;
  }
  public int[][] deepClone(int[][] field){
    int[][] temp = new int[9][9];
    for(int i=0 ; i<9 ; i++){
      temp[i] = field[i].clone();
    }
    return temp;
  }
  public void fillUnique(int[][] field){
    boolean changed = true;
    while(changed = !changed | fillOnlyInBox(field) | fillOnlyInBlock(field) | fillOnlyInLine(field));
  }
  public boolean fillOnlyInLine(int[][] field){
    boolean changed = false;
    Queue<Integer> temp = new LinkedList<Integer>();
    Queue<Integer> temp2 = new LinkedList<Integer>();
    int x, y;
    for(int num=1 ; num<=9 ; num++){
      for(int row=0 ; row<9 ; row++){
        for(int col=0 ; col<9 ; col++){
          if(isAvalible(field, row, col, num)){
            temp.add(row);
            temp.add(col);
          }
          if(isAvalible(field, col, row, num)){
            temp2.add(col);
            temp2.add(row);
          }
        }
        if(temp.size() == 1){
          x = temp.poll();
          y = temp.poll();
          field[x][y] = num;
          changed = true;
        }else{
          temp.clear();
        }
        if(temp2.size() == 1){
          x = temp2.poll();
          y = temp2.poll();
          field[x][y] = num;
          changed = true;
        }else{
          temp2.clear();
        }
      }
    }
    return changed;
  }
  public boolean fillOnlyInBlock(int[][] field){
    boolean changed = false;
    Queue<Integer> temp = new LinkedList<Integer>();
    int x, y;
    for(int num=1 ; num <= 9 ; num++){
      for(int areaX = 0 ; areaX<9 ; areaX+=3){
        for(int areaY = 0 ; areaY<9 ; areaY+=3){
          for(int i=areaX ; i<areaX+3 ; i++){
            for(int j=areaY ; j<areaY+3 ; j++){
              if(isAvalible(field, i, j, num)){
                temp.add(i);
                temp.add(j);
              }
            }
          }
          if(temp.size() == 2){
            x = temp.poll();
            y = temp.poll();
            field[x][y] = num;
            changed = true;
          }else{
            temp.clear();
          }
        }
      }
    }
    return changed;    
  }
  public boolean fillOnlyInBox(int[][] field){
    boolean changed = false;
    Queue<Integer> temp = new LinkedList<Integer>();
    for(int i=0 ; i<9 ; i++){
      for(int j=0 ; j<9 ; j++){
        for(int num=1 ; num<=9 ; num++)
          if(isAvalible(field, i, j, num))
            temp.add(num);
        if(temp.size() == 1){
          field[i][j] = temp.poll();
          changed = true;
        }else{
          temp.clear();
        }
      }
    }
    return changed;
  }
  public boolean isAvalible(int[][] field, int x, int y, int num){
    if(!isBlank(field, x, y))
      return false;
    for(int i=0 ; i<9 ; i++){
      if(i!=x && field[i][y]==num)
        return false;
      if(i!=y && field[x][i]==num)
        return false;
    }
    int areaX = x/3*3;
    int areaY = y/3*3;
    for(int i=0 ; i<3 ; i++)
      for(int j=0 ; j<3 ; j++)
        if((areaX+i !=x) && (areaY+j != y) && field[areaX+i][areaY+j]==num)
          return false;
    return true;
  }
  public int countBlank(int[][] field){
    int blank = 0;
    for(int i=0 ; i<9 ; i++)
      for(int j=0 ; j<9 ; j++)
        if(field[i][j]==0)
          blank++;
    return blank;
  }
  public int[][] initialize(char[][] board){
    int[][] field = new int[9][9];
    for(int i=0 ; i<9 ; i++)
      for(int j=0 ; j<9 ; j++)
        field[i][j] = board[i][j] - '0';
    System.out.println("initialize:");
    print(field);
    return field;
  }
  public boolean isBlank(int[][] field, int x, int y){
    if(field[x][y] == 0)
      return true;
    return false;
  }
  public void print(int[][] field){
    StringBuilder result = new StringBuilder();
    for(int i=0 ; i<9 ; i++){
      if(i%3==0 && i!=0)
        result.append("-----+-----+-----\n");
      for(int j=0 ; j<9 ; j++){
        if(field[i][j] == 0)
          result.append('.');
        else
          result.append(field[i][j]);
        if((j+1)%3==0 && j!=8)
          result.append("|");
        else
          result.append(" ");
      }
      result.append("\n");
    }
    System.out.println(result);
  }
  public static void main(String[] args) {
    char[][] temp1 = {
      {'0','0','9','7','4','8','0','0','0'},
      {'7','0','0','0','0','0','0','0','0'},
      {'0','2','0','1','0','9','0','0','0'},
      {'0','0','7','0','0','0','2','4','0'},
      {'0','6','4','0','1','0','5','9','0'},
      {'0','9','8','0','0','0','3','0','0'},
      {'0','0','0','8','0','3','0','2','0'},
      {'0','0','0','0','0','0','0','0','6'},
      {'0','0','0','2','7','5','9','0','0'},
    };
    char[][] temp2 = {
      {'0','2','7','3','8','0','0','1','0'},
      {'0','1','0','0','0','6','7','3','5'},
      {'0','0','0','0','0','0','0','2','9'},
      {'3','0','5','6','9','2','0','8','0'},
      {'0','0','0','0','0','0','0','0','0'},
      {'0','6','0','1','7','4','5','0','3'},
      {'6','4','0','0','0','0','0','0','0'},
      {'9','5','1','8','0','0','0','7','0'},
      {'0','8','0','0','6','5','3','4','0'},
    };
    char[][] temp3 = {
      {'0','0','0','0','0','0','5','2','0'},
      {'0','8','0','4','0','0','0','0','0'},
      {'0','3','0','0','0','9','0','0','0'},
      {'5','0','1','0','0','0','6','0','0'},
      {'2','0','0','7','0','0','0','0','0'},
      {'0','0','0','3','0','0','0','0','0'},
      {'6','0','0','0','1','0','0','0','0'},
      {'0','0','0','0','0','0','7','0','4'},
      {'0','0','0','0','0','0','0','3','0'},
    };
    char[][] temp4 = {
      {'5','3','0','0','7','0','0','0','0'},
      {'6','0','0','1','9','5','0','0','0'}, 
      {'0','9','8','0','0','0','0','6','0'}, 
      {'8','0','0','0','6','0','0','0','3'}, 
      {'4','0','0','8','0','3','0','0','1'}, 
      {'7','0','0','0','2','0','0','0','6'}, 
      {'0','6','0','0','0','0','2','8','0'}, 
      {'0','0','0','4','1','9','0','0','5'}, 
      {'0','0','0','0','8','0','0','7','9'}
    };
    char[][] temp5 = {
      {'0','0','0','0','0','0','0','0','0'},
      {'0','0','0','0','0','0','0','0','0'},
      {'0','0','0','0','0','0','0','0','0'},
      {'0','0','0','0','0','0','0','0','0'},
      {'0','0','0','0','0','0','0','0','0'},
      {'0','0','0','0','0','0','0','0','0'},
      {'0','0','0','0','0','0','0','0','0'},
      {'0','0','0','0','0','0','0','0','0'},
      {'0','0','0','0','0','0','0','0','0'},
    };
    new Solution10().solveSudoku(temp3);
  }
}