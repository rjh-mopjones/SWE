import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.Test;

public class PickYourQuoteTest {

  @Test
  public void exampleText() throws Exception {

    String input =
        String.join(
                "\n",
                "What a test!;Anonymous",
                "Another test!;Anonymous",
                "The last test!;Anonymous");

    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outstream));

    PickYourQuote.reformat(2, new BufferedReader(new StringReader(input)));

    String output = outstream.toString();
    assertThat(
        "Selected line 2 but got a different line.",
        output,
        containsString("Another test!" + "\n" + "Anonymous"));
  }
}
