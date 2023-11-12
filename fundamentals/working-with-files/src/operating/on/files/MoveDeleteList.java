package operating.on.files;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.stream.Stream;

public class MoveDeleteList {
    public static void moveFile() throws IOException {
        Path tempFile = Files.createTempFile("moving", ".txt");
        Files.writeString(tempFile, "This is a test for checking on moving");
        try {
            Files.move(tempFile, Path.of("fundamentals", "working-with-files", "files")
                    .resolve(tempFile.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (FileAlreadyExistsException exception) {
            System.out.println("Moving file went wrong.");
        }

    }

    public static void deleteFile() throws IOException {
        Path filePath = Path.of("fundamentals", "working-with-files", "files", "toDelete.txt");
        try {
            Path file = Files.createFile(filePath);
            Files.writeString(filePath, "This is a file to be deleted.");

            System.out.println("File created: " + file + " | Content: " + Files.readString(filePath));

        } catch (NoSuchFileException | FileAlreadyExistsException exception) {
            System.out.println("File preexists to this execution");
        }

        Files.delete(filePath);

        boolean fileDeleted = Files.exists(filePath);

        if (!fileDeleted) {
            System.out.println("File deleted: " + filePath);
            return;
        }

        System.out.println("File not deleted: " + filePath);

    }

    public static void deletingDirectory() throws IOException {
        Path dirCreated = createFolderForDeletion();
        Files.delete(dirCreated);

        dirCreated = createFolderForDeletion();
        populateFolder(dirCreated);
        try {
            Files.delete(dirCreated);
        } catch (DirectoryNotEmptyException exception) {
            deleteNonEmptyDirectory(dirCreated);
        }


//        try (Stream<Path> walk = Files.walk(tmpDir)) {
//            walk.sorted(Comparator.reverseOrder()).forEach(path -> {
//                try {
//                    Files.delete(path);
//                } catch (IOException e) {
//                    // something could not be deleted..
//                    e.printStackTrace();
//                }
//            });
//        }
    }

    @NotNull
    private static Path createFolderForDeletion() throws IOException {
        Path tmpDir = Path.of("fundamentals", "working-with-files", "files");
        Path directoryCreated = Path.of(tmpDir.toAbsolutePath().toString(), "folder-to-delete");
        try {
            Files.createDirectory(directoryCreated);

        } catch (FileAlreadyExistsException exception) {
            System.out.println("Folder previous exists.");
        }

        return directoryCreated;
    }

    private static void populateFolder(Path directory) throws IOException {
        for (int i = 0; i < 10; i++) {
            Files.createFile(Path.of(directory.toAbsolutePath().toString(), "file-" + i + ".txt"));
        }
    }

    private static void deleteNonEmptyDirectory(Path directory) throws IOException {
        try (Stream<Path> walk = Files.walk(directory)) {
            walk.sorted(Comparator.reverseOrder()).forEach(path -> {
                System.out.println(path);
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("Folder deleted successfully");
        }
    }

    public static void listFilesInADirectory() throws IOException {
        Path tmpDirectory = Path.of("fundamentals", "working-with-files", "files");

        System.out.println("\nPrinting with Files.list");
        try (var files = Files.list(tmpDirectory)) {
            files.forEach(System.out::println);
        }

        System.out.println("\nPrinting with Files.newDirectoryStream");
        try (var files = Files.newDirectoryStream(tmpDirectory, "*.txt")) {
            files.forEach(System.out::println);
        }

        System.out.println("\nPrinting with Files.walk");
        try (var files = Files.walk(tmpDirectory)) {
            files.forEach(System.out::println);
        }
    }
}
