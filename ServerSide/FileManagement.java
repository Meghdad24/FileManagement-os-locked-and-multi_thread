import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;

public class FileManagement {

    public static String createFile(String fileName, String filePath) {
        Path path1 = Paths.get(filePath + "/" + fileName);
        try {
            System.out.println("Creating file at path: " + path1.toAbsolutePath());
            if (Files.exists(path1)) {
                return "File " + fileName + " already exists";
            } else {
                Files.createFile(path1);
                FileDataBase.LIST_OF_FILE.put(filePath + "/" + fileName, new File(fileName, filePath));
                return "File " + fileName + " created successfully";
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            String p = path1.toAbsolutePath() + fileName;
//            fileLocks.remove(p);
            return "Error creating file " + fileName;
        }
    }

    public static String readFile(String fileName, String filePath) {
        try {
            Path path = Paths.get(filePath + "/" + fileName);
            if (Files.exists(path)) {
                return new String(Files.readAllBytes(path));
            } else {
                return "File " + fileName + " not found for READ";
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return "Error reading file " + fileName;
        }
    }

    public static String writeFile(String fileName, String filePath, String content) {
        try {
            Path path = Paths.get(filePath + "/" + fileName);
            if (Files.exists(path)) {

                Files.write(path, (new String(Files.readAllBytes(path)) + " * " + content).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                return "File " + fileName + " written successfully";
            } else {
                return "File " + fileName + " not found for WRITE";
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return "Error writing to file "  + fileName;
        }
    }

    public static String deleteFile(String fileName) {
        try {
            Path path = Paths.get(fileName);
            if (Files.exists(path)) {
                Files.delete(path);
//                fileLocks.remove(path.toAbsolutePath().toString() + fileName);
                return "File deleted successfully";
            } else {
                return "File not found";
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return "Error deleting file";
        }
    }


    public static String renameFile(String curName, String newName) {
        try {
            Path curPath = Paths.get(curName);
            Path newPath = Paths.get(newName);
            if (Files.exists(curPath)) {
                Files.move(curPath, newPath, StandardCopyOption.REPLACE_EXISTING);
                return "File renamed successfully";
            } else {
                return "File not found";
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            return "Error renaming file";
        }
    }
}
