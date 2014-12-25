import java.io.File;
import java.util.*;

/**
 * Created by sdierauf on 12/23/14.
 */
public class MailMain {

  public static final String filepath = "../emails";
  public static final String dictionaryFilepath = "dictionary.txt";

  public static void main(String[] args) {
    System.out.println("Gathering emails... ");
    MailFinderQueue finderQueue = new LinearMailFinderQueue();
    MailManager manager = new LinearMailManager();
    finderQueue.buildQueueOnPath(filepath);
    int total = finderQueue.size();
    Set<String> dictionary = buildDictionary(dictionaryFilepath);
    int current = 1;
    while (!finderQueue.isEmpty()) {
      System.out.println("Processing record " + current + " of " + total);
      manager.addMailData(
          LinearMailBodyParser.parseContents(
              finderQueue.getNext(), dictionary
          )
      );
      current++;
    }

    //interactive part
    String input = "";
    Scanner in = new Scanner(System.in);
    while (!input.equals("exit")) {
      System.out.print("enter an email or 'exit' to quit: ");
      input = in.nextLine();
      if (input.equals("exit")) {
        System.out.println("bye");
      } else {
        manager.printTop(input);
      }
    }


  }

  public static Set<String> buildDictionary(String path) {
    Set<String> dictionary = new HashSet<String>();
    try {
      Scanner dictScanner = new Scanner(new File(path));
      while (dictScanner.hasNext()) {
        dictionary.add(dictScanner.next());
      }
    } catch (Exception e) {
      System.out.println("Couldn't build dictionary!!");
    }
    return dictionary;
  }
}
