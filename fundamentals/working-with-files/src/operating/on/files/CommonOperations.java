package operating.on.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public class CommonOperations {
    public static void checkIfFileExists() {
        Path path1 = Path.of("fundamentals/working-with-files/files/file.txt");
        Path path2 = Path.of("fundamentals/working-with-files/files/text.txt");

        boolean exists1 = Files.exists(path1.normalize().toAbsolutePath());
        boolean exists2 = Files.exists(path2.normalize().toAbsolutePath());

        System.out.println("File " + path1 + " exists: " + exists1);
        System.out.println("File " + path2 + " exists: " + exists2);

    }

    public static void checkIfFolderExists() {
        Path path1 = Path.of("fundamentals/working-with-files/files/");
        Path path2 = Path.of("fundamentals/working-with-files/src/NotFound/");

        boolean exists1 = Files.exists(path1.normalize().toAbsolutePath());
        boolean exists2 = Files.exists(path2.normalize().toAbsolutePath());

        System.out.println("Path " + path1 + " exists: " + exists1);
        System.out.println("Path " + path2 + " exists: " + exists2);
    }

    public static void createTempFiles() throws IOException {
        Path tempFile1 = Files.createTempFile("somePrefixOrNull", ".jpg");
        System.out.println("tempFile1 = " + tempFile1);

        Path path = Path.of("fundamentals/working-with-files/files/");

        Path tempFile2 = Files.createTempFile(path, "somePrefixOrNull", ".jpg");
        System.out.println("tempFile2 = " + tempFile2);

        Path tmpDirectory = Files.createTempDirectory("prefix");
        System.out.println("tmpDirectory = " + tmpDirectory);
    }

    public static void getLastModifiedDate() throws IOException {

        Path path = Path.of("fundamentals/working-with-files/files/file.txt");

        FileTime time = Files.getLastModifiedTime(path);

        System.out.println("Last modified date: " + time);

    }


}
