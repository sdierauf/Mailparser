import java.util.*;

/**
 * Created by sdierauf on 12/23/14.
 */
public class LinearMailManager implements MailManager {

  //email -> map (word -> count)
  private Map<String, Map<String, Integer>> curMap;

  public LinearMailManager() {
    this.curMap = new HashMap<String, Map<String, Integer>>();
  }

  @Override
  public Map<String, Map<String, Integer>> getCurrentMailMap() {
    return curMap;
  }

  @Override
  public void addMailData(MailInfo data) {
    for (String email : data.recipients) {
      if (this.curMap.containsKey(email)) {
        this.curMap.get(email).putAll(data.counts);
      } else {
        this.curMap.put(email, data.counts);
      }
    }
  }

  @Override
  public Map<Integer, List<String>> searchTopWords(String email) {
    if (!this.curMap.containsKey(email)) {
      return null;
    } else {
      Map<Integer, List<String>> countsToWords = new TreeMap<Integer, List<String>>();
      Map<String, Integer> stringIntegerMap = this.curMap.get(email);
      for (String word : stringIntegerMap.keySet()) {
        int count = stringIntegerMap.get(word);
        if (countsToWords.containsKey(count)) {
          List<String> words = countsToWords.get(count);
          words.add(word);
          countsToWords.put(count, words);
        } else {
          List<String> words = new LinkedList<String>();
          words.add(word);
          countsToWords.put(count, words);
        }
      }
      return countsToWords;
    }
  }


}
