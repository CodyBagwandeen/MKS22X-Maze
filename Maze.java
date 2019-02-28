import java.util.*;
import java.io.*;
public class Maze{

  private char[][]maze;
  private int[]moves = {1,0, -1,0, 0,-1, 0,1}; // up down left right
  private boolean animate; // false by default

  public static void main(String[] args){
    try{
      Maze m = new Maze("Maze1");
      System.out.println(m);
      System.out.println(m.solve());
    } catch( FileNotFoundException e){
      System.out.println("File not found");

    }

  }

  public Maze(String filename) throws FileNotFoundException{

    File text = new File("Maze1.txt");
    // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"

    //inf stands for the input file
    Scanner inf = new Scanner(text);

    int rows = 0; // number of rows in file
    int cols = 0; // number of cols in file
    while(inf.hasNextLine()){
        String line = inf.nextLine();
        cols = line.length();
        rows++;
        //System.out.println(line);//hopefully you can do other things with the line
    }
    maze = new char[rows][cols];

    rows = 0;

    inf =  new Scanner(text);

    while(inf.hasNextLine()){
      String line = inf.nextLine();
      for( int i = 0; i < line.length(); i++){
        maze[rows][i] = line.charAt(i);
      }
      rows++;
    }
  }

  public String toString(){
    String output = "";
    for(int i = 0; i < maze.length; i++){
      for(int j = 0; j < maze[i].length; j++){
        output += "" + maze[i][j];
        if (j == maze[i].length -1){
          output += "\n";
        }
      }
    }
    return output;
  }

  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }catch(InterruptedException e) {
    }
  }

  public void setAnimate(boolean b){
    animate = b;

  }

  public int solve(){
    // find S
    int row = 0;
    int col = 0;

    for(int i = 0; i < maze.length; i++){
      for(int j = 0; j < maze[i].length; j++){
        if(maze[i][j] == 'S'){
          row = i;
          col = j;
        }
      }
    }
    //Erase the S
    maze[row][col] = ' ';

    //start there
    return solve(row, col, 0,0,0);
  }

  public int solve(int row, int col, int counter, int oldrow, int oldcol){
    if(maze[row][col] == 'E'){ // when you reach the end you are at the end
      return counter;
    }

    maze[row][col] = '@'; // put the @ to where to are


    for(int i = 0; i < 8; i+=2){
      if( maze[row + moves[i]][col + moves[i+1]] == ' ' ){
        solve(row + moves[i], col + moves[i+1], counter+1, row, col);
      }
    }

    // if you can't move anywhere
    maze[row][col] = '.';
    solve(oldrow, oldrow, counter-1, 1, 1);

    // if there is no solution
    return -1;
  }
}
