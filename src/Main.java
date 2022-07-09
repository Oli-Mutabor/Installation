import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        String[] directories = {
                "C://Games/src",
                "C://Games/res",
                "C://Games/savegames",
                "C://Games/temps",
                "C://Games/src/main",
                "C://Games/src/test",
                "C://Games/res/drawables",
                "C://Games/res/vectors",
                "C://Games/res/icons"
        };

        String[] files = {
                "C://Games/src/main/Main.java",
                "C://Games/src/main/Utils.java",
                "C://Games/temps/temp.txt"
        };

        for (String directory : directories) {
            File dir = new File(directory);
            sb.append(createDirectory(dir));
        }

        for (String fileDirectory : files) {
            File file = new File(fileDirectory);
            sb.append(createFile(file));
        }


        try (FileWriter writer = new FileWriter("C://Games/temps/temp.txt")) {
            writer.write(String.valueOf(sb));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String createDirectory(File dir) {
        if (dir.mkdir()) {
            return "Directory " + dir.getName() + " was created" + "\n";
        } else {
            return "Directory " + dir.getName() + " was not created" + "\n";
        }
    }

    public static String createFile(File file) {
        try {
            if (file.createNewFile()) {
                return "File " + file.getName() + " was created" + "\n";
            }
        } catch (IOException ex) {
            return ex.getMessage() + "\n";
        }
        return null;
    }
}


