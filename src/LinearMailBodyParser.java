import java.io.File;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sdierauf on 12/24/14.
 */
public class LinearMailBodyParser {

  public static MailInfo parseContents(File email, Set<String> dictionary) {
    MailInfo info = new MailInfo();
    Scanner bodyScanner;
    try {
      bodyScanner = new Scanner(email);
      while (bodyScanner.hasNext()) {
        String token = bodyScanner.next();
        if (isEmail(token)) {
          info.recipients.add(token);
        }
        if (dictionary.contains(token)) {
          if (info.counts.containsKey(token)) {
            info.counts.put(token, info.counts.get(token) + 1);
          } else {
            info.counts.put(token, 1);
          }
        }
      }
    } catch(Exception e) {
      System.out.println("Failed to construct scanner on email!");
    }
    return info;
  }

  private static boolean isEmail(String token) {
    String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
    return token.matches(emailPattern);
  }

}
