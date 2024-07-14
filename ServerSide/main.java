import java.io.IOException;

public class main {
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.serverMainMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
