import java.util.*;
import java.io.*;
public class Maze{

  private char[][]maze;
  private boolean animate; // false by default

  public static void main(String[] args){
    try{
      Maze m = new Maze("Maze1");
      System.out.println(m);
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
    char[][] data = new char[rows][cols];
    maze = data;

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
}
