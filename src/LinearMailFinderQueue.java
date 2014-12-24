import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sdierauf on 12/23/14.
 * Single threaded implementation of MailFinderQueue
 */
public class LinearMailFinderQueue implements MailFinderQueue {

  private final String FILE_EXTENSION = ".eml";
  private Queue<File> mailQueue;
  private Set<String> visited;

  public LinearMailFinderQueue() {
    mailQueue = new LinkedList<File>();
    visited = new HashSet<String>();
  }

  @Override
  public File getNext() {
    if (isEmpty()) {
      return null;
    } else {
      return mailQueue.remove();
    }
  }

  /**
   * @param path should be the parent folder of all the emails
   */
  @Override
  public void buildQueueOnPath(final String path) {
    visited.add(path);
    File dir = new File(path);
    FileFilter filter = new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return pathname.getName().contains(FILE_EXTENSION);
      }
    };
    File[] files = dir.listFiles(filter);
    for (File file : files) {
      this.mailQueue.add(file);
      System.out.println("adding " + file.getName());
    }
    FileFilter directoryFilter = new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        return pathname.isDirectory() && !visited.contains(pathname.getName());
      }
    };
    File[] directories = dir.listFiles(directoryFilter);
    for (File directory : directories) {
      System.out.println("walking " + directory.getPath());
      buildQueueOnPath(directory.getPath());
    }
  }

  @Override
  public boolean isEmpty() {
    return this.mailQueue.isEmpty();
  }
}
