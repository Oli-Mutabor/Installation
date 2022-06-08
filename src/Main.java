import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        File dirSrc = new File("C://Games/src");
        sb.append(createDirectory(dirSrc));
        File dirRes = new File("C://Games/res");
        sb.append(createDirectory(dirRes));
        File dirSavegames = new File("C://Games/savegames");
        sb.append(createDirectory(dirSavegames));
        File dirTemp = new File("C://Games/temps");
        sb.append(createDirectory(dirTemp));

        File dirMain = new File("C://Games/src/main");
        sb.append(createDirectory(dirMain));
        File dirTest = new File("C://Games/src/test");
        sb.append(createDirectory(dirTest));

        File fileMain = new File("C://Games/src/main/Main.java");
        sb.append(createFile(fileMain));
        File createFile = new File("C://Games/src/main/Utils.java");
        sb.append(createFile(createFile));

        File dirDrawables = new File("C://Games/res/drawables");
        sb.append(createDirectory(dirDrawables));
        File dirVectors = new File("C://Games/res/vectors");
        sb.append(createDirectory(dirVectors));
        File dirIcons = new File("C://Games/res/icons");
        sb.append(createDirectory(dirIcons));

        File fileTemp = new File("C://Games/temps/temp.txt");
        sb.append(createFile(fileTemp));

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


