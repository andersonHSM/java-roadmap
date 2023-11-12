import operating.on.files.CommonOperations;
import operating.on.files.MoveDeleteList;
import operating.on.files.WriteAndRead;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {

        // Java11+  : Path.of()
        /*
        * Path.of is a static member to mounting file paths.
        */

        Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");
        System.out.println(path);

        path = Path.of("c:/dev/licenses/windows/readme.txt");
        System.out.println(path);

        // method override with String[] args params that mounts path
        path = Path.of("c:", "dev", "licenses", "windows", "readme.txt");
        System.out.println(path);

        path = Path.of("c:", "dev", "licenses", "windows").resolve("readme.txt"); // resolve == getChild()
        System.out.println(path);

        path = Path.of(new URI("file:///c:/dev/licenses/windows/readme.txt"));
        System.out.println(path);

        // Java < 11 equivalent: Paths.get()
        // used for compatibility purpose
        path = Paths.get("c:/dev/licenses/windows/readme.txt");
        System.out.println(path);

        // common operations


        CommonOperations.checkIfFileExists();
        CommonOperations.checkIfFolderExists();
        CommonOperations.createTempFiles();
        CommonOperations.getLastModifiedDate();

        WriteAndRead.writeFile();
        WriteAndRead.readFile();

        MoveDeleteList.moveFile();
        MoveDeleteList.deleteFile();
        MoveDeleteList.deletingDirectory();
        MoveDeleteList.listFilesInADirectory();

    }
}