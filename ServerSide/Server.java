import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static int PORT = 9999;
    private static final int THREAD_POOL_SIZE = 10;
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static HashMap<Integer, Socket> CONNECTIONS_HashMap;
    private Boolean RUNNING = false;

    public void serverMainMethod() throws IOException {

        CONNECTIONS_HashMap = new HashMap<>();

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.printf("Connected to PORT:%s\n",socket.getPort());
            threadPool.execute(new ClientHandler(socket));
        }

    }

//        Thread connectionHandler = new Thread(new connectionHandler(serverSocket));
//        connectionHandler.start();


}

//    class connectionHandler implements Runnable {
//        private final ServerSocket serverSocket;
//
//        public connectionHandler(ServerSocket serverSocket) {
//            this.serverSocket = serverSocket;
//        }
//
//        @Override
//        public void run() {
//                try (Socket connection = serverSocket.accept()) {
//                CONNECTIONS_HashMap.put(connection.getLocalPort(), connection);
//                threadPool.execute(new ClientHandler(connection));
//                } catch (IOException ignored) {}
//                while (RUNNING) ;
//        }
//    }
//}
