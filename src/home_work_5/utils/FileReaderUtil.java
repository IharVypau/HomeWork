package home_work_5.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderUtil {
    private String filePath;

    public FileReaderUtil(String filePath) {
        this.filePath = filePath;
    }

    public String[] getStringsFromFile(){
        File file = new File(filePath);
        try {
            var lines = Files.readAllLines(Paths.get(file.toURI()), StandardCharsets.UTF_8);
            return lines.toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
