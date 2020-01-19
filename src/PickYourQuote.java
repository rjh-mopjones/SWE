import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PickYourQuote {
  /**
   * Main program driver.                           (1)
   */
  public static void main(String[] args) throws Exception {

    
    // Use file name and quote numbers in args
    String fileString = args[0];
    int i = Integer.parseInt(args[1]);
    FileReader file = new FileReader(fileString);

    BufferedReader input = new BufferedReader(file);

    reformat(i, input);
    input.close();
  }

  /**
   * reformat selected quote and print.                       (1)
   */
  public static void reformat(int i, BufferedReader input) throws IOException {

    String line = input.readLine();
    int index = 1;
    while (line != null) {
      if (i == index) {
        String newLine = line.replace(';','\n');
        System.out.println(newLine);
        break;
      }
      index = index + 1;
      line = input.readLine();
    }
  }
}