import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BasicClient {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public BasicClient(String hostname, int port) {
        try {
            this.socket = new Socket(hostname, port);
            this.writer = new PrintWriter(socket.getOutputStream(), true);
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
    }

    public void sendCommand(String command) {
        if (socket == null || writer == null || reader == null) {
            System.out.println("Client is not connected");
            return;
        }

        writer.println(command);
    }

    public String receiveResponse() throws IOException {
        if (socket == null || writer == null || reader == null) {
            throw new IllegalStateException("Client is not connected");
        }
        return reader.readLine();
    }

    public void close() {
        try {
            if (reader != null)
                reader.close();
            if (writer != null)
                writer.close();
            if (socket != null)
                socket.close();
        } catch (IOException ex) {
            System.out.println("Error closing client: " + ex.getMessage());
        }
    }
}
