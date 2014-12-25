import java.io.File;

/**
 * Created by sdierauf on 12/23/14.
 */
public interface MailBodyParser {

  /**
   * Parses email for important words and their counts and returns a mailinfo
   * @param email
   * @return
   */
  public MailInfo parseContents(File email);

}
