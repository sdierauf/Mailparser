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
    Set<String> dictionary = buildDictionary(dictionaryFilepath);
    while (!finderQueue.isEmpty()) {
      manager.addMailData(
          LinearMailBodyParser.parseContents(
              finderQueue.getNext(), dictionary
          )
      );
    }
    Map<Integer, List<String>> top = manager.searchTopWords("susandierauf@yahoo.com");
    for (Integer key : top.keySet()) {
      System.out.println(key + ": " + top.get(key).toString());
    }
    //interactive part



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
