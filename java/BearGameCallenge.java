import java.util.*; 
import java.io.*;

class BearGameCallenge {
  private static int calc(int n){
    if(n>=3) n++;
    else if(n>=7) n+=2;
    return n;
  }

  public static String GameChallenge(String[] strArr) {
    // code goes here  
    //3 by 3으로 분해
    List<String> str_list = new ArrayList<>();
    for(String s: strArr) {
      if(s.equals("<>")) continue;
      str_list.add(s);
    }
    char [][] board = new char[3][3];
    for(int i=0;i<9;i++){
      board[i/3][i%3] = str_list.get(i).charAt(0);
    }

    //가로체크
    for(int y=0;y<3;y++){
      if(board[y][0]!='-' && board[y][0]==board[y][1] && board[y][2]=='-') return calc(3*y+2)+"";
      if(board[y][0]==board[y][2] && board[y][1]=='-') return calc(3*y+1)+"";
      if(board[y][1]==board[y][2] && board[y][0]=='-') return calc(3*y+0)+"";
    }
    //세로체크
    for(int x=0;x<3;x++){
      if(board[0][x]==board[1][x] && board[2][x]=='-') return calc(3*2+x)+"";
      if(board[0][x]==board[2][x] && board[1][x]=='-') return calc(3*1+x)+"";
      if(board[1][x]==board[2][x] && board[0][x]=='-') return calc(3*0+x)+"";
    }
    //대각선체크
    if(board[0][0]==board[1][1] && board[2][2]=='-') return calc(3*2+2)+"";
    if(board[0][0]==board[2][2] && board[1][1]=='-') return calc(3*1+1)+"";
    if(board[1][1]==board[2][2] && board[0][0]=='-') return calc(3*0+0)+"";

    if(board[0][2]==board[1][1] && board[2][0]=='-') return calc(3*2+0)+"";
    if(board[0][2]==board[2][0] && board[1][1]=='-') return calc(3*1+1)+"";
    if(board[1][1]==board[2][0] && board[0][2]=='-') return calc(3*0+2)+"";

    return "-1";
  }

  public static void main (String[] args) {  
    // keep this function call here     
    //Scanner s = new Scanner(System.in);
    System.out.print(GameChallenge(new String[] {"X","-","O","<>","-","-","O","<>","-","-","X"})); 
  }
}