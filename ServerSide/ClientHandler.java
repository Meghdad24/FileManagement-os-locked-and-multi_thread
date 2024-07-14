import java.io.*;
import java.net.Socket;

class ClientHandler implements Runnable {
    private final Socket socket;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try (
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true)
        ) {


            String command;
            while ((command = reader.readLine()) != null) {
                Thread.sleep(1500);
                System.out.println("Received: " + command);
                String action, fileName, filePath, content /* content just for WRITE*/;
                String[] command_splited = command.split("__");
                action = command_splited.length > 0 ? command_splited[0] : null;
                fileName = command_splited.length > 1 ? command_splited[1] : null;
                filePath = command_splited.length > 2 ? command_splited[2] : null;
                content = command_splited.length > 3 ? command_splited[3] : null;

                System.out.printf("action: %s | fileName: %s | content: %s\n",action,fileName,content);

                if (action == null) {
                    continue;
                }

                String response;

                switch (action) {

                    case "CREATE" -> response = FileManagement.createFile(fileName, filePath);

                    case "READ" -> response = FileDataBase.LIST_OF_FILE.get(filePath + "/" + fileName).readFile();

                    case "WRITE" -> {
                        System.out.println("FileName: " + fileName);
                        System.out.println("Content: " + content);
                        response = FileDataBase.LIST_OF_FILE.get(filePath + "/" + fileName).writeFile(content);
                    }

                    case "DELETE" -> response = FileManagement.deleteFile(fileName);

                    case "RENAME" -> {
                        String newFileName = command_splited.length > 2 ? command_splited[2] : "";
                        response = FileManagement.renameFile(fileName, newFileName);
                    }

                    default -> response = "Unknown command";
                }

                writer.println(response);
                System.out.println("Response sent: " + response);
                writer.flush();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }
}
