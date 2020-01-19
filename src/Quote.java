public class Quote {

  String content;
  String context;

  /**
   * class constructor.                           (1)
   */
  public Quote(String data) {
    String[] parts = data.split(";");
    content = parts[0];
    context = parts[1];
  }

  /** B)Q1
   * method override to return reformatted result as string.           (1)
   * in form "` content " by context "\n
   * the code would still compile without this method, but it would use the default toString().
   * this would mean the Quote object itself would be stringifiyed, in the form 'Quote@XXXXXXXX'.
   * this is not useful for what we want to achieve.
   */
  public String toString() {
    return '`' + content + "' by " + context + "\"\n";

  }

  /**
   * method returns the content of the quote.           (1)
   */
  public String getQuote() {
    return content;
  }

  /**
   * method returns the context of the quote.           (1)
   */
  public String getContext() {
    return context;
  }
}
