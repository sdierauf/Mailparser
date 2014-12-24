import java.util.List;
import java.util.Map;

/**
 * Created by sdierauf on 12/23/14.
 */
public interface MailManager {

  public Map<String, Map<String, Integer>> getCurrentMailMap();

  public void addMailData(MailInfo data);

  public Map<Integer, List<String>> searchTopWords(String email);
}
