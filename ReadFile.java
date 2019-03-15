import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
  private char[][] data;
  public static void main(String args[]) throws FileNotFoundException {
        //instead of a try/catch, you can throw the FileNotFoundException.
        //This is generally bad behavior

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

        rows = 0;

        while(inf.hasNextLine()){
          String line = inf.nextLine();
          for( int i = 0; i < line.length(); i++){
            data[rows][i] = line.charAt(i);
          }
          rows++;
        }

        System.out.println(data.toString());
    }

    public String toString(){
      String output = "";
      for(int i = 0; i < data.length; i++){
        for(int j = 0; j <data[i].length; j++){
          output += "" + data[i][j];
          if (j == data[i].length -1){
            output += "\n";
          }
        }
      }
      return output;
    }

}
