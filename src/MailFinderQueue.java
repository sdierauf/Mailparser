import java.io.*;

/**
 * Created by sdierauf on 12/23/14.
 * 
 * Represents a queue of emails to be parsed in no particular order
 */
public interface MailFinderQueue {


  /**
   * @return the next mail file in the queue
   */
  public File getNext();


  /**
   * Constructs a new MailFinderQueue on the given path
   * @param path
   */
  public void buildQueueOnPath(String path);

  public boolean isEmpty();

  public int size();

}
