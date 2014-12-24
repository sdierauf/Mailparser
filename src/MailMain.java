import java.util.HashMap;
import java.util.Map;

/**
 * Created by sdierauf on 12/23/14.
 */
public class MailMain {

  public static final String filepath = "I AM NOT A FILE PATH";

  public static void main(String[] args) {
    System.out.println("Gathering emails... ");
    MailFinderQueue queue = new LinearMailFinderQueue();
    queue.buildQueueOnPath(filepath);
    //email address -> word -> count
    Map<String, Map<String, Integer>> emails = new HashMap<String, Map<String, Integer>>();



  }
}
