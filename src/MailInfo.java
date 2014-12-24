import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by sdierauf on 12/23/14.
 *
 * represents the important contents of an email,
 */
public class MailInfo {
  public List<String> recipients;
  public Map<String, Integer> counts;

  public MailInfo() {
    this.recipients = new LinkedList<String>();
    this.counts = new HashMap<String, Integer>();
  }
}
