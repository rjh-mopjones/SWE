import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class QuotesPrinter {

  /** A)Q1.
   * quotesFile must be static, non static variable.
   * cannot be referenced from a static context.
   */
  static final String quotesFile = "Quotes.txt";

  /**
   * Main program driver.                           (1)
   */
  public static void main(String[] args) throws Exception {

    FileReader file = new FileReader(quotesFile);
    // read the file Quotes.txt using a BufferedReader

    BufferedReader reader = new BufferedReader(file);

    // reformat the file
    reformat(reader);

    /** B)Q2.
     *  I closed the buffered reader because it is good practice to do so.
     *  however it may not be a problem in this program because only one
     *  file is opened and is processed very quickly, this may become a problem
     *  in bigger programs however, where lots of files need to be processed, there
     *  could be a limit on the amount of files you can have open.
     */
    reader.close();

  }

  /**
   * Method that separates the line to two lines
   * depending on the semicolon position.              (1)
   */
  public static void reformat(BufferedReader input) throws IOException {

    // read lines from the input
    String line = input.readLine();

    while (line != null) {
      // check for edge cases: only one colon, no more no less
      long count = line.chars().filter(num -> num == ';').count();
      if (count != 1) {
        throw new IllegalArgumentException("not exactly one colon in line");
      }

      // reformat as appropriate
      String newLine = line.replace(';','\n');
      // print to System.out
      System.out.println(newLine);
      line = input.readLine();
    }
  }
}
