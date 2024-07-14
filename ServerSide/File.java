import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class File {

    private String fileName;
    private String filePath;
    private volatile AtomicInteger writeLock = new AtomicInteger(0);
    private volatile Semaphore LOCK = new Semaphore(1);

    public File(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public String readFile() throws InterruptedException {
        writeLock.incrementAndGet();
        //reading time
        Thread.sleep(500);
        String response = FileManagement.readFile(fileName, filePath);
        writeLock.decrementAndGet();
        return response;
    }

    synchronized public String writeFile(String content) throws InterruptedException {
        while (writeLock.get() > 0 || LOCK.availablePermits() <= 0) ;
        LOCK.acquire();
        System.out.println("Write acquire LOCK : " + fileName);
        Thread.sleep(1000); //writing time
        String response = FileManagement.writeFile(fileName, filePath, content);
        LOCK.release();
        System.out.println("Write release LOCK : " + fileName);
        return response;
    }
}
