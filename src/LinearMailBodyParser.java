import java.io.File;
import java.util.Scanner;

/**
 * Created by sdierauf on 12/24/14.
 */
public class LinearMailBodyParser {


  public static MailInfo parseContents(File email) {
    MailInfo info = new MailInfo();
    Scanner bodyScanner;
    try {
       bodyScanner = new Scanner(email);
      while (bodyScanner.hasNext()) {

      }
    } catch(Exception e) {
      System.out.println("Failed to construct scanner on email!");
    }
    return info;
  }
}
