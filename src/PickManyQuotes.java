import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PickManyQuotes { /** * Main program driver.                           (1) */
  public static void main(String[] args) throws Exception {
    // Use file name and quote numbers in args
    int [] choices = new int[args.length - 1];
    String fileName = args[0];
    for (int i = 0; i < choices.length; i++) {
      choices[i] = Integer.parseInt(args[i + 1]);
    }
    FileReader file = new FileReader(fileName);

    BufferedReader input = new BufferedReader(file);

    // to first create a list of quotes using loadQuotes
    List<Quote> quotes = loadQuotes(input);
    // and then print to System.out the chosen quotes.
    reformat(quotes, choices);
    input.close();

  }

  /**
   * Reformat method, to print out quotes in specified format.(1)
   * "` content ' by context "
   */
  public static void reformat(List<Quote> quotes, int[] choices) {
    String output;
    // Print to System.out quotes according to choices.

    for (int i = 0; i < choices.length; i++) {
      Quote currQuote = quotes.get(choices[i] - 1);
      String result = currQuote.toString();
      System.out.println(result);
    }
  }

  /**
   * LoadQuotes method, turn bufferedreader of file.
   * into a list of quote objects (1)
   *
   * B)Q2.
   * the List variable is not an object, it is an interface.
   * it needs to be made to be a reference to another object to work.
   * here we referenced ArrayList, but we could have also used:
   * Vector, Stack, LinkedList
   *
   * C)Q3.
   * You can quite easily substitute an array list for a linked list.
   * they are fairly similar, however changes might need to be made
   * because you cannot randomly access a linked list like you can an
   * array list.
   */
  public static List<Quote> loadQuotes(BufferedReader in) throws IOException {
    List<Quote> quotes = new ArrayList<Quote>();

    // Read lines from the input // Create a Quote object for each line and store in list.
    String line = in.readLine();
    while (line != null) {
      Quote currQuote = new Quote(line);
      quotes.add(currQuote);
      line = in.readLine();
    }
    return quotes;
  }



}
