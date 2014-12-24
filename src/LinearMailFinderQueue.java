import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sdierauf on 12/23/14.
 * Single threaded implementation of MailFinderQueue
 */
public class LinearMailFinderQueue implements MailFinderQueue {

  private Queue<File> mailQueue;
  private String folderPath;

  public LinearMailFinderQueue() {

  }

  @Override
  public File getNext() {
    return null;
  }

  @Override
  public void buildQueueOnPath(String path) {

  }
}
