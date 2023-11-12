package operating.on.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class WriteAndRead {
    public static Map<String, Path> writeFile() throws IOException {
        Path utfFile = Files.createTempFile("some", ".txt");
        Files.writeString(utfFile, "this is my string ää öö üü"); // UTF 8
        System.out.println("utfFile = " + utfFile);

        Path iso88591File = Files.createTempFile("some", ".txt");
        Files.writeString(iso88591File, "this is my string ää öö üü", StandardCharsets.ISO_8859_1); // otherwise == utf8
        System.out.println("iso88591File = " + iso88591File);

        Map<String, Path> map = new HashMap<String, Path>();
        map.put("utfFile", utfFile);
        map.put("iso88591File", iso88591File);

        return map;
    }

    public static void readFile() throws IOException {
        Map<String, Path> map = writeFile();
        String s = Files.readString(map.get("utfFile"));// UTF 8
        System.out.println("s = " + s);

        s = Files.readString(map.get("iso88591File"), StandardCharsets.ISO_8859_1); // otherwise == utf8
        System.out.println("s = " + s);

    }

}
