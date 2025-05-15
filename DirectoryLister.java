import java.io.File;

public class DirectoryLister {
    public static void main(String[] args) {
        String directoryPath = "E:/JAVA Lab";
        File directory = new File(directoryPath);
        
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("Not a valid directory");
        }
    }
}